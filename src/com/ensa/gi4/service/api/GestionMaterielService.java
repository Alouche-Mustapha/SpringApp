package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void supprimerUnMateriel(int id);
    void chercherUnMateriel(int id);
    void modifierUnMateriel(int id);
}
