package com.simpleform2.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "users_table")
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer Id;

    
    String login;

    
    
    String email;

    String password;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, login, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsersModel other = (UsersModel) obj;
        return Objects.equals(Id, other.Id) && Objects.equals(login, other.login) && Objects.equals(email, other.email);
    }

    @Override
    public String toString() {
        return "UsersModel [Id=" + Id + ", login=" + login + ", email=" + email + "]";
    }
}