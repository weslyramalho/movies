package com.wr.movies.repositories;

import com.wr.movies.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long> {
}
