package com.ensa.gi4.controller;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.AllocationMaterielService;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;
    private AllocationMaterielService allocationMaterielService;

    // injection par accessor
    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        this.gestionMaterielService = gestionMaterielService;
    }

    public void setAllocationMaterielService(AllocationMaterielService allocationMaterielService) {
        this.allocationMaterielService = allocationMaterielService;
    }

    public void afficherMenu() {
        System.out.println("1- pour lister les materiels, entrer 1");
        System.out.println("2- pour ajouter un nouveau materiel, entrer 2");
        System.out.println("3- pour supprimer un materiel, entrer 3");
        System.out.println("4- pour modifier un materiel, entrer 4");
        System.out.println("5- pour chercher un materiel, entrer 5");
        System.out.println("6- pour allouer un materiel, entrer 6");
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
        } else if ("4".equals(next)) {
            modifierMateriel();
        } else if ("5".equals(next)) {
            chercherMateriel();
        } else if ("6".equals(next)) {
            allouerMateriel();
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
        String choix = scanner.next();
        System.out.print("ID : ");
        int id = scanner.nextInt();
        System.out.print("Nom : ");
        String nom = scanner.next();
        if ("1".equals(choix)) {
            gestionMaterielService.ajouterNouveauMateriel(new Livre(id, nom));
        } else if ("2".equals(choix)) {
            gestionMaterielService.ajouterNouveauMateriel(new Chaise(id, nom));
        } else {
            System.out.println("choix invalide");
        }
    }

    public void supprimerMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        gestionMaterielService.supprimerUnMateriel(id);
    }

    public void modifierMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        gestionMaterielService.modifierUnMateriel(id);
    }

    public void chercherMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        gestionMaterielService.chercherUnMateriel(id);
    }

    public void allouerMateriel() {
        allocationMaterielService.allouerMateriel();
    }
}
