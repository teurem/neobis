package com.example.onlinecarshop.controller;

import com.example.onlinecarshop.dto.UserDTO;
import com.example.onlinecarshop.entity.UserEntity;
import com.example.onlinecarshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser() {
        List<UserDTO> users = userService.getAllUser();
        System.out.println("users: " +users);
        return users;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        UserDTO user = userService.getUserById(userId);
        System.out.println("userId: "+userId+" : user : "+user);
        return user;
    }

    @PostMapping
    public String saveUser(@RequestBody UserEntity user)
    {
        userService.saveUser(user);
        return "user saved successfuly.";
    }

    @PutMapping("/{userId}")
    public String updateUser(@RequestBody UserEntity user, @PathVariable Long userId){
        userService.updateUser(user, userId);
        return "user updated succeddfuly.";
    }

    @DeleteMapping("/{userId}")
    public String deleteUserId(@PathVariable Long userId){
        userService.deleteUserId(userId);
        return "user deleted successfuly.";
    }
}
