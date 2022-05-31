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
    private Long nota;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Movie() {
    }

    public Movie(Long id, String titulo, Long nota, String comentario, User user) {
        this.id = id;
        this.titulo = titulo;
        this.nota = nota;
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

    public Long getNota() {
        return nota;
    }

    public void setNota(Long nota) {
        this.nota = nota;
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
