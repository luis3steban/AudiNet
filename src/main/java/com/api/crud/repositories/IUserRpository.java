package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRpository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
