package com.anmolsekhon.PurrfectPair.controllers;

import com.anmolsekhon.PurrfectPair.beans.Pet;
import com.anmolsekhon.PurrfectPair.database.DatabaseAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/pets")
    public String addPet(@RequestBody Pet pet) {

        try {
            da.addPet(pet);
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.toString());
        }
        return "Pet Added Successfully";
    }

    @PutMapping("/pets/{id}")
    public String updatePet(@RequestBody Pet pet, @PathVariable Long id) {
        da.updatePet(pet);
        return "Pet Updated Successfully";
    }

    @DeleteMapping("/pets/{id}")
    public String deletePet(@PathVariable Long id) {
        da.deletePet(id);

        return "Pet Deleted Successfully";
    }
}