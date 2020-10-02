package com.example.travinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTempo;
    private EditText editTime1;
    private EditText editTime2;
    private EditText editGolsParaVencer;
    private Switch switchHabilitaGolsParaVencer;
    private Button rolaABola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaCampos();
        cliques();
    }

    private void cliques() {
        rolaABola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validaCampos()) return;
                Partida novaPartida = new Partida(
                        getStringTextView(editTime1),
                        getStringTextView(editTime2),
                        getLongTextView(editTempo),
                        (int)getLongTextView(editGolsParaVencer)
                );
                Intent intent = new Intent(getApplicationContext(),PartidaActivity.class);
                intent.putExtra("partida",novaPartida);
                startActivity(intent);
            }
        });
    }

    private String getStringTextView(TextView textView){
        return textView.getText().toString();
    }

    private long getLongTextView(TextView textView){
        return Long.parseLong(textView.getText().toString());
    }

    private boolean validaCampos() {
        if (editTempo.getText().toString().isEmpty()) {
            editTempo.setError("Infome o tempo da partida");
            return false;
        }
        if(editTime1.getText().toString().isEmpty()) {
            editTime1.setError("Informe o nome do Time 1");
            return false;
        }
        if (editTime2.getText().toString().isEmpty()) {
            editTime1.setError("Informe o nome do Time 2");
            return false;
        }

        return true;
    }

    private void carregaCampos() {
        editTempo = findViewById(R.id.textTempo);
        editTime1 = findViewById(R.id.textTime1);
        editTime2 = findViewById(R.id.textTime2);
        editGolsParaVencer = findViewById(R.id.textGolsParaVencer);
        switchHabilitaGolsParaVencer = findViewById(R.id.switchDefinirTotalGols);
        rolaABola = findViewById(R.id.buttonRolaABola);
    }
}