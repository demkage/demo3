package com.example.demo3.auth.controller;

import com.example.demo3.auth.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by abosii on 7/17/17.
 */
@RestController
@RequestMapping("users")
public class UserController {

    @RequestMapping("/current")
    public User currentUser(@AuthenticationPrincipal Principal principal) {
        return (User) principal;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
