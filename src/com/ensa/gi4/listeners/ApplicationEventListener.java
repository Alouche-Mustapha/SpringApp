package com.ensa.gi4.listeners;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener<T extends Materiel> implements ApplicationListener<AppEvent<T>> {

    @Override
    public void onApplicationEvent(AppEvent<T> event) {
        Object eventSource = event.getSource();
        EventType eventType = event.getEventType();

        switch (eventType){
            case GET -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("ID : " + livre.getId() + " , Nom : " + livre.getName() + " ,NbrPage : " + livre.getNbrPage());
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("ID : " + chaise.getId() + " , Nom : " + chaise.getName() + " ,Marque : " + chaise.getMarque());
                }
            }
            case ADD -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("Le livre " + livre.getName() + " est bien ajoute");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("La chaise " + chaise.getName() + " est bien ajoutee");
                }
            }
            case REMOVE -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("Le livre " + livre.getName() + " est supprime");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("La chaise " + chaise.getName() + " est supprime");
                }
            }
            case UPDATE -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("Le livre " + livre.getName() + " est modifie");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("La chaise " + chaise.getName() + " est modifie");
                }
            }
            case FIND -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("Le livre " + livre.getName() + " est bien trouve");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("La chaise " + chaise.getName() + " est bien trouve");
                }
            }
            case ALLOCATE -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("Le livre " + livre.getName() + " est bien alloue");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("La chaise " + chaise.getName() + " est bien alloue");
                }
            }
            case RETURN -> {
                if (eventSource instanceof Livre livre) {
                    System.out.println("Le livre " + livre.getName() + " est bien rendu");
                } else if (eventSource instanceof Chaise chaise) {
                    System.out.println("La chaise " + chaise.getName() + " est bien rendue");
                }
            }
        }
    }
}
