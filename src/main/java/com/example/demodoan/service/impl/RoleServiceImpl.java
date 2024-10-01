package com.example.demodoan.service.impl;

import com.example.demodoan.model.Role;
import com.example.demodoan.repository.RoleRepository;
import com.example.demodoan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList=roleRepository.findAll();
        return roleList;
    }

    @Override
    public Role getRoleById(Long id) throws RoleNotFoundException {
        Role role=roleRepository.findById(id).get();
        if(role==null){
            throw new RoleNotFoundException("Cannot find role with id: "+id);
        }
        return role;
    }
}
