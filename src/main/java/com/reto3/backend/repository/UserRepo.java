package com.reto3.backend.repository;

import com.reto3.backend.model.User;
import com.reto3.backend.repository.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepo {

    @Autowired
    private UserCrud userCrud;

    public List<User> getAll() {
        return (List<User>) userCrud.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrud.findById(id);
    }

    public User create(User user) {
        return userCrud.save(user);
    }

    public void update(User user) {
        userCrud.save(user);
    }

    public void delete(User user) {
        userCrud.delete(user);
    }
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrud.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrud.findByEmailAndPassword(email, password);
    }
}


