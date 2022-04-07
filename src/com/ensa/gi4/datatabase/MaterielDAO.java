package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Materiel;

import java.util.*;

public class MaterielDAO {

    private List<Materiel> materiels = new ArrayList<>();

    public List<Materiel> listerMateriels() {
        return this.materiels;
    }

    public void ajouterMateriel(Materiel materiel) {
        this.materiels.add(materiel);
    }

    public Materiel chercherMateriel(int id) {
        for (Materiel materiel : this.materiels) {
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }

    public void supprimerMateriel(int id) {
        this.materiels.removeIf(materiel -> materiel.getId() == id);
    }

    public void modifierMateriel(int id, Materiel nouveauMateriel) {
        for (Materiel materiel : this.materiels) {
            if (materiel.getId() == id) {
                this.materiels.add(this.materiels.indexOf(materiel), nouveauMateriel);
                this.materiels.remove(materiel);
            }
        }
    }
}
