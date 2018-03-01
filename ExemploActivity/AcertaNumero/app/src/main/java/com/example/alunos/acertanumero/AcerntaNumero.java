package com.example.alunos.acertanumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
public class AcerntaNumero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acernta_numero);
    }
    public void AcertaNumero(String[] args){
        Random random = new Random();
        int x = random.nextInt(10);
        EditText userInput = findViewById(R.id.entrada);
        String num = userInput.getText();
        num = Integer.parseInt(num);
        Scanner input = new Scanner(System.in);
        for(int tent = 0; tent<=3; tent++){
            if( num== x){
                System.out.prinf("Numero correto !!");
            }else{
                System.out.prinf("Numero errado !!");
                tent--;
                if(tent == 3){
                    System.out.prinf("Acabou suas chances !!")
                }else{
                    System.out.prinf("Voce tem "+tent+" chances");
                }
            }
        }
    }
}
