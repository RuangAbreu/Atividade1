package com.example.alunos.meus_livros;

private static class updateAsyncTask extends AsyncTask extends AsyncTask<Livro, Void, Void> {
private LicroDAO mAsyncTaskDao;

private updateAsyncTask(LicroDAO dao) {
        mAsyncTask = dao;
        }

@Override
protected Void doInBackground(Livro... params) {
        mAsyncTaskDao.update(params[0]);
        return null;
        }
        }