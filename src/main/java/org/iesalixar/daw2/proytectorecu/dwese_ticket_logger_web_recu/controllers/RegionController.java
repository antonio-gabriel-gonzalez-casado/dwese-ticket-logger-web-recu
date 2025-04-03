package org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.controllers;

import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.daos.RegionDAO;
import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.entities.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("region", new Region());  // Pasamos un objeto vacío a la vista
        return "region-form";  // Nombre de la vista del formulario
    }

    /**
     * Inserta una nueva región en la base de datos.
     *
     * @param region              Objeto que contiene los datos del formulario.
     * @param redirectAttributes  Atributos para mensajes flash de redirección.
     * @return Redirección a la lista de regiones.
     */
    @PostMapping("/insert")
    public String insertRegion(@ModelAttribute("region") Region region, RedirectAttributes redirectAttributes) {
        logger.info("Insertando nueva región con código {}", region.getCode());
        if (regionDAO.existsRegionByCode(region.getCode())) {
            logger.warn("El código de la región {} ya existe.", region.getCode());
            redirectAttributes.addFlashAttribute("errorMessage", "El código de la región ya existe.");
            return "redirect:/regions/new";
        }
        regionDAO.insertRegion(region);
        logger.info("Región {} insertada con éxito.", region.getCode());
        return "redirect:/regions"; // Redirigir a la lista de regiones
    }

    /**
     * Muestra el formulario para editar una región existente.
     *
     * @param id    ID de la región a editar.
     * @param model Modelo para pasar datos a la vista.
     * @return El nombre de la plantilla Thymeleaf para el formulario.
     */
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
        logger.info("Mostrando formulario de edición para la región con ID {}", id);
        Region region = null;

        region = regionDAO.getRegionById(id);
        if (region == null) {
            logger.warn("No se encontró la región con ID {}", id);
            redirectAttributes.addFlashAttribute("errorMessage", "No se encontró la región con ID "+ id);
            return "redirect:/regions";
        }

        model.addAttribute("region", region);
        return "region-form"; // Nombre de la plantilla Thymeleaf para el formulario
    }

    /**
     * Actualiza una región existente en la base de datos.
     *
     * @param region              Objeto que contiene los datos del formulario.
     * @param redirectAttributes  Atributos para mensajes flash de redirección.
     * @return Redirección a la lista de regiones.
     */
    @PostMapping("/update")
    public String updateRegion(@ModelAttribute("region") Region region, RedirectAttributes redirectAttributes) {
        logger.info("Actualizando región con ID {}", region.getId());

        if (regionDAO.existsRegionByCodeAndNotId(region.getCode(), region.getId())) {
            logger.warn("El código de la región {} ya existe para otra región.", region.getCode());
            redirectAttributes.addFlashAttribute("errorMessage", "El código de la región ya existe para otra región.");
            return "redirect:/regions/edit?id=" + region.getId();
        }
        regionDAO.updateRegion(region);
        logger.info("Región con ID {} actualizada con éxito.", region.getId());
        return "redirect:/regions"; // Redirigir a la lista de regiones
    }


    /**
     * Elimina una región de la base de datos.
     *
     * @param id                 ID de la región a eliminar.
     * @param redirectAttributes Atributos para mensajes flash de redirección.
     * @return Redirección a la lista de regiones.
     */
    @PostMapping("/delete")
    public String deleteRegion(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        logger.info("Eliminando región con ID {}", id);

        regionDAO.deleteRegion(id);
        logger.info("Región con ID {} eliminada con éxito.", id);


        redirectAttributes.addFlashAttribute("errorMessage", "Región con eliminada con éxito.");


        return "redirect:/regions"; // Redirigir a la lista de regiones
    }






}
