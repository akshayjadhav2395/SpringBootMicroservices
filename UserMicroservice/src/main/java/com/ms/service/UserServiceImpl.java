package com.ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.model.User;

@Service
public class UserServiceImpl implements UserServiceI{

	List<User> list = List.of(
            new User(11L, "Akshay", "9248494004"),
            new User(12L, "Sam", "9849948474"),
            new User(13L, "John", "8880987223")
    );

    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }

}
