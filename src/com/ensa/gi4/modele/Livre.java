package com.ensa.gi4.modele;

public class Livre extends Materiel {

    private int nbrPage;

    public Livre(int id, String name, int nbrPage) {
        super(id, name);
        this.nbrPage = nbrPage;
    }

    public int getNbrPage() {
        return this.nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }
}
