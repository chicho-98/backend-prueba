package com.example.demo.service;

import com.example.demo.App;
import com.example.demo.model.Personaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RickAndMortyServiceBean {

    private final static Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    RestTemplate restTemplate;

    public Personaje getPersonaje(Long id) {
        Personaje personaje = restTemplate.getForObject(
                "https://rickandmortyapi.com/api/character/" + id.toString(), Personaje.class);
        log.info(personaje.toString());
        return personaje;
    }

    public List<Personaje> getPersonajes() {
        ResponseEntity<Personaje[]> response = restTemplate.getForEntity(
                "https://rickandmortyapi.com/api/character/1,2,3,4,5,6,7,8,9,10",
                Personaje[].class
        );
        List<Personaje> personajes = Arrays.asList(response.getBody());
        log.info(personajes.toString());
        return personajes;
    }
}
