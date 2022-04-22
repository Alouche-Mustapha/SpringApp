package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.listeners.AppEvent;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("allocationService")
public class AllocationMaterielServiceImpl implements AllocationMaterielService {

    @Autowired
    MaterielDAO materielDAO;

    @Autowired
    ApplicationPublisher applicationPublisher;

    public AllocationMaterielServiceImpl() {
    }

//    public AllocationMaterielServiceImpl(MaterielDAO materielDAO) {
//        this.materielDAO = materielDAO;
//    }

    @Override
    public void listerAllocation() {
        List<Materiel> allocations = this.materielDAO.listerAllocations();
        if (allocations.size() == 0) {
            System.out.println("La liste des allocations est vide");
        } else {
            System.out.println("La liste des allocation :");
            for (Materiel materiel : allocations) {
                this.applicationPublisher.publish(new AppEvent<Materiel>(materiel, EventType.GET));
            }
        }
    }

    @Override
    public void allouerMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherMateriel(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            this.materielDAO.allouerMateriel(materiel);
            applicationPublisher.publish(new AppEvent<Materiel>(materiel, EventType.ALLOCATE));
        }
    }

    @Override
    public void rendreMateriel(int id) {
        Materiel materiel = this.materielDAO.chercherAllocation(id);
        if (materiel == null) {
            System.out.println("Pas de materiel avec cet id");
        } else {
            this.materielDAO.rendreMateriel(materiel);
            applicationPublisher.publish(new AppEvent<Materiel>(materiel, EventType.RETURN));
        }
    }
}
