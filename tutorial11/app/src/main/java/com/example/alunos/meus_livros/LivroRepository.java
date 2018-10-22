package com.example.alunos.meus_livros;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class LivroRepository {
    private LivroDAO livroDAO;
    private LiveData<List<Livros>> listaLivros;

    LivroRepository(Application application){
        LivroRoomDatabase db = LivroRoomDatabase.getDatabase(application);
        livroDAO = db.livroDAO();
        listaLivros = livroDAO.getAllLivros();
    }

    LiveData<List<Livros>> getAllLivros() {
        return listaLivros;
    }

    public void insert(Livros Livro){
        new insertAsyncTask(livroDAO).execute(Livro);
    }

    private static class insertAsyncTask extends AsyncTask<Livros, Void, Void> {

        private LivroDAO mAsyncTaskDao;

        insertAsyncTask(LivroDAO dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Livros... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
