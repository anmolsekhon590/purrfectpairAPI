package com.anmolsekhon.PurrfectPair.database;

import com.anmolsekhon.PurrfectPair.beans.Pet;
import com.anmolsekhon.PurrfectPair.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public List<Pet> getAllPets() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * From PET";

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Pet>(Pet.class));
    }

    public void addPet(Pet pet) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT INTO PET VALUES(NULL, :name, :type, :gender)";

        namedParameters.addValue("name", pet.getName())
                .addValue("type", pet.getType())
                .addValue("gender", pet.getGender());

        jdbc.update(query, namedParameters);
    }

    public void updatePet(Pet pet) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "UPDATE PET SET name = :name, type = :type, gender = :gender WHERE id = :id";

        namedParameters.addValue("id", pet.getId())
                .addValue("name", pet.getName())
                .addValue("type", pet.getType())
                .addValue("gender", pet.getGender());

        jdbc.update(query, namedParameters);
    }

    public void deletePet(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE FROM PET WHERE id = :id";

        namedParameters.addValue("id", id);

        jdbc.update(query, namedParameters);
    }

    public User getUserByEmail(String email) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * From USER WHERE email = :email";
        namedParameters.addValue("email", email);

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<User>(User.class)).get(0);
    }
}
