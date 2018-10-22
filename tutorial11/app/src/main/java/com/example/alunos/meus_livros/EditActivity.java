package com.example.alunos.meus_livros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditActivity extends AppCompatActivity {
    private EditText editTitulo;
    private EditText editAutor;
    private EditText editEditora;
    private Button Salvar
    private int id;
    public static final String ID_REPLY = "com.example.android.livrosql.ID_REPLY"
    public static final String TITLE_REPLY = "com.example.adnroid.livrosql.TITLE_REPLY";
    public static final String AUTOR_REPLY = "com.example.adnroid.livrosql.AUTOR_REPLY";
    public static final String EDITORA_REPLY = "com.example.adnroid.livrosql.EDITORA_REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addActivity);

        Intent sentData = getIntent();
        final Livro current = sentData.getParcelableExtra("livro");
        id = current.getId();
        editTitulo = findViewById(R.id.txtTitulo);
        editAutor = findViewById(R.id.txtAutor);
        editEditora = findViewById(R.id.txtEditora);
        editTitulo.setText(curent.getTitulo());
        editAutor.setText(curent.getAutor());
        editEditora.setText(current.getEditora());
        Salvar = findViewById(R.id.btnSalvar);

        Salvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(editTitulo.getText()) || TextUtils.isEmpty(editAutor.getText()) || TextUtils.isEmpty(editEditora.getText()) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    Livro alterado = new Livro(current.getId,
                            editTitulo.getText().toString(),
                            editAutor.getText().toString(),
                            editEditora.getText().toString());
                    replyIntent.putExtra("livro", alterado);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}