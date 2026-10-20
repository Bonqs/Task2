package org.example.menu;

import org.example.model.*;
import org.example.shelter.Shelter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){
        boolean started = true;
        while (started) {
            printMenu();
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> addAnimal();
                case "2" -> listAllAnimals();
                case "3" -> findBySpecies();
                case "4" -> listAvailable();
                case "5" -> markAdopted();
                case "0" -> started = false;
                default -> System.out.println("Unknown option");
            }
        }
    }

    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }

    private void addAnimal() {
        System.out.println("Enter animal type");
        String animalType= scanner.nextLine();
        System.out.println("Enter name:");
        String name =scanner.nextLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(scanner.nextLine());
        Animal animal = switch (animalType.toLowerCase()) {
            case "dog" -> new Dog(new AnimalId(), name, age);
            case "cat" -> new Cat(new AnimalId(), name, age);
            case "bird" -> new Bird(new AnimalId(), name, age);
            default -> null;
        };
        if (animal == null) {
            System.out.println("Unknown animal type.");
            return;
        }
        shelter.addAnimal(animal);
    }
    private void listAllAnimals() {
        System.out.println(shelter.getAllAnimals());
    }
    private void findBySpecies() {
        System.out.println("Enter species:");
        System.out.println(shelter.findBySpecies(scanner.nextLine()));
    }
    private void listAvailable() {
        System.out.println(shelter.findAvailableAnimals());
    }
    private void markAdopted() {
        System.out.println(shelter.getAllAnimals());
        System.out.println("Enter Animals ID");
        shelter.markAsAdopted(scanner.nextLine());
    }
}
