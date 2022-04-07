package com.ensa.gi4.controller;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;
    private AllocationMaterielService allocationMaterielService;

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        this.gestionMaterielService = gestionMaterielService;
    }

    public void setAllocationMaterielService(AllocationMaterielService allocationMaterielService) {
        this.allocationMaterielService = allocationMaterielService;
    }

    public void afficherMenu() {
        System.out.println("\n******************************************");
        System.out.println("1- pour lister les materiels    :  taper 1");
        System.out.println("2- pour lister les allocations  :  taper 2");
        System.out.println("3- pour ajouter un materiel     :  taper 3");
        System.out.println("4- pour supprimer un materiel   :  taper 4");
        System.out.println("5- pour modifier un materiel    :  taper 5");
        System.out.println("6- pour chercher un materiel    :  taper 6");
        System.out.println("7- pour allouer un materiel     :  taper 7");
        System.out.println("8- pour rendre un materiel      :  taper 8");
        System.out.println("0- pour sortir de l'application :  taper 0");
        System.out.println("******************************************\n");
        System.out.print("option : ");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            listerAllocations();
        } else if ("3".equals(next)) {
            ajouterMateriel();
        } else if ("4".equals(next)) {
            supprimerMateriel();
        } else if ("5".equals(next)) {
            modifierMateriel();
        } else if ("6".equals(next)) {
            chercherMateriel();
        } else if ("7".equals(next)) {
            allouerMateriel();
        } else if ("8".equals(next)) {
            rendreMateriel();
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
        this.gestionMaterielService.ajouterMateriel();
    }

    public void supprimerMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.gestionMaterielService.supprimerMateriel(id);
    }

    public void modifierMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.gestionMaterielService.modifierMateriel(id);
    }

    public void chercherMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.gestionMaterielService.chercherMateriel(id);
    }

    public void listerAllocations() {
        this.allocationMaterielService.listerAllocation();
    }

    public void allouerMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.allocationMaterielService.allouerMateriel(id);
    }

    public void rendreMateriel() {
        System.out.print("Entre un id : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.allocationMaterielService.rendreMateriel(id);
    }
}
