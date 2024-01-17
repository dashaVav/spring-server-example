package com.example.springserver.logic;

import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {

    @Getter
    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel() {
        model = new HashMap<>();
    }

    public void addPet(Pet pet, int id) {
        model.put(id, pet);
    }

    public void putPet(Pet pet, int id) {
        model.put(id, pet);
    }

    public Pet getPet(int id) {
        return model.get(id);
    }

    public Map<Integer, Pet> getAll() {
        return model;
    }

    public void deletePet(int id) {
        model.remove(id);
    }

    public boolean isPetWithIdInModel(int id) {
        return model.containsKey(id);
    }
}
