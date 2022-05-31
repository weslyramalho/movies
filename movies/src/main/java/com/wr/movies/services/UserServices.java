package com.wr.movies.services;

import com.wr.movies.entities.User;
import com.wr.movies.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
@Service
public class UserServices {

    @Autowired
    private UserRepositories repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow();
    }

    public User add(final User user){
        return repository.save(user);
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    public User uptdate(Long id, User user){
        User u = repository.getReferenceById(id);
        updateData(u, user);
        return repository.save(u);
    }
    private void updateData(User u, User user){
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
    }

}
