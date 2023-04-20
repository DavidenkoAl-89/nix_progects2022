package com.nixsolution.ppp.servlet_jsp.servlet;

import com.nixsolution.ppp.servlet_jsp.connection.ConnectionManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.h2.tools.RunScript;
import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import static com.nixsolution.ppp.servlet_jsp.util.SqlCommand.*;

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger LOG = LogManager.getLogger(AppContextListener.class);
    private Server server;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            server = Server.createTcpServer().start();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
        }
        ConnectionManager connectionManager = new ConnectionManager(RESOURCES_PATH);
        try (Connection connection = connectionManager.getDbConnection()) {

            RunScript.execute(connection, new InputStreamReader(Objects.requireNonNull(this.getClass()
                    .getResourceAsStream("/tables.sql"))));
            RunScript.execute(connection, new InputStreamReader(Objects.requireNonNull(this.getClass().
                    getResourceAsStream("/addUserAndRole.sql"))));
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (server != null) {
            server.stop();
        }
    }
}
