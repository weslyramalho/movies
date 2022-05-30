package com.wr.movies.repositories;

import com.wr.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepositories extends JpaRepository <Movie, Long>{
}
