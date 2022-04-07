package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.service.api.GestionChaiseService;

import java.util.Scanner;

public class GestionChaiseServiceImpl implements GestionChaiseService {

    MaterielDAO materielDAO;

    public GestionChaiseServiceImpl(MaterielDAO materielDAO) {
        this.materielDAO = materielDAO;
    }

    @Override
    public void ajouterMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID : ");
        int id = scanner.nextInt();
        System.out.print("Nom : ");
        String nom = scanner.next();
        System.out.print("Marque : ");
        String marque = scanner.next();
        this.materielDAO.ajouterMateriel(new Chaise(id, nom, marque));
        System.out.println("La chaise est bien ajoutee");
    }

    @Override
    public void modifierMateriel(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom : ");
        String nom = scanner.next();
        System.out.print("Marque : ");
        String marque = scanner.next();
        this.materielDAO.modifierMateriel(id, new Chaise(id, nom, marque));
        System.out.println("La chaise est bien modifiee");
    }

    @Override
    public void listerMateriel() {

    }

    @Override
    public void supprimerMateriel(int id) {

    }

    @Override
    public void chercherMateriel(int id) {

    }
}
