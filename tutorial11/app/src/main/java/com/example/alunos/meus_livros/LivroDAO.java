package com.example.alunos.meus_livros;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LivroDAO {
    @Insert
    void insert(Livros livro);

    @Query("SELECT * FROM Livros ORDER BY titulo ASC")
    LiveData<List<Livros>> getAllLivros();

    @Update
    int update(Livro livro);
}
