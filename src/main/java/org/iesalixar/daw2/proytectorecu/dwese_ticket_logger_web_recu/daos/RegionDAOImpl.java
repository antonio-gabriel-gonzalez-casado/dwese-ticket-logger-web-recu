package org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.daos;

import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.entities.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDAOImpl implements RegionDAO {

    // Logger para registrar eventos importantes en el DAO
    private static final Logger logger = LoggerFactory.getLogger(RegionDAOImpl.class);

    private final JdbcTemplate jdbcTemplate;

    // Inyección de JdbcTemplate
    public RegionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Lista todas las regiones de la base de datos.
     * @return Lista de regiones
     */
    @Override
    public List<Region> listAllRegions() {
        logger.info("Listing all regions from the database.");
        String sql = "SELECT * FROM regions";
        List<Region> regions = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Region.class));
        logger.info("Retrieved {} regions from the database.", regions.size());
        return regions;
    }



}
