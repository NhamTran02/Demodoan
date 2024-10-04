package com.example.demodoan.service;

import com.example.demodoan.dto.request.UserDTO;
import com.example.demodoan.model.User;

public interface UserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String email, String password);
    User updateUser(Long id,UserDTO userDTO) throws Exception;
}
