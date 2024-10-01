package com.example.demodoan.service.impl;

import com.example.demodoan.dto.UserDTO;
import com.example.demodoan.model.Role;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.RoleRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        Optional<User> optionalUser=userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()){
            throw new DataIntegrityViolationException("Email already exists");
        }
        Role role= roleRepository.findById(userDTO.getRole()).orElseThrow(()-> new Exception("Role not found"));
        if (role.getName().toUpperCase().equals("ADMIN")){
            throw new Exception("You cannot register a admin account");
        }
        User user=User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        Optional<User> optionalUser=userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new DataIntegrityViolationException("Invalid phonenumber / password");
        }
        return "token";
    }

    @Override
    public User updateUser(Long id,UserDTO userDTO) throws Exception {
        // Tìm kiếm user theo email, nếu không tìm thấy sẽ ném Exception
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Cannot find user with this email: " + userDTO.getEmail()));

        // Tìm kiếm role theo ID, nếu không tìm thấy sẽ ném Exception
        Role role = roleRepository.findById(userDTO.getRole())
                .orElseThrow(() -> new Exception("Role not found"));

        // Sử dụng Builder để tạo đối tượng User mới với các trường được cập nhật
        User updatedUser = User.builder()
                .id(existingUser.getId())
                .username(userDTO.getUsername())
                .email(existingUser.getEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(role)
                .build();
        updatedUser.setCreateAt(existingUser.getCreateAt());
        updatedUser.setUpdateAt(existingUser.getUpdateAt());

        // Lưu lại thông tin User đã cập nhật
        return userRepository.save(updatedUser);
    }
}
