package com.example.quoteProject20.UserController;

import com.example.quoteProject20.Dto.ApiResponse;
import com.example.quoteProject20.Dto.UserResigsterRequest;
import com.example.quoteProject20.Model.User;
import com.example.quoteProject20.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserControl {
private final UserService userService;



    public UserControl(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserResigsterRequest userResigsterRequest){
        return new ResponseEntity<>(new ApiResponse( 201, true, "CREATED SUCCESSFULLY", List.of(userService.createUser(userResigsterRequest))), HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
  
}
