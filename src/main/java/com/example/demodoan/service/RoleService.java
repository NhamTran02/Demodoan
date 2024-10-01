package com.example.demodoan.service;

import com.example.demodoan.model.Role;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleById(Long id) throws RoleNotFoundException;
}
