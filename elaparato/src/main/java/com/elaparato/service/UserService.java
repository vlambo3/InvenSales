package com.elaparato.service;

import com.elaparato.model.User;
import com.elaparato.repository.keycloak.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}
