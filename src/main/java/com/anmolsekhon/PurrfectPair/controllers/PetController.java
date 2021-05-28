package com.anmolsekhon.PurrfectPair.controllers;

import com.anmolsekhon.PurrfectPair.beans.Pet;
import com.anmolsekhon.PurrfectPair.database.DatabaseAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class PetController {

    @Autowired
    public DatabaseAccess da;

    @GetMapping("/pets")
    public String fetchAll() {

        List<Pet> pets = da.getAllPets();
        ObjectMapper mapper = new ObjectMapper();

        String json;
        try {
            json = mapper.writeValueAsString(pets);
        } catch (Exception e) {
            json = "{}";
        }
        return json;
    }
}