package com.example.springserver.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private String type;
    private int age;
}
