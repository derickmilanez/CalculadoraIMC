package com.example.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Classificacao extends AppCompatActivity {
    TextView lblclassificacao;
    Button btnvoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        lblclassificacao = findViewById(R.id.textViewStatus);
        btnvoltar = findViewById(R.id.buttonReturn);

        Intent correio2 = getIntent();

        Bundle envelope2 = correio2.getExtras();

        double imc =  envelope2.getDouble("imc");

        if(imc<18.5){
            lblclassificacao.setText("ABAIXO DO PESO");
        }
        else if(imc>18.6&&imc<24.9){
            lblclassificacao.setText("PESO IDEAL");
        }
        else if(imc>25&&imc<29.9){
            lblclassificacao.setText("LEVEMENTE ACIMA DO PESO");
        }
        else if(imc>30&&imc<34.9){
            lblclassificacao.setText("OBESIDADE GRAU I");
        }
        else if(imc>35&&imc<39.9){
            lblclassificacao.setText("OBESIDADE GRAU II");
        }
        else{
            lblclassificacao.setText("OBESIDADE GRAU III");
        }

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(voltar);
            }
        });
    }
}
