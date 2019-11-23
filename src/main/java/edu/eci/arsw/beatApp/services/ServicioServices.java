package edu.eci.arsw.beatApp.services;

import java.util.List;

import edu.eci.arsw.beatApp.model.Coordinate;
import edu.eci.arsw.beatApp.model.Servicio;

public interface ServicioServices {

    List<Servicio> getAllServices(Coordinate coordinate);

    void saveService(Servicio service);

    Servicio getGenerateService(Servicio service);

    Double getPriceDestino(String destino);

}
