package edu.eci.arsw.beatApp.services.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.beatApp.model.Customer;
import edu.eci.arsw.beatApp.persistence.BeatAppApplicationPersistenceException;
import edu.eci.arsw.beatApp.persistence.UserRepository;
import edu.eci.arsw.beatApp.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;



    @Override
    public List<Customer> getAllUsers() throws BeatAppApplicationPersistenceException {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(Customer customer) throws BeatAppApplicationPersistenceException {
        Optional<Customer> optionalCustomer = userRepository.findByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new BeatAppApplicationPersistenceException(BeatAppApplicationPersistenceException.CUSTOMER_ALREDY_EXISTS);
        } else {
            userRepository.save(customer);
        }

    }

    @Override
    public Customer findUserByEmail(String user) throws BeatAppApplicationPersistenceException {
        Optional<Customer> optinalUser = userRepository.findByEmail(user);
        boolean present = optinalUser.isPresent();
        System.out.println(present);
        if (!present)
            throw new BeatAppApplicationPersistenceException(BeatAppApplicationPersistenceException.CUSTOMER_NOT_FOUND);
        return optinalUser.get();
    }
    
    

    @Override
    public void updateUser(String user, Customer customer) throws BeatAppApplicationPersistenceException {
        Optional<Customer> optinalUser = userRepository.findByEmail(user);
        boolean present = optinalUser.isPresent();
        if (!present){
            throw new BeatAppApplicationPersistenceException(BeatAppApplicationPersistenceException.CUSTOMER_NOT_FOUND);
        }else{
            Customer cus = optinalUser.get();
            cus.setCellPhone(customer.getCellPhone());
            cus.setFirstName(customer.getFirstName());
            cus.setLastName(customer.getLastName());
            cus.setName(customer.getUserName());
            cus.setPassword(customer.getPassword());
            userRepository.save(cus);
        }
        
    }

}
