package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;

import java.util.List;

public class AllocationMaterielServiceImpl implements AllocationMaterielService {

    MaterielDAO materielDAO;

    public AllocationMaterielServiceImpl(MaterielDAO materielDAO) {
        this.materielDAO = materielDAO;
    }

    @Override
    public void allouerMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            this.materielDAO.allouerMateriel(materiel);
            System.out.println("Materiel " + materiel.getName() + " est bien allouee");
        }
    }

    @Override
    public void rendreMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherAllocation(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            this.materielDAO.rendreMateriel(materiel);
            System.out.println("Materiel " + materiel.getName() + " est bien rendue");
        }
    }

    @Override
    public void listerAllocation() {
        List<Materiel> allocations = this.materielDAO.listerAllocations();
        if (allocations.size() == 0) {
            System.out.println("La liste des allocations est vide");
        } else {
            System.out.println("La liste des allocation :");
            for (Materiel materiel : allocations) {
                if (materiel instanceof Livre) {
                    System.out.println("ID : " + materiel.getId() + " , Nom : " + materiel.getName() + " ,NbrPage : " + ((Livre) materiel).getNbrPage());
                } else if (materiel instanceof Chaise){
                    System.out.println("ID : " + materiel.getId() + " , Nom : " + materiel.getName() + " ,Marque : " + ((Chaise) materiel).getMarque());
                }
            }
        }
    }
}
