package com.simpleform2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.simpleform2.model.UsersModel;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    @Query(value = "SELECT u FROM UsersModel u WHERE u.login = :login AND u.password = :password", nativeQuery = false)
    Optional<UsersModel> findByLoginAndPassword(String login, String password);

    Optional<UsersModel> findFirstByLogin(String login);
}