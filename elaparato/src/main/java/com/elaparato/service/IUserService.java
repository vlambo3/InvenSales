package com.elaparato.service;

import com.elaparato.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    List<User> findByUserName(String userName);
}
