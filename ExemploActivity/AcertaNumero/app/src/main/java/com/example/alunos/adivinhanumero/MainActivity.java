package com.example.alunos.adivinhanumero;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences arquivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arquivo = getPreferences( Context.MODE_PRIVATE);
    }

    public void Confirma(View v ) {
        Scanner input = new Scanner(System.in);
        Random gerador = new Random();
        int x = gerador.nextInt(1000) + 1;


        int a;
        int t=0;
        while (t < 3) {
            EditText userInput = findViewById(R.id.editText);
            String teste = userInput.getText().toString();
            a = Integer.parseInt(teste);

            if (a == x) {
                TextView etiqueta = (TextView) findViewById(R.id.Resultado);
                etiqueta.setText(getResources().getString(R.string.lblResultado2));
                break;
            }else if(a > x){
                TextView etiqueta = (TextView) findViewById(R.id.Resultado);
                etiqueta.setText(getResources().getString(R.string.lblResultado5));
            }else if(a < x){
                TextView etiqueta = (TextView) findViewById(R.id.Resultado);
                etiqueta.setText(getResources().getString(R.string.lblResultado6));
            }else{
                TextView etiqueta = (TextView) findViewById(R.id.Resultado);
                etiqueta.setText(getResources().getString(R.string.lblResultado3));
            }
            t++;
        }
        TextView etiqueta = (TextView) findViewById(R.id.Resultado);
        etiqueta.setText(getResources().getString(R.string.lblResultado4));

        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("Numero :", x,"\nTentativas :", t);
        editor.commit();

        Intent i = new Intent(MainActivity.this, verifica.class);
        Bundle bundle = new Bundle();
        bundle.putString(  Integer.toString(x),Integer.toString(t));
        i.putExtras(bundle);
        startActivity(i);
    }

}
