package sample;

import java.util.ArrayList;

public class Objekt {

    private String name;
    private ArrayList<Integer> werte;
    private ArrayList<String> betrachtungsebenen;

    public Objekt(String name, ArrayList<Integer> werte, ArrayList<String> betrachtungsebenen){
        this.werte = werte;
        this.name = name;
        this.betrachtungsebenen = betrachtungsebenen;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getWerte() {
        return werte;
    }

    public void setWerte(ArrayList<Integer> werte) {
        this.werte = werte;
    }

    public ArrayList<String> getBetrachtungsebenen() {
        return betrachtungsebenen;
    }

    public void setBetrachtungsebenen(ArrayList<String> betrachtungsebenen) {
        this.betrachtungsebenen = betrachtungsebenen;
    }
}
