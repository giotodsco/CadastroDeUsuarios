package com.example.cadastroDeUsuarios.repository;

import com.example.cadastroDeUsuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
