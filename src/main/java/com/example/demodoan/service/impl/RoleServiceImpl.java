package com.example.demodoan.service.impl;

import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Role;
import com.example.demodoan.repository.RoleRepository;
import com.example.demodoan.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList=roleRepository.findAll();
        return roleList;
    }

    @Override
    public Role getRoleById(Long id) throws RoleNotFoundException {
        Role role=roleRepository.findById(id).get();
        if(role==null){
            throw new ResourceNotFoundException(ErrorCode.ROLE_NOT_FOUND);
        }
        return role;
    }
}
