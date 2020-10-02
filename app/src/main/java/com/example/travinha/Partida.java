package com.example.travinha;

import java.io.Serializable;

public class Partida implements Serializable {
    private String time1;
    private String time2;
    private long tempo;
    private int golsParaVencer = 0;

    public Partida(String time1, String time2, long tempo, int golsParaVencer) {
        this.time1 = time1;
        this.time2 = time2;
        this.tempo = tempo;
        this.golsParaVencer = golsParaVencer;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public long getTempo() {
        return tempo;
    }

    public int getGolsParaVencer() {
        return golsParaVencer;
    }
}
