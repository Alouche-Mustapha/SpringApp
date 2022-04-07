package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.List;
import java.util.Scanner;

public class GestionMaterielServiceImpl implements GestionMaterielService {

    MaterielDAO materielDAO;
    GestionLivreService gestionLivreService;
    GestionChaiseService gestionChaiseService;

    public GestionMaterielServiceImpl(MaterielDAO materielDAO, GestionLivreService gestionLivreService, GestionChaiseService gestionChaiseService) {
        this.materielDAO = materielDAO;
        this.gestionLivreService = gestionLivreService;
        this.gestionChaiseService = gestionChaiseService;
    }

    @Override
    public void listerMateriel() {
        List<Materiel> materiels = this.materielDAO.listerMateriels();
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
    public void ajouterMateriel() {
        System.out.println("Pour ajouter un livre taper 1 : ");
        System.out.println("Pour ajouter une chaise taper 2 : ");
        System.out.print("Choix : ");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        if ("1".equals(choix)) {
            gestionLivreService.ajouterMateriel();
        } else if ("2".equals(choix)) {
            gestionChaiseService.ajouterMateriel();
        } else {
            System.out.println("choix invalide");
        }
    }

    @Override
    public void supprimerMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            this.materielDAO.supprimerMateriel(id);
            System.out.println("Le materiel " + materiel.getName() + " est supprime");
        }
    }

    @Override
    public void chercherMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            System.out.println("Le materiel " + materiel + " est bien trouver");
        }
    }

    @Override
    public void modifierMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            if (materiel instanceof Livre) {
                this.gestionLivreService.modifierMateriel(id);
            } else if (materiel instanceof Chaise){
                this.gestionChaiseService.modifierMateriel(id);
            }
        }
    }
}
