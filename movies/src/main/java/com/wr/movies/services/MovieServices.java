package com.wr.movies.services;

import com.wr.movies.entities.Movie;
import com.wr.movies.repositories.MovieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {

    @Autowired
    private MovieRepositories repository;

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie findById(Long id){
        Optional<Movie> obj = repository.findById(id);
        return obj.orElseThrow();
    }

    public Movie add(final Movie movie){
        return repository.save(movie);
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    public Movie update(Long id, Movie movie){
        Movie m = repository.getReferenceById(id);
        updateData(m, movie);
        return repository.save(m);

    }
    private void updateData(Movie m, Movie movie){
        m.setTitulo(movie.getTitulo());
        m.setComentario(movie.getComentario());
        m.setNota(movie.getNota());
    }
}
