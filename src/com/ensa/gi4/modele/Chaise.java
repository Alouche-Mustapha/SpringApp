package com.ensa.gi4.modele;

public class Chaise extends Materiel {

    private String marque;

    public Chaise(int id, String name, String marque) {
        super(id, name);
        this.marque = marque;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
