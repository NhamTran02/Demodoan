package com.example.demodoan.controller;

import com.example.demodoan.model.Role;
import com.example.demodoan.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @GetMapping("/getall")
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok().body(roleServiceImpl.getAllRole());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id) throws RoleNotFoundException {
        return ResponseEntity.ok().body(roleServiceImpl.getRoleById(id));
    }

}
