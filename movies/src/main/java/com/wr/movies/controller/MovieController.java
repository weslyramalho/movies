package com.wr.movies.controller;

import com.wr.movies.entities.Movie;
import com.wr.movies.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieServices services;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        Movie obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Movie> insert(@RequestBody Movie movie){
        movie = services.add(movie);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(uri).body(movie);
    }
}
