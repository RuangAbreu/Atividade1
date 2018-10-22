package com.example.alunos.meus_livros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final LivroListAdapter adapter = new LivroListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = ViewModelProviders.of(this).get(LivroViewModel.class);
        viewModel.getAllLivros().observe(this, new Observer<List<Livro>>() {
            @Override
            public void onChaged(@Nullable List<Livro> livros) {
                adapter.setLivros(livros);
            }
        }
        private LivroViewModel viewModel;

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_LIVRO_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Livro livro = new Livro(0, data.getStringExtra(AddActivity.TITTLE_REPLY),
                    data.getStringExtra(AddActivity.AUTOR_REPLY),
                    data.getStringExtra(AddActivity.EDITORA_REPLY));
            viewModel.insert(livro);
        } else {
            Toast.makeTest(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGHT_SHORT).show();
        }
    }

    public void addLivro(View v){
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivityForResult(intent, ADD_LIVRO_ACTIVITY_REQUEST_CODE);
    }

    public static final int ADD_LIVRO_ACTIVITY_REQUEST_CODE = 1;  // main activity
    beca
holder.editaLivro.setOnClickListenet(new View.OnClickListener(){ // EMBAIXO DO METODO ONBINDVIEWHOLDER NA CLASSE LIVROLISTADAPTER
        @Override
        public void onClick(View view){
            if(listaLivros!=null){
                Livro current=listaLivros.get(holder.getAdapterPosition());
                Intent intent=new Intent(context,EditActivity.class);
                intent.putExtra("livro",current);
                ((Activity)context).startActivityForResult(intent,
                        MainActivity.EDIT_LIVRO_ACTIVITY_REQUEST_CODE);
            }
        }
    });

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_LIVRO_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Livro livro = new Livro(0, data.getStringExtra(AddActivity.TITTLE_REPLY),
                    data.getStringExtra(AddActivity.AUTOR_REPLY),
                    data.getStringExtra(AddActivity.EDITORA_REPLY));
            viewModel.insert(livro);
        }else{
            Toast.makeTest(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGHT_SHORT).show();
        }
    }
}
