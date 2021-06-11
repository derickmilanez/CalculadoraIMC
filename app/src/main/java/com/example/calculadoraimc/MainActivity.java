package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtpeso, txtaltura;
    Button btncalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpeso = findViewById(R.id.editTextPeso);
        txtaltura = findViewById(R.id.editTextAltura);
        btncalcular = findViewById(R.id.buttonCalcular);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtpeso.getText().toString().equals("")||txtaltura.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }else {
                    double peso, altura, imc;
                    peso = Double.parseDouble(txtpeso.getText().toString());
                    altura = Double.parseDouble(txtaltura.getText().toString());
                    Intent correio = new Intent(getApplicationContext(), Resultado.class);

                    Bundle envelope = new Bundle();

                    envelope.putDouble("peso", peso);
                    envelope.putDouble("altura", altura);

                    correio.putExtras(envelope);

                    startActivity(correio);
                }
            }
        });
    }
}
