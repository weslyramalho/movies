package com.wr.movies.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Movie() {
    }

    public Movie(Long id, String titulo, String comentario, User user) {
        this.id = id;
        this.titulo = titulo;
        this.comentario = comentario;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
