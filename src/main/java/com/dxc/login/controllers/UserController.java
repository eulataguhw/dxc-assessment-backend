package com.dxc.login.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.login.models.User;
import com.dxc.login.repository.RoleRepository;
import com.dxc.login.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
  AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String username) {
      try {
          List<User> users = new ArrayList<User>();
          if (username == null){
            userRepository.findAll().forEach(users::add);
          } else {
              userRepository.findByUsername(username);
          }

          if (users.isEmpty()) {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }

          return new ResponseEntity<>(users, HttpStatus.OK);
      }  catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      
    }
}
