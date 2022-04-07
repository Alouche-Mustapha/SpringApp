package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionLivreService;

import java.util.Scanner;

public class GestionLivreServiceImpl implements GestionLivreService {

    MaterielDAO materielDAO;

    public GestionLivreServiceImpl(MaterielDAO materielDAO) {
        this.materielDAO = materielDAO;
    }

    @Override
    public void listerMateriel() {

    }

    @Override
    public void ajouterMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID : ");
        int id = scanner.nextInt();
        System.out.print("Nom : ");
        String nom = scanner.next();
        System.out.print("NbrPage : ");
        int nbrPage = scanner.nextInt();
        Materiel materiel = new Livre(id, nom, nbrPage);
        this.materielDAO.ajouterMateriel(materiel);
        System.out.println("Le livre est bien ajoute");
    }

    @Override
    public void supprimerMateriel(int id) {

    }

    @Override
    public void chercherMateriel(int id) {

    }

    @Override
    public void modifierMateriel(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom : ");
        String nom = scanner.next();
        System.out.print("Nbr page : ");
        int nbrPage = scanner.nextInt();
        this.materielDAO.modifierMateriel(id, new Livre(id, nom, nbrPage));
        System.out.println("Le livre est bien modifie");
    }
}
