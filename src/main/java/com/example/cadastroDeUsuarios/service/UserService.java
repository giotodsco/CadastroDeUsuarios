package com.example.cadastroDeUsuarios.service;

import com.example.cadastroDeUsuarios.dto.UserRequestDTO;
import com.example.cadastroDeUsuarios.dto.UserResponseDTO;
import com.example.cadastroDeUsuarios.model.User;
import com.example.cadastroDeUsuarios.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository userRepository){
        this.repository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = new User(userRequestDTO);
        User userSalvo = repository.save(user);

        return new UserResponseDTO(userSalvo);
    }

    public List<UserResponseDTO> listAll(){
        return repository.findAll().stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    public UserResponseDTO listId(Long id){
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User não encontrado"));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO uptadeId(Long id, UserRequestDTO userRequestDTO){
        User userAlterado = repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));

        userAlterado.setId(userAlterado.getId());
        userAlterado.setName(userRequestDTO.name());
        userAlterado.setYears(userRequestDTO.years());
        userAlterado.setDocument(userRequestDTO.document());
        userAlterado.setEmail(userRequestDTO.email());
        userAlterado.setPassword(userRequestDTO.password());

        repository.save(userAlterado);
        return new UserResponseDTO(userAlterado);

    }

    public void deleteId(Long id){
        repository.deleteById(id);
    }
}
