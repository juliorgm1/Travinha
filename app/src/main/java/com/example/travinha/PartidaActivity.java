package com.example.travinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PartidaActivity extends AppCompatActivity {
    public static final int TEMPO_PADRAO = 420000;
    private TextView textTempo;
    private TextView textTime1;
    private TextView textTime2;
    private TextView textGolTime1;
    private TextView textGolTime2;
    private TextView textFaltaTime1;
    private TextView textFaltaTime2;
    private TextView textAmareloTime1;
    private TextView textAmareloTime2;
    private TextView textVermelhoTime1;
    private TextView textVermelhoTime2;

    private Button btnGolTime1;
    private Button btnGolTime2;
    private Button btnFaltaTime1;
    private Button btnFaltaTime2;
    private Button btnAmareloTime1;
    private Button btnAmareloTime2;
    private Button btnVermelhoTime1;
    private Button btnVermelhoTime2;
    private Button btnFinalizarPartida;

    private Button btnReinicar;
    private Button btnNovaPartida;

    private CountDownTimer timer;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        Intent intent = getIntent();
        partida = (Partida) intent.getSerializableExtra("partida");

        carregaCampos();
        cliques();
        timer(partida.getTempo());
        textTime1.setText(partida.getTime1());
        textTime2.setText(partida.getTime2());
    }

    private void verificaVencedor(TextView time){
        if (partida.getGolsParaVencer()>0){
            if (getIntegerOfTextView(time)==partida.getGolsParaVencer()){
                finalizaPartida();
            }
        }
    }

    private void cliques() {
        btnGolTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textGolTime1);
                verificaVencedor(textGolTime1);
            }
        });
        btnGolTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textGolTime2);
                verificaVencedor(textGolTime2);
            }
        });
        btnFaltaTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textFaltaTime1);
            }
        });
        btnFaltaTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textFaltaTime2);
            }
        });
        btnAmareloTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textAmareloTime1);
            }
        });
        btnAmareloTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textAmareloTime2);
            }
        });
        btnVermelhoTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textVermelhoTime1);
            }
        });
        btnVermelhoTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementaTextView(textVermelhoTime2);
            }
        });
        btnFinalizarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizaPartida();
            }
        });
        btnReinicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciar();
            }
        });
        btnNovaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void reiniciar(){
        textGolTime1.setText("0");
        textGolTime2.setText("0");
        textFaltaTime1.setText("0");
        textFaltaTime2.setText("0");
        textAmareloTime1.setText("0");
        textAmareloTime2.setText("0");
        textVermelhoTime1.setText("0");
        textVermelhoTime2.setText("0");
        habilitaButtons(true);
        btnFinalizarPartida.setVisibility(View.VISIBLE);
        btnReinicar.setVisibility(View.INVISIBLE);
        btnNovaPartida.setVisibility(View.INVISIBLE);
        timer(partida.getTempo());
    }

    private int getIntegerOfTextView(TextView textView){
        String sValor = textView.getText().toString();
        return Integer.parseInt(sValor);
    }

    private void incrementaTextView(TextView textView){
        int nValor = getIntegerOfTextView(textView);
        nValor++;
        textView.setText(String.valueOf(nValor));
    }

    private void finalizaPartida(){
        int golsTime1 = getIntegerOfTextView(textGolTime1);
        int golsTime2 = getIntegerOfTextView(textGolTime2);

        timer.cancel();
        habilitaButtons(false);

        if (golsTime1 == golsTime2) textTempo.setText("Empate");
        else if(golsTime1 > golsTime2) textTempo.setText("Time 1");
        else textTempo.setText("Time 2");
        btnFinalizarPartida.setVisibility(View.INVISIBLE);
        btnNovaPartida.setVisibility(View.VISIBLE);
        btnReinicar.setVisibility(View.VISIBLE);
    }

    private void habilitaButtons(boolean b) {
        btnGolTime1.setEnabled(b);
        btnGolTime2.setEnabled(b);
        btnFaltaTime1.setEnabled(b);
        btnFaltaTime2.setEnabled(b);
        btnAmareloTime1.setEnabled(b);
        btnAmareloTime2.setEnabled(b);
        btnVermelhoTime1.setEnabled(b);
        btnVermelhoTime2.setEnabled(b);
        btnFinalizarPartida.setEnabled(b);
    }

    private void carregaCampos() {
        textTempo = findViewById(R.id.textTempo);
        textTime1 = findViewById(R.id.textViewTime1);
        textTime2 = findViewById(R.id.textViewTime2);
        textGolTime1 = findViewById(R.id.textGolsTime1);
        textGolTime2 = findViewById(R.id.textGolsTime2);
        textFaltaTime1 = findViewById(R.id.textFaltasTime1);
        textFaltaTime2 = findViewById(R.id.textFaltasTime2);
        textAmareloTime1 = findViewById(R.id.textAmarelosTime1);
        textAmareloTime2 = findViewById(R.id.textAmarelosTime2);
        textVermelhoTime1 = findViewById(R.id.textVermelhosTime1);
        textVermelhoTime2 = findViewById(R.id.textVermelhosTime2);

        btnGolTime1 = findViewById(R.id.btnGolTime1);
        btnGolTime2 = findViewById(R.id.btnGolTime2);
        btnFaltaTime1 = findViewById(R.id.btnFaltasTime1);
        btnFaltaTime2 = findViewById(R.id.btnFaltasTime2);
        btnAmareloTime1 = findViewById(R.id.btnAmarelosTime1);
        btnAmareloTime2 = findViewById(R.id.btnAmarelosTime2);
        btnVermelhoTime1 = findViewById(R.id.btnVermelhosTime1);
        btnVermelhoTime2 = findViewById(R.id.btnVermelhosTime2);
        btnFinalizarPartida = findViewById(R.id.btnFinalizar);
        btnReinicar = findViewById(R.id.btnReiniciar);
        btnNovaPartida = findViewById(R.id.btnNovaPartida);
    }

    private void timer(long time){
        timer = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                long segundos =  millisUntilFinished / 1000;
                long hora = segundos / 3600;
                long minutos = (segundos - hora* 3600)/ 60;
                segundos = segundos - (hora* 3600 + minutos * 60);
                String sHora = String.valueOf(hora);
                String sMinuto = String.valueOf(minutos);
                String sSegundo = String.valueOf(segundos);

                textTempo.setText(sHora +":"+sMinuto+":"+sSegundo);
            }

            public void onFinish() {
                textTempo.setText("done!");
            }
        };
        timer.start();
    }
}

