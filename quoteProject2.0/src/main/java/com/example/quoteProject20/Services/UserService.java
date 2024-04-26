package com.example.quoteProject20.Services;

import com.example.quoteProject20.Dto.UserMinResponse;
import com.example.quoteProject20.Dto.UserResigsterRequest;
import com.example.quoteProject20.ENUMS.Role;
import com.example.quoteProject20.Model.User;
import com.example.quoteProject20.Respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserMinResponse createUser(UserResigsterRequest userResigsterRequest){
        isUserAlreadyExists(userResigsterRequest.email());
        return mapUserToUserMinResponse(userRepository.save(mapUserResgisterRequestToUser(userResigsterRequest)));
    }

    private UserMinResponse mapUserToUserMinResponse(User user){
        return new UserMinResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername());
    }

    private void isUserAlreadyExists(String email){
        User user = userRepository.findByUsername(email).orElse(null);

        if(user != null)throw new RuntimeException("Email Already In Use");
    }

    private  User mapUserResgisterRequestToUser(UserResigsterRequest userResigsterRequest){
        return User.builder()
                .firstName(userResigsterRequest.firstName())
                .lastName(userResigsterRequest.lastName())
                .email(userResigsterRequest.email())
                .username(userResigsterRequest.email())
                .password(userResigsterRequest.password())
                .role(Role.USER)
                .build();
    }

    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }
}
