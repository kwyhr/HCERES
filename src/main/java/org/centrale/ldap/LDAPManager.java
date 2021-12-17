/* --------------------------------------------------------------------------------
 * Astrolab General Tools
 * 
 * Ecole Centrale Nantes - Septembre 2015
 * Equipe pédagogique Informatique et Mathématiques
 * JY Martin, Q Roques
 * -------------------------------------------------------------------------------- */
package org.centrale.ldap;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 * Manage LDAP communication
 *
 * @author kwyhr
 */
public class LDAPManager {

    private static String ldapBasedn;
    private static String ldapHost;
    private static String ldapsecurityprotocol;
    private static boolean ldapAvailable;

    /**
     *
     * @param serverName
     * @param serverDN
     * @param serverProtocol
     */
    public static void init(String serverName, String serverDN, String serverProtocol) {
        ldapHost = serverName;
        ldapBasedn = serverDN;
        ldapsecurityprotocol = serverProtocol;
        if ((serverName != null) && (serverDN != null) && (serverProtocol != null)
                && (!serverName.isEmpty()) && (!serverDN.isEmpty())) {
            ldapAvailable = true;
        } else {
            ldapAvailable = false;
        }
    }

    /**
     *
     */
    public LDAPManager() {
        
    }
    
    /**
     * Build LDAP properties for a BIND
     *
     * @return
     */
    private Properties getLDAPProperties() {
        Properties env = new Properties();
        // Add server
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapHost);
        if (ldapsecurityprotocol.equals("ssl")) {
            // Add SSL encription
            env.put(Context.SECURITY_PROTOCOL, "ssl");
            // Use locally defined socked manager to avoid certificate validation
            env.put("java.naming.ldap.factory.socket", "org.centrale.ldap.MySSLSocketFactory");
        }

        return env;
    }

    /**
     * Build LDAP properties for a BIND
     *
     * @param field
     * @param fieldContent
     * @param password
     * @return
     */
    private Properties getLDAPProperties(String field, String fieldContent, String password) {
        Properties env = getLDAPProperties();

        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, field + "=" + fieldContent + "," + ldapBasedn);
        env.put(Context.SECURITY_CREDENTIALS, password);

        return env;
    }

    /**
     * Build LDAP properties for a BIND
     *
     * @param login
     * @param password
     * @return
     */
    private Properties getLDAPProperties(String login, String password) {
        return getLDAPProperties("uid", login, password);
    }

    /**
     * Identify with a LDAP BIND
     *
     * @param login
     * @param password
     * @return
     */
    public boolean identifyLDAP(String login, String password) {
        boolean isIdentified = false;
        if (ldapAvailable) {
            try {
                Properties env = getLDAPProperties(login, password);
                if (login != null && password != null) {
                    DirContext ctx = new InitialDirContext(env);
                    isIdentified = true;
                    ctx.close();
                }
            } catch (AuthenticationException ex) {
                // Non reconnu
            } catch (CommunicationException ex) {
                if (ldapAvailable) {
                    Logger.getLogger(LDAPManager.class.getName()).log(Level.SEVERE, null, ex);
                } else {
                    ldapAvailable = false;
                }
            } catch (NamingException ex) {
                // Non reconnu
            }
        }

        return isIdentified;
    }
}
