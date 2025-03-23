package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private IUserRpository userRepository;

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    // Método para obtener un usuario por ID
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<UserModel> updateUser(Long id, UserModel request) {
        System.out.println("Attempting to update user with ID: " + id);
        Optional<UserModel> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setIniciales(request.getIniciales());
            user.setSucursal(request.getSucursal());
            user.setPassword(request.getPassword());
            user.setRol(request.getRol());
            return Optional.of(userRepository.save(user));
        } else {
            System.out.println("User not found with ID: " + id);
        }

        return Optional.empty();
    }


    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar el usuario con id " + id + ": " + e.getMessage());
            return false;
        }
    }
}

