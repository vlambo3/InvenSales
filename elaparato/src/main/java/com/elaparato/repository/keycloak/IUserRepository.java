package com.elaparato.repository.keycloak;

import com.elaparato.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    List<User> findByUserName(String userName);
}
