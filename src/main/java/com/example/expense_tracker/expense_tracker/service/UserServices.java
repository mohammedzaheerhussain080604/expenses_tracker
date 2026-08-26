package com.example.expense_tracker.expense_tracker.service;


import com.example.expense_tracker.expense_tracker.dto.LoginDTO;
import com.example.expense_tracker.expense_tracker.exception.ExpenseNotFoundException;
import com.example.expense_tracker.expense_tracker.exception.UserNotFoundException;
import com.example.expense_tracker.expense_tracker.model.User;
import com.example.expense_tracker.expense_tracker.repository.userRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {


   userRepo userRepo;

   PasswordEncoder passwordEncoder;

   UserServices(userRepo userRepo,PasswordEncoder passwordEncoder){

       this.userRepo=userRepo;
       this.passwordEncoder=passwordEncoder;
   }


    public void createUser(User user) {

       String hashespassword = passwordEncoder.encode(user.getPassword());

       user.setPassword(hashespassword);
       userRepo.save(user);



    }

    public void getuser(LoginDTO loginDTO) {

        User user = userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new UserNotFoundException(" user not found"));


        if (!passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())) {
            throw new UserNotFoundException();
        }
    }


}

