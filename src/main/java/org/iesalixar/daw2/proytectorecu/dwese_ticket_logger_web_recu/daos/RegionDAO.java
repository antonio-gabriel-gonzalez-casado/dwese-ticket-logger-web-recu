package org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.daos;

import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.entities.Region;

import java.util.List;

public interface RegionDAO {

    List<Region> listAllRegions();

    void insertRegion(Region region);

    boolean existsRegionByCode(String code);

    Region getRegionById(int id);

    boolean existsRegionByCodeAndNotId(String code, int id);

    void updateRegion(Region region);

    void deleteRegion(int id);
}
