package com.example.cadastroDeUsuarios.controller;

import com.example.cadastroDeUsuarios.dto.LoginRequestDTO;
import com.example.cadastroDeUsuarios.dto.LoginResponseDTO;
import com.example.cadastroDeUsuarios.dto.UserRequestDTO;
import com.example.cadastroDeUsuarios.dto.UserResponseDTO;
import com.example.cadastroDeUsuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO requestDTO){
        UserResponseDTO responseDTO = service.createUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listAll(){
        List<UserResponseDTO> list = service.listAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> listId(@PathVariable Long id){
        UserResponseDTO user = service.listId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> uptadeiD(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = service.uptadeId(id, userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteId(@PathVariable Long id){
         service.deleteId(id);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deletado");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO user = service.authentiction(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }
}
