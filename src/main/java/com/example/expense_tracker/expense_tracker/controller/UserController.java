package com.example.expense_tracker.expense_tracker.controller;


import com.example.expense_tracker.expense_tracker.dto.LoginDTO;
import com.example.expense_tracker.expense_tracker.model.User;
import com.example.expense_tracker.expense_tracker.service.UserServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {

    UserServices userServices;

    UserController(UserServices userServices){

        this.userServices=userServices;
    }


    @PostMapping("/register")
    public ResponseEntity<String> Register(@Valid  @RequestBody User user){

        userServices.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }


    @PostMapping("/login")
    public ResponseEntity<String> Login(@Valid @RequestBody LoginDTO loginDTo){

        userServices.getuser(loginDTo);
        return ResponseEntity.ok("Login Successfully");
    }



}
