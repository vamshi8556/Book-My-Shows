package com.acciojobs.book_my_shows.Controllers;


import com.acciojobs.book_my_shows.Dtos.UserRequestDto;
import com.acciojobs.book_my_shows.Services.UserService;
import com.acciojobs.book_my_shows.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register/customer")
    public User CreateCustomer(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @PostMapping("/register/TheaterOwner")
    public ResponseEntity<User> CreateOwner(@RequestBody UserRequestDto userRequestDto){
    log.info(String.format("Received user request registration %s",userRequestDto.toString()));
    User user = userService.registerOwner(userRequestDto);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
