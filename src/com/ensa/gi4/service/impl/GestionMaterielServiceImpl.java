package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.listeners.AppEvent;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component("mainService")
public class GestionMaterielServiceImpl implements GestionMaterielService {

    @Autowired
    MaterielDAO materielDAO;

    @Autowired
    GestionLivreService gestionLivreService;

    @Autowired
    GestionChaiseService gestionChaiseService;

    @Autowired
    ApplicationPublisher applicationPublisher;

    public GestionMaterielServiceImpl() {
    }

//    public GestionMaterielServiceImpl(MaterielDAO materielDAO, GestionLivreService gestionLivreService, GestionChaiseService gestionChaiseService) {
//        this.materielDAO = materielDAO;
//        this.gestionLivreService = gestionLivreService;
//        this.gestionChaiseService = gestionChaiseService;
//    }

    @Override
    public void listerMateriel() {
        List<Materiel> materiels = this.materielDAO.listerMateriels();
        if (materiels.size() == 0) {
            System.out.println("La liste des materiels est vide");
        } else {
            System.out.println("La liste des materiels :");
            for (Materiel materiel : materiels) {
                applicationPublisher.publish(new AppEvent<Materiel>(materiel, EventType.GET));
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
            applicationPublisher.publish(new AppEvent<Materiel>(materiel, EventType.REMOVE));
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

    @Override
    public void chercherMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            applicationPublisher.publish(new AppEvent<Materiel>(materiel, EventType.FIND));
        }
    }
}
