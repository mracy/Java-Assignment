package com.simpleform2.service;

import com.simpleform2.model.UsersModel;
import com.simpleform2.repository.UsersRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String login, String password, String email) {
        if (login == null || password == null || email == null) {
            return null;
        } else {

            if (usersRepository.findFirstByLogin(login).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }

            if (usersRepository.findFirstByLogin(email).isPresent()) {
                System.out.println("Duplicate email");
                return null;
            }

            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);

        }
    }

    public UsersModel authenticate(String login, String password) {
        if (login == null) {
            return null;
        } else {
            Optional<UsersModel> user = usersRepository.findByLoginAndPassword(login, password);
            if (user.isPresent()) {
                return user.get();
            } else {
                return null;
            }
        }
    }
}