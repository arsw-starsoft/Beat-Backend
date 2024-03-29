package edu.eci.arsw.beatApp.services.impl;

import java.util.ArrayList;
import java.util.List;


import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.beatApp.model.Car;
import edu.eci.arsw.beatApp.model.Coordinate;
import edu.eci.arsw.beatApp.model.Driver;
import edu.eci.arsw.beatApp.model.Servicio;
import edu.eci.arsw.beatApp.persistence.DriverRepository;
import edu.eci.arsw.beatApp.persistence.ServicioRepository;
import edu.eci.arsw.beatApp.services.ServicioServices;

@Service
public class ServicioServicesImpl implements ServicioServices {

    @Autowired
    private ServicioRepository serviceRepository;

    @Autowired
    private DriverRepository driverRepository;

    private int numeroServicios =1;
    @Override
    public List<Servicio> getAllServices(Coordinate coordinate) {
        List<Servicio> posibles = new ArrayList<>();
        List<Driver> drivers = driverRepository.findAll();
        for (int i = 0 ; i< numeroServicios ; i++){
            Driver driver = drivers.get(i);           
            List<Car> cars = new ArrayList<>();
            Car car = driver.getCars().get(0);
            car.setCoordinate(coordinate);
            System.out.println(coordinate.getLatitude());
            cars.add(car);
            driver.setCars(cars);
            driverRepository.save(driver);
            Servicio ser =  new Servicio();
            ser.setDriver(driver);
            serviceRepository.save(ser);
            posibles.add(ser);
        }

        return posibles;
    }

    @Override
    public void saveService(Servicio servicio) {
        serviceRepository.save(servicio);
    }

    @Override
    public Servicio getGenerateService(Servicio service) {
        Double maxPrecio = 40000.0; //pesos
        Double minPrecio = 3000.0;
        Double maxDuracion = 50.0; //minutos 
        Double minDuracion = 5.0;
        Double maxDistacia = 30.0; // km
        Double minDistancia = 5.0;
        Double doublePrecio = (Math.random() * ((maxPrecio - minPrecio) + 1)) + minPrecio;
        Double doubleDuracion = (Math.random() * ((maxDuracion - minDuracion) + 1)) + minDuracion;
        Double doubleDistancia = (Math.random() * ((maxDistacia - minDistancia) + 1)) + minDistancia;
        service.setPrice(DoubleRounder.round(doublePrecio,2));
        service.setDuration(DoubleRounder.round(doubleDuracion,2));
        service.setDistance(DoubleRounder.round(doubleDistancia,2));
        return service;
    }

    @Override
    public Double getPriceDestino(String destino) {
        Double maxPrecio = 50000.0;
        Double minPrecio = 2000.0;
        Double doublePrecio = (Math.random() * ((maxPrecio - minPrecio) + 1)) + minPrecio;
        return doublePrecio;
    }

}
