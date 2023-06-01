package com.example.smoke.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;

    private String name;
    private int price;

    public Game (String name, int price){
        this.name = name;
        this.price = price;
    }
}
