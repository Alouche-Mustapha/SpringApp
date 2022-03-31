package com.ensa.gi4.controller;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }

    public void afficherMenu() {
        System.out.println("1- pour lister le materiel, entrer 1");
        System.out.println("2- pour ajouter un nouveau materiel, entrer 2");
        System.out.println("3- pour supprimer un materiel, entrer 3");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            ajouterMateriel();
        } else if ("3".equals(next)) {
            supprimerMateriel();
        } else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }

    public void ajouterMateriel() {
        System.out.println("Pour ajouter un livre taper 1 : ");
        System.out.println("Pour ajouter une chaise taper 2 : ");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("1".equals(next)) {
            gestionMaterielService.ajouterNouveauMateriel(new Livre(1, "Antigone"));
        } else if ("2".equals(next)) {
            gestionMaterielService.ajouterNouveauMateriel(new Chaise(2, "Chaise gamer"));
        } else {
            System.out.println("choix invalide");
        }
    }

    public void supprimerMateriel() {
        System.out.println("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        gestionMaterielService.supprimerUnMateriel(id);
    }
}
