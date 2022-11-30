package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.model.Contact;
import com.ms.model.User;
import com.ms.service.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserServiceI userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        User user = this.userService.getUser(userId);
      
        List<Contact> contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);


        user.setContacts(contacts);
        return user;

    }
}
