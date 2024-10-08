package com.example.demodoan.service.impl;

import com.example.demodoan.dto.request.UserDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Role;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.RoleRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return  username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        Optional<User> optionalUser=userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()){
            throw new ResourceNotFoundException(ErrorCode.EMAIL_EXISTS);
        }
        Optional<User> optional=userRepository.findByUsername(userDTO.getUsername());
        if(optional.isPresent()){
            throw new ResourceNotFoundException(ErrorCode.USERNAME_EXISTS);
        }
        Role role= roleRepository.findById(userDTO.getRole()).orElseThrow(()-> new ResourceNotFoundException(ErrorCode.ROLE_NOT_FOUND));
        if (role.getName().toUpperCase().equals("ADMIN")){
            throw new ResourceNotFoundException(ErrorCode.REGISTER_ACCOUNT_ADMIN);
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id,UserDTO userDTO) throws Exception {
        // Tìm kiếm user theo email, nếu không tìm thấy sẽ ném Exception
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.EMAIL_NOT_FOUND));

        // Tìm kiếm role theo ID, nếu không tìm thấy sẽ ném Exception
        Role role = roleRepository.findById(userDTO.getRole())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ROLE_NOT_FOUND));

        // Sử dụng Builder để tạo đối tượng User mới với các trường được cập nhật
        User updatedUser = User.builder()
                .username(userDTO.getUsername())
                .email(existingUser.getEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(role)
                .build();
        updatedUser.setId(existingUser.getId());
        updatedUser.setCreateAt(existingUser.getCreateAt());
        updatedUser.setUpdateAt(LocalDate.now());

        // Lưu lại thông tin User đã cập nhật
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if(!optionalUser.isEmpty()){
            throw new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(optionalUser.get().getId());
    }
}
