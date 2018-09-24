package com.gmail.rogov.service;

import com.gmail.rogov.service.model.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO create(UserDTO user);

    UserDTO update(UserDTO user);

    UserDTO findUserByEmail(String email);

    UserDTO findUserById(Long id);

    UserDTO delete(UserDTO user);

    List<UserDTO> findAll();
}
