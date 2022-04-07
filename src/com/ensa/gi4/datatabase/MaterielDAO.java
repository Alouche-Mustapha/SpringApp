package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Materiel;

import java.util.*;

public class MaterielDAO {

    private List<Materiel> materiels = new ArrayList<>();
    private List<Materiel> allocations = new ArrayList<>();

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

    public List<Materiel> listerAllocations() {
        return this.allocations;
    }

    public void allouerMateriel(Materiel materiel) {
        this.allocations.add(materiel);
        this.materiels.remove(materiel);
    }

    public void rendreMateriel(Materiel materiel) {
        this.allocations.remove(materiel);
        this.materiels.add(materiel);
    }

    public Materiel chercherAllocation(int id) {
        for (Materiel materiel : this.allocations) {
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }
}
