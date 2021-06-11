package com.example.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    TextView lblresultado;
    Button btnstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        lblresultado = findViewById(R.id.textViewResultado);
        btnstatus = findViewById(R.id.buttonStatus);

        Intent correio = getIntent();

        Bundle envelope = correio.getExtras();

        double peso = envelope.getDouble("peso");
        double altura = envelope.getDouble("altura");
        final double imc = peso / (altura * altura);
        lblresultado.setText((Double.toString(imc)));

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent correio2 = new Intent(getApplicationContext(), Classificacao.class);

                Bundle envelope2 = new Bundle();

                envelope2.putDouble("imc", imc);

                correio2.putExtras(envelope2);

                startActivity(correio2);
            }
        });
    }
}
