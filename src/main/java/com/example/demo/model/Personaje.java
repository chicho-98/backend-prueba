package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Personaje {

    private Long id;
    private String name;
    private String status;

    public Personaje() {}

    public Personaje(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
