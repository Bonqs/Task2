package org.example.model;

import lombok.Getter;

public final class Cat extends Animal{
    public Cat(AnimalId id, String name, int age){
        super(id,name,age);
    }

    @Override
    public String getSpecies(){
        return "Cat";
    }


}
