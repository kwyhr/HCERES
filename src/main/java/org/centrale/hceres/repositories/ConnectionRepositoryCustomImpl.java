/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.repositories;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.Connection;
import org.centrale.hceres.items.Researcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kwyhr
 */
@Repository
public class ConnectionRepositoryCustomImpl implements ConnectionRepositoryCustom {

    private static final long DELTA = 30 * 60 * 1000L;

    @Autowired
    @Lazy
    ConnectionRepository connectionRepository;

    /**
     * Create pseudo-random code
     *
     * @param login
     * @param now
     * @return
     */
    private static String createCode(String login, Date now) {
        StringBuilder newCode = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

        for (int i = 0; i < 5; i++) {
            char c = (char) ('A' + (int) (Math.random() * 26));
            newCode.append(c);
        }
        newCode.append(login.toUpperCase().charAt(0));
        newCode.append(sdf.format(now));
        for (int i = 0; i < 3; i++) {
            char c = (char) ('A' + (int) (Math.random() * 26));
            newCode.append(c);
        }
        return newCode.toString();
    }

    /**
     *
     * @param researcher
     * @param status
     * @return
     */
    @Override
    public Connection create(Researcher researcher, int status) {
        Connection connection = null;

        if (researcher != null) {
            Calendar aCalendar = Calendar.getInstance();
            Date now = aCalendar.getTime();
            Date expire = aCalendar.getTime();
            expire.setTime(now.getTime() + DELTA);

            String newCode = createCode(researcher.getResearcherLogin(), now);

            connection = new Connection();
            connection.setConnectionCode(newCode);
            connection.setConnectionLogin(researcher.getResearcherLogin());
            connection.setConnectionExpire(expire);
            connection.setResearcherId(researcher);
            connection.setConnectionStatus(status);

            connectionRepository.save(connection);
        }

        return connection;
    }

    /**
     *
     * @return
     */
    @Override
    public Connection create() {
        Connection connection = null;

        Calendar aCalendar = Calendar.getInstance();
        Date now = aCalendar.getTime();
        Date expire = aCalendar.getTime();
        expire.setTime(now.getTime() + DELTA);

        String newCode = createCode("!", now);

        connection = new Connection();
        connection.setConnectionCode(newCode);
        connection.setConnectionLogin("admin");
        connection.setConnectionExpire(expire);
        connection.setConnectionStatus(1);

        connectionRepository.save(connection);

        return connection;
    }

    /**
     *
     */
    @Override
    public void removeOld() {
        Calendar aCalendar = Calendar.getInstance();
        Date now = aCalendar.getTime();
        Collection<Connection> liste = connectionRepository.findAllExpireBefore(now);
        connectionRepository.deleteAll(liste);
    }

    /**
     *
     * @param connection
     */
    @Override
    public void expand(Connection connection) {
        expand(connection, 0L);
    }

    /**
     *
     * @param connection
     * @param time
     */
    @Override
    public void expand(Connection connection, long time) {
        if (connection != null) {
            Calendar aCalendar = Calendar.getInstance();
            Date now = aCalendar.getTime();
            Date expire = aCalendar.getTime();
            expire.setTime(now.getTime() + time + DELTA);

            if (expire.after(connection.getConnectionExpire())) {
                connection.setConnectionExpire(expire);
                connectionRepository.save(connection);
            }
        }
    }
    
    /**
     *
     * @param connection
     */
    @Override
    public void remove(Connection connection) {
        if (connection != null) {
            connectionRepository.delete(connection);
        }
    }
}
