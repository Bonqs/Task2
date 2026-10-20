package org.example.shelter;

import org.example.model.AdoptionStatus;
import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Shelter<T extends Animal> {
    private final List<T> animals = new ArrayList<>();

    public void addAnimal(T animal) {
        animals.add(animal);
    }

    public List<T> getAllAnimals() {
        return List.copyOf(animals);
    }

    public List<T> findBySpecies(String species) {
        ArrayList<T> foundSpecies = new ArrayList<>();
        for (T a : animals) {
            if (species.equalsIgnoreCase(a.getSpecies())) {
                foundSpecies.add(a);
            }
        }
        return foundSpecies;
    }

    public List<T> findAvailableAnimals() {
        ArrayList<T> availableAnimals = new ArrayList<>();
        for (T a : animals) {
            if (a.getAdoptionStatus() == AdoptionStatus.AVAILABLE) {
                availableAnimals.add(a);
            }
        }
        return availableAnimals;
    }

    public void markAsAdopted(String id) {
        for (T a : animals) {
            if (id.equals(a.getId().toString())) {
                a.markAsAdopted();
                return;
            }
        }
    }
}
