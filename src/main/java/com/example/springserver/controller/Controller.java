package com.example.springserver.controller;

import com.example.springserver.dtos.ResponseDTO;
import com.example.springserver.logic.Pet;
import com.example.springserver.logic.PetModel;
import com.example.springserver.dtos.PutPetDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public ResponseDTO createPet(@RequestBody Pet pet) {
        int id = newId.getAndIncrement();
        petModel.addPet(pet, id);
        return new ResponseDTO(String.format("Вы успешно создали питомца с id=%d.", id));
    }

    @GetMapping(value = "getAllPets", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        if (petModel.isPetWithIdInModel(id.get("id"))) {
            return petModel.getPet(id.get("id"));
        } else {
            return new Pet();
        }
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public ResponseDTO deletePet(@RequestBody Map<String, Integer> id) {
        int idToDelete = id.get("id");
        if (petModel.isPetWithIdInModel(idToDelete)) {
            petModel.deletePet(idToDelete);
            System.out.println("+");
            return new ResponseDTO(String.format("Вы успешно удалили питомца с id=%d.", idToDelete));
        } else {
            return new ResponseDTO(String.format("Не удалось найти питомца с id=%d.", idToDelete));
        }
    }

    @PutMapping(value = "/putPet", consumes = "application/json", produces = "application/json")
    public ResponseDTO putPet(@RequestBody PutPetDTO petDTO) {
        int id = petDTO.getId();
        if (petModel.isPetWithIdInModel(id)) {
        petModel.putPet(petDTO.getPet(), id);
        return new ResponseDTO(String.format("Вы успешно обновили питомца с id=%d.", id)); }
        else {
            return new ResponseDTO(String.format("Не удалось найти питомца с id=%d.", id));
        }
    }
}
