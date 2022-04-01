package com.ensa.gi4.service.impl;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here
    ArrayList<Materiel> materiels = new ArrayList<>();
    private int nbrLivres = 0;
    private int nbrChaises = 0;

    @Override
    public void listerMateriel() {
        if (this.materiels.size() == 0) {
            System.out.println("La liste est vide");
        } else {
            System.out.println("La liste des materiels :");
            for (Materiel materiel: materiels) {
                System.out.println("ID : " + materiel.getId() + " , Nom : " + materiel.getName());
            }
        }
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        if (materiel instanceof Livre) {
            this.nbrLivres++;
        } else {
            this.nbrChaises++;
        }
        materiels.add(materiel);
        System.out.println("Materiel bien ajouter");
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

    @Override
    public void chercherUnMateriel(int id) {
        for (int i = 0; i < materiels.size(); i++) {
            if (materiels.get(i).getId() == id) {
                System.out.println("Le materiel " + materiels.get(i).getName() + " bien trouver");
                break;
            }
            if (i == materiels.size() - 1) {
                System.out.println("Pas de materiel avec cet id");
            }
        }
    }

    @Override
    public void modifierUnMateriel(int id) {
        for (int i = 0; i < materiels.size(); i++) {
            if (materiels.get(i).getId() == id) {
                System.out.print("Nom : ");
                Scanner scanner = new Scanner(System.in);
                String nom = scanner.next();
                materiels.get(i).setName(nom);
                System.out.println("Materiel bien modifier");
                break;
            }
            if (i == materiels.size() - 1) {
                System.out.println("Pas de materiel avec cet id");
            }
        }
    }
}
