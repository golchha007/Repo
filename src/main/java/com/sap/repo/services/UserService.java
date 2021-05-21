package com.sap.repo.services;

import com.sap.repo.models.LoginDetails;
import com.sap.repo.models.UserDetails;
import com.sap.repo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDetails> getUsers() {
        return this.userRepository.findAll();
    }

}
