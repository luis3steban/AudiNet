package com.api.crud.controllers;

import com.api.crud.models.LoginRequest;
import com.api.crud.models.LoginResponse;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})  // Ajusta el origen según tu frontend

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private IUserRpository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Busca al usuario por email
        Optional<UserModel> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            // Si las credenciales son correctas, retorna más detalles del usuario en un mapa
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("id", user.get().getId());
            userDetails.put("first_name", user.get().getFirstName());
            userDetails.put("last_name", user.get().getLastName());
            userDetails.put("email", user.get().getEmail());
            userDetails.put("rol", user.get().getRol());

            return ResponseEntity.ok(userDetails);
        } else {
            // Retorna un error si las credenciales son incorrectas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contraseña incorrectos");
        }
    }
}
