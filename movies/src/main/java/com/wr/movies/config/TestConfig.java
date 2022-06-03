package com.wr.movies.config;

import com.wr.movies.entities.Movie;
import com.wr.movies.entities.User;
import com.wr.movies.repositories.MovieRepositories;
import com.wr.movies.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private MovieRepositories movieRepositories;

    @Override
    public void run(String... args) throws Exception {
        User s1 = new User(null,"ana", "ana@gmail.com", "123456");
        User s2 = new User(null,"Paula", "paula@gmail.com", "123456");
        User s3 = new User(null,"Antonio", "antonio@gmail.com", "123456");
        User s4 = new User(null,"Joao", "joao@gmail.com", "123456");

        userRepositories.saveAll(Arrays.asList(s1, s2, s3, s4));

        Movie m1 = new Movie(null, "Adão e Eva", 10L, "bom", s2);
        Movie m2 = new Movie(null, "tARZAN", 10L, "bom", s1);
        Movie m3 = new Movie(null, "Maroba", 10L, "bom", s3);
        Movie m4 = new Movie(null, "luAR", 10L, "bom", s4);

        movieRepositories.saveAll(Arrays.asList(m1, m2, m3, m4));


    }
}
