/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.managers;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.Connection;
import org.centrale.hceres.repositories.ConnectionRepository;
import org.centrale.tools.Utilities;

/**
 *
 * @author ECN
 */
public class SecurityManager {

    /**
     * Get current connected user
     * @param request
     * @param connectionRepository
     * @return 
     */
    public static Connection getCurrentConnection(HttpServletRequest request, ConnectionRepository connectionRepository) {
        connectionRepository.removeOld();

        Connection connectedUser = null;
        String code = Utilities.getRequestString(request, "connectionCode");
        if ((code != null) && (!code.isEmpty())) {
            Optional<Connection> connectedUserResult = connectionRepository.findById(code);
            if (connectedUserResult.isPresent()) {
                connectedUser = connectedUserResult.get();
                connectionRepository.expand(connectedUser);
            }
        }
        return connectedUser;
    }

}
