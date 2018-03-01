package com.example.alunos.atividade2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.Scanner;

public class Atividade2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);
    }
    public void mudaTexto(View v){
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        etiqueta.setText(getResources().getString(R.string.lblHello2));
    }
}
