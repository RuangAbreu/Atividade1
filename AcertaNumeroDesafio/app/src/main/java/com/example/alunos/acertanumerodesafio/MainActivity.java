package com.example.alunos.acertanumerodesafio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.EditText;
import java.util.HashMap;
import android.util.Log;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity {



    Random gerador = new Random();
    private int numero = gerador.nextInt(10) + 1;
    private int tentativas = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Tentar(View V ) {
        EditText entrada = (EditText) findViewById(R.id.editText);
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        String ns = entrada.getText().toString();
        int n = Integer.parseInt(ns);
        if(n == this.numero) {
            etiqueta.setText(getResources().getString(R.string.lblGanhou));
            atualiza_dados();
        } else {
            if(n < this.numero){
                etiqueta.setText("Maior!");
            } else if(n > this.numero){
                etiqueta.setText("Menor!");
            }
            this.tentativas++;
        }
    }

    public void atualiza_dados(){
        SharedPreferences arquivos = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivos.edit();

        String key;

        int[] tentativa = new int[5];
        int i, melhor = arquivos.getInt("melhor", 0);

        if(melhor > tentativas || tentativas == 0) {
            melhor = tentativas;
        }

        for(i=0;i<5;i++){
            key = Integer.toString(i);
            tentativa[i] = arquivos.getInt(key , 0);
            if(melhor > tentativa[i])
                melhor = tentativa[i];
        }

        if(tentativa.length == 0){
            editor.putInt("0", tentativas);
        } else if (tentativa.length > 0 && tentativa.length < 5){
            int chave = tentativa.length;
            key = Integer.toString(chave);
            editor.putInt(key, tentativas);
        } else {
            for(i=1; i<5; i++){
                key = Integer.toString(i);
                editor.putInt(key, tentativa[i-1]);
            }
            editor.putInt("0", tentativas);
        }

        editor.putInt("melhor", melhor);

        editor.commit();
    }

    public void Score(View V){
        SharedPreferences arquivos = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = arquivos.edit();
        Intent i =  new Intent(MainActivity.this, Score.class);
        Bundle bundle = new Bundle();
        String key;
        int[] tentativa = new int[5];
        for(int j=0;j<5;j++){
            key = Integer.toString(j);
            tentativa[j] = arquivos.getInt(key , 0);
        }
        bundle.putIntArray("array", tentativa);
        bundle.putInt("melhor", arquivos.getInt("melhor", 0));
        i.putExtras(bundle);
        startActivity(i);
    }


    public void Reiniciar(View V){
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        EditText entrada = (EditText) findViewById(R.id.editText);
        etiqueta.setText(" ");
        entrada.setText(" ");
        this.numero = gerador.nextInt(9) + 1;
        this.tentativas = 0;
    }
}

