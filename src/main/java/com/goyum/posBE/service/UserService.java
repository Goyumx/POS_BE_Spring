package com.goyum.posBE.service;

import org.springframework.stereotype.Service;

import com.goyum.posBE.entity.User;


@Service
public interface UserService {
    User createUser(User user);
}
