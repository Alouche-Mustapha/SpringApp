package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface AllocationMaterielService {

    void allouerMateriel(int id);
    void rendreMateriel(int id);
    void listerAllocation();
}
