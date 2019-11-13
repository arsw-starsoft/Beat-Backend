package edu.eci.arsw.beatApp.services;

import java.util.List;

import edu.eci.arsw.beatApp.model.Customer;
import edu.eci.arsw.beatApp.persistence.BeatAppApplicationPersistenceException;

public interface UserServices {

    List<Customer> getAllUsers() throws BeatAppApplicationPersistenceException;

    void saveUser(Customer customer) throws BeatAppApplicationPersistenceException;

    Customer findUserByEmail(String email) throws BeatAppApplicationPersistenceException;

    void updateUser(String user, Customer customer) throws BeatAppApplicationPersistenceException;

}
