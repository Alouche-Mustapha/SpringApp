package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void listerMateriel();
    void ajouterMateriel();
    void supprimerMateriel(int id);
    void chercherMateriel(int id);
    void modifierMateriel(int id);
}
