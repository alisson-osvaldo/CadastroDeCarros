package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvMarca;
    TextView tvModelo;
    TextView tvAnoFab;
    TextView tvCor;
    TextView tvMotor;
    TextView tvCombustivel;
    TextView tvFIPE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        inicializarComponentes();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if(bundle == null){
            Toast.makeText(this, "Activity não iniciada corretamente...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }

        tvMarca.setText(bundle.getString("marca"));
        tvModelo.setText(bundle.getString("modelo"));
        tvAnoFab.setText(String.valueOf(bundle.getInt("anoFab")));
        tvCor.setText(bundle.getString("cor"));
        tvMotor.setText(bundle.getString("motor"));
        tvCombustivel.setText(bundle.getString("combustivel"));
        tvFIPE.setText(String.valueOf(bundle.getFloat("valorFIPE")));
    }

    private void inicializarComponentes(){
        tvMarca       = findViewById(R.id.tvMarca);
        tvModelo      = findViewById(R.id.tvModelo);
        tvAnoFab      = findViewById(R.id.tvAnoFab);
        tvCor         = findViewById(R.id.tvCor);
        tvMotor       = findViewById(R.id.tvMotor);
        tvCombustivel = findViewById(R.id.tvCombustivel);
        tvFIPE        = findViewById(R.id.tvFIPE);
    }

}