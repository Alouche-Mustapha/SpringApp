package com.ensa.gi4.service.impl;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.ArrayList;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here
    ArrayList<Materiel> materiels = new ArrayList<>();
    private int nbrLivres = 0;
    private int nbrChaises = 0;

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        System.out.println("Liste de materiel :\n" + this.nbrLivres + " Livres \n" + this.nbrChaises + " chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        if (materiel instanceof Livre) {
            this.nbrLivres++;
        } else {
            this.nbrChaises++;
        }
        materiels.add(materiel);
        System.out.println("L'ajout du materiel " + materiel.getName() + " effectue avec succes !");
    }

    @Override
    public void supprimerUnMateriel(int id) {
        for (int i = 0; i < materiels.size(); i++) {
            if (materiels.get(i).getId() == id) {
                if (materiels.get(i) instanceof Livre) {
                    this.nbrLivres--;
                } else {
                    this.nbrChaises--;
                }
                materiels.remove(materiels.get(i));
                System.out.println("Materiel bien supprimer");
                break;
            }
            if (i == materiels.size() - 1) {
                System.out.println("Pas de materiel avec cet id");
            }
        }
    }
}
