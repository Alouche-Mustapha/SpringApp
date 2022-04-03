package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.GestionMaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMaterielServiceImpl implements GestionMaterielService {

    GestionMaterielDAO gestionMaterielDAO;

    public GestionMaterielServiceImpl(GestionMaterielDAO gestionMaterielDAO) {
        this.gestionMaterielDAO = gestionMaterielDAO;
    }

    @Override
    public void listerMateriel() {
        List<Materiel> materiels = this.gestionMaterielDAO.listerMateriels();
        if (materiels.size() == 0) {
            System.out.println("La liste des materiels est vide");
        } else {
            System.out.println("La liste des materiels :");
            for (Materiel materiel : materiels) {
                if (materiel instanceof Livre) {
                    System.out.println("ID : " + materiel.getId() + " , Nom : " + materiel.getName() + " ,NbrPage : " + ((Livre) materiel).getNbrPage());
                } else if (materiel instanceof Chaise){
                    System.out.println("ID : " + materiel.getId() + " , Nom : " + materiel.getName() + " ,Marque : " + ((Chaise) materiel).getMarque());
                }
            }
        }
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        this.gestionMaterielDAO.ajouterMateriel(materiel);
        System.out.println("Materiel bien ajouter");
    }

    @Override
    public void chercherUnMateriel(int id) {
        if (gestionMaterielDAO.chercherMateriel(id) == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            System.out.println("Le materiel " + gestionMaterielDAO.chercherMateriel(id).getName() + " est bien trouver");
        }
    }

    @Override
    public void supprimerUnMateriel(int id) {
        Materiel materiel = this.gestionMaterielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            this.gestionMaterielDAO.supprimerMateriel(id);
            System.out.println("Materiel bien supprimer");
        }
    }

    @Override
    public void modifierUnMateriel(int id) {
        Materiel materiel = gestionMaterielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nom : ");
            String nom = scanner.next();
            if (materiel instanceof Livre) {
                System.out.print("Nbr page : ");
                int nbrPage = scanner.nextInt();
                gestionMaterielDAO.modifierMateriel(id, new Livre(id, nom, nbrPage));
            } else if (materiel instanceof Chaise){
                System.out.print("Marque : ");
                String marque = scanner.next();
                gestionMaterielDAO.modifierMateriel(id, new Chaise(id, nom, marque));
            }
            System.out.println("Materiel bien modifer");
        }
    }
}
