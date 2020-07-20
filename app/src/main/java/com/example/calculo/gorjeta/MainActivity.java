package com.example.calculo.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edValor;
    TextView txtPorcentagem, txtGorjeta, txtTotal;
    SeekBar skbGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edValor = findViewById(R.id.ed_valor);
        txtPorcentagem = findViewById(R.id.txt_porcentagem);
        txtGorjeta = findViewById(R.id.txt_gorjeta);
        txtTotal = findViewById(R.id.txt_total);
        skbGorjeta = findViewById(R.id.skb_gorjeta);

        skbGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;

                txtPorcentagem.setText( Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        String valorConta = edValor.getText().toString();

        if(valorConta == null || valorConta.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro",
                    Toast.LENGTH_SHORT
            ).show();
        } else {

            double valorContaDouble = Double.parseDouble(valorConta);

            double gorjeta = valorContaDouble * ( porcentagem / 100 );
            double total = valorContaDouble + gorjeta;

            txtGorjeta.setText("R$" + gorjeta);
            txtTotal.setText("R$"+total);
        }
    }
}