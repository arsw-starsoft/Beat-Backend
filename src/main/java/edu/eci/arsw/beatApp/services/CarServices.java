package edu.eci.arsw.beatApp.services;

import java.util.List;

import edu.eci.arsw.beatApp.model.Car;
import edu.eci.arsw.beatApp.persistence.BeatAppApplicationPersistenceException;

public interface CarServices {

    List<Car> getAllCars() throws BeatAppApplicationPersistenceException;

    void saveCar(Car car) throws BeatAppApplicationPersistenceException;

    Car findCarByPlate(String plate) throws BeatAppApplicationPersistenceException;
}
