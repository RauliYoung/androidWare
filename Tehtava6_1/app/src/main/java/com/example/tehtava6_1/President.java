package com.example.tehtava6_1;

public class President {
    private String nimi;
    private int kaudenAlkuVuosi;
    private int kaudenLoppuVuosi;
    private String lempiNimi;

    public President(String etu, int alku, int loppu,String lempiNimi) {
        this.nimi = etu;
        this.kaudenAlkuVuosi = alku;
        this.kaudenLoppuVuosi = loppu;
        this.lempiNimi = lempiNimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getKaudenAlkuVuosi() {
        return kaudenAlkuVuosi;
    }

    public int getKaudenLoppuVuosi() {
        return kaudenLoppuVuosi;
    }

    public String getLempiNimi() {
        return lempiNimi;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
}
