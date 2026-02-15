package com.example.cadastroDeUsuarios.dto;

import com.example.cadastroDeUsuarios.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record UserResponseDTO(Long id, String name, int years, String document, String email) {

    public UserResponseDTO(User user){
        this(
                user.getId(),
                user.getName(),
                user.getYears(),
                user.getDocument(),
                user.getEmail()
        );
    }
}
