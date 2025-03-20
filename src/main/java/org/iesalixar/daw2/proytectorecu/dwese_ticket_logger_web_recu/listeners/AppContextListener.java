package org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.dao.DatabaseConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppContextListener implements ServletContextListener {

    // Logger para trazar eventos usando SLF4J
    private static final Logger logger = LoggerFactory.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Iniciamos la conexión a la base de datos al arrancar la aplicación
        logger.info("Inicializando la aplicación y conectando a la base de datos...");
        DatabaseConnectionManager.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cerramos la conexión a la base de datos cuando se destruye el contexto
        logger.info("Cerrando la conexión a la base de datos al apagar la aplicación...");
        DatabaseConnectionManager.closeConnection();
    }



}
