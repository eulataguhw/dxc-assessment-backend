package com.dxc.login.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.dxc.login.models.Role;
import com.dxc.login.models.User;
import com.dxc.login.payload.response.RoleResponse;
import com.dxc.login.repository.RoleRepository;
import com.dxc.login.services.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    User user;


    @GetMapping("/getRole")
    public ResponseEntity<?> getAllRoles() {
      try {

            List<Role> roles = new ArrayList<>();

            roleRepository.findAll().forEach(roles::add);

          if (roles.isEmpty()) {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          
          return new ResponseEntity<>(roles, HttpStatus.OK);
      }  catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
