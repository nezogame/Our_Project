package com.ourproject.socialnetwork.controller;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.model.UserDto;
import com.ourproject.socialnetwork.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/social-network")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable("userName") String name) {
        return new ResponseEntity<>(userService.getUserByUserName(name), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto userToUpdate) {
        return new ResponseEntity<>(userService.updateUser(userToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}