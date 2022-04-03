package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.*;

public class GestionMaterielDAO {

    private List<Materiel> materiels = new ArrayList<>();
    private static GestionMaterielDAO gestionMaterielDAO = new GestionMaterielDAO();

    public static GestionMaterielDAO getInstance() {
        return gestionMaterielDAO;
    }

    private GestionMaterielDAO() {
        super();
    }

    public List<Materiel> listerMateriels() {
        return this.materiels;
    }

    public void ajouterMateriel(Materiel materiel) {
        materiels.add(materiel);
    }

    public Materiel chercherMateriel(int id) {
        for (Materiel materiel : materiels) {
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }

    public void supprimerMateriel(int id) {
        materiels.removeIf(materiel -> materiel.getId() == id);
    }

    public void modifierMateriel(int id, Materiel nouveauMateriel) {
        for (Materiel materiel : materiels) {
            if (materiel.getId() == id) {
                materiels.add(materiels.indexOf(materiel), nouveauMateriel);
                materiels.remove(materiel);
            }
        }
    }
}
