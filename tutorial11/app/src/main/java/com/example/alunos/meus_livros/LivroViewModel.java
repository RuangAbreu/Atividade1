package com.example.alunos.meus_livros;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class LivroViewModel extends AndroidViewModel {
    private LivroRepository repository;
    private LiveData<List<Livros>> listaLivros;

    public LivroViewModel(@NonNull Application application){
        super(application);
        repository = new LivroRepository(application);
        listaLivros = repository.getAllLivros();
    }

    public LiveData<List<Livros>> getAllLivros(){
        return repository.getAllLivros();
    }

    void insert(Livros livro){
        repository.insert(livro);
    }
}
