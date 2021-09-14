package com.example.carros;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMarca;
    EditText etModelo;
    EditText etAnoFab;
    EditText etCor;
    EditText etMotor;
    EditText etCombustivel;
    EditText etFIPE;
    Button   bCadastrar;
    Button   bVerCarro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        bCadastrar.setOnClickListener(v -> {
            if (etMarca.getText().toString().isEmpty() ||
                    etModelo.getText().toString().isEmpty() ||
                    etAnoFab.getText().toString().isEmpty() ||
                    etCor.getText().toString().isEmpty() ||
                    etMotor.getText().toString().isEmpty() ||
                    etCombustivel.getText().toString().isEmpty() ||
                    etFIPE.getText().toString().isEmpty())

            {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }else{

                String marca = etMarca.getText().toString();
                String modelo = etModelo.getText().toString();
                int    anoFab = Integer.parseInt(etAnoFab.getText().toString());
                String cor    = etCor.getText().toString();
                String motor  = etMotor.getText().toString();
                String combustivel = etCombustivel.getText().toString();
                float valorFIPE = Float.parseFloat(etFIPE.getText().toString());

                Bundle bundle = new Bundle();

                bundle.putString("marca", marca);
                bundle.putString("modelo", modelo );
                bundle.putInt("anoFab", anoFab);
                bundle.putString("cor", cor);
                bundle.putString("motor", motor);
                bundle.putString("combustivel", combustivel);
                bundle.putFloat("valorFIPE", valorFIPE);

                //Método para Limpar os campos
                onStart();

                //Deixar visivel o Botão VerCarro
                bVerCarro.setVisibility(View.VISIBLE);

                //Botão para ir para a DetalhesActivity
                bVerCarro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);


                    }
                });

            }
        });
    }


    private void inicializarComponentes(){
        etMarca       = findViewById(R.id.etMarca);
        etModelo      = findViewById(R.id.etModelo);
        etAnoFab      = findViewById(R.id.etAnoFab);
        etCor         = findViewById(R.id.etCor);
        etMotor       = findViewById(R.id.etMotor);
        etCombustivel = findViewById(R.id.etCombustivel);
        etFIPE        = findViewById(R.id.etFIPE);
        bCadastrar    = findViewById(R.id.bCadastrar);
        bVerCarro     = findViewById(R.id.bVerCarro);
    }

    //Zerar os campos
    @Override
    protected void onStart() {
        super.onStart();
        etMarca.getText().clear();
        etModelo.getText().clear();
        etAnoFab.getText().clear();
        etCor.getText().clear();
        etMotor.getText().clear();
        etCombustivel.getText().clear();
        etFIPE.getText().clear();
    }
}