package edu.eci.arsw.beatApp.services;

import java.util.List;


import edu.eci.arsw.beatApp.model.Car;
import edu.eci.arsw.beatApp.model.Driver;
import edu.eci.arsw.beatApp.persistence.BeatAppApplicationPersistenceException;

public interface DriverServices {

    List<Driver> getAllDrivers() throws BeatAppApplicationPersistenceException;

    void saveDriver(Driver driver) throws BeatAppApplicationPersistenceException;

    Driver findDriverByEmail(String email) throws BeatAppApplicationPersistenceException;

    List<Car> findCarsByEmail(String user) throws BeatAppApplicationPersistenceException;

    void updateDriver(String user, Driver driver) throws BeatAppApplicationPersistenceException;

    void updateCar(String user, Car car) throws BeatAppApplicationPersistenceException;

}
