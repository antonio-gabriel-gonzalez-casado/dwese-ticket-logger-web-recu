package org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.controllers;

import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.daos.RegionDAO;
import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.entities.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/regions")
public class RegionController {
    private static final Logger logger = LoggerFactory.getLogger(RegionController.class);

    // DAO para gestionar las operaciones de las regiones en la base de datos
    @Autowired
    private RegionDAO regionDAO;


    /**
     * Lista todas las regiones y las pasa como atributo al modelo para que sean
     * accesibles en la vista `region.html`.
     *
     * @param model Objeto del modelo para pasar datos a la vista.
     * @return El nombre de la plantilla Thymeleaf para renderizar la lista de regiones.
     */
    @GetMapping
    public String listRegions(Model model) {
        logger.info("Solicitando la lista de todas las regiones...");
        List<Region> listRegions = null;
        listRegions = regionDAO.listAllRegions();
        logger.info("Se han cargado {} regiones.", listRegions.size());
        model.addAttribute("listRegions", listRegions); // Pasar la lista de regiones al modelo
        return "regions"; // Nombre de la plantilla Thymeleaf a renderizar
    }


}
