package com.example.springserver.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class PutPetDTO {
    private int id;
    private Pet pet;
}
