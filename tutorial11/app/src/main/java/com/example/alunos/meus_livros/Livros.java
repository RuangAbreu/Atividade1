package com.example.alunos.meus_livros;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Livros {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String titulo;
    private String autor;
    private String editora;

    public Livros(@NonNull int id, @NonNull String titulo, @NonNull String autor, @NonNull String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getEditora(){
        return editora;
    }
}
