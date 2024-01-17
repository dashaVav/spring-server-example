package com.example.springserver.dtos;

import com.example.springserver.logic.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutPetDTO {
    private int id;
    private Pet pet;
}
