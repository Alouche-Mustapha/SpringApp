package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.listeners.AppEvent;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GestionChaiseServiceImpl implements GestionChaiseService {

    @Autowired
    MaterielDAO materielDAO;

    @Autowired
    ApplicationPublisher applicationPublisher;

    public GestionChaiseServiceImpl() {
    }

//    public GestionChaiseServiceImpl(MaterielDAO materielDAO) {
//        this.materielDAO = materielDAO;
//    }

    @Override
    public void ajouterMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID : ");
        int id = scanner.nextInt();
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.print("Nom : ");
            String nom = scanner.next();
            System.out.print("Marque : ");
            String marque = scanner.next();
            Materiel nouveauMateriel = new Chaise(id, nom, marque);
            this.materielDAO.ajouterMateriel(nouveauMateriel);
            applicationPublisher.publish(new AppEvent<Materiel>(nouveauMateriel, EventType.ADD));
        } else {
            System.out.println("Il existe deja un materiel avec cet id");
        }
    }

    @Override
    public void modifierMateriel(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom : ");
        String nom = scanner.next();
        System.out.print("Marque : ");
        String marque = scanner.next();
        this.materielDAO.modifierMateriel(id, new Chaise(id, nom, marque));
        applicationPublisher.publish(new AppEvent<Materiel>(this.materielDAO.chercherMateriel(id), EventType.UPDATE));
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
