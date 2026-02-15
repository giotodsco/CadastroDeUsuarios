package com.example.cadastroDeUsuarios.model;

import com.example.cadastroDeUsuarios.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int years;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    public User(UserRequestDTO user){
        this.name = user.name();
        this.years = user.years();
        this.document = user.document();
        this.email = user.email();
        this.password = user.password();
    }


}
