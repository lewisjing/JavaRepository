package com.demo.service;

import com.demo.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);
}
