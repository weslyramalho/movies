package com.wr.movies.services;

import com.wr.movies.entities.User;
import com.wr.movies.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class UserServices {

    @Autowired
    private UserRepositories repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> findById(Long id){
        return this.repository.findById(id);
    }

    public User add(final User user){
        return repository.save(user);
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    public User uptdate(Long id, User user){
        User u = repository.getOne(id);

        repository.
    }
    private void updateData(User u, User user){
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
    }

}
