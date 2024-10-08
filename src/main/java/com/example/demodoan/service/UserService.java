package com.example.demodoan.service;

import com.example.demodoan.dto.request.UserDTO;
import com.example.demodoan.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    User createUser(UserDTO userDTO) throws Exception;
    List<User> getAllUsers();
    User updateUser(Long id,UserDTO userDTO) throws Exception;
    void deleteUser(Long id);
}
