package com.example.demo.controller;

import com.example.demo.model.Personaje;
import com.example.demo.service.RickAndMortyServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RickAndMortyController {

    @Autowired
    RickAndMortyServiceBean service;

    @GetMapping("/personaje/{id}")
    public Personaje getPersonaje(@PathVariable Long id) {

        Personaje personaje = new Personaje();

        try {
            personaje = service.getPersonaje(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personaje;
    }

    @GetMapping("/personaje/")
    public List<Personaje> getPersonajes() {

        List<Personaje> personajes = new ArrayList<Personaje>();

        try {
            personajes = service.getPersonajes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personajes;
    }
}
