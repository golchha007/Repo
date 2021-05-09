package com.sap.repo.services;

import com.sap.repo.models.LoginDetails;
import com.sap.repo.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<LoginDetails> getLogins() {
        return this.loginRepository.findAll();
    }

    public LoginDetails createLoginDetails(LoginDetails loginDetails) {
        return this.loginRepository.save(loginDetails);
    }

    public void deleteLoginDetails(String id) {
        this.loginRepository.deleteById(id);
    }
}
