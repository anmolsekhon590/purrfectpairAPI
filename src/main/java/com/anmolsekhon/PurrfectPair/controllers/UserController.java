package com.anmolsekhon.PurrfectPair.controllers;

import com.anmolsekhon.PurrfectPair.beans.User;
import com.anmolsekhon.PurrfectPair.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public DatabaseAccess da;

    @PostMapping("/user/login")
    public String isValid(@RequestBody User user) {
        User selectedUser = da.getUserByEmail(user.getEmail());
        boolean valid;
        if (user.getEmail().equals(selectedUser.getEmail()) && user.getPassword().equals(selectedUser.getPassword())) {
            valid = true;
        } else {
            valid = false;
        }

        return "{\"isValid\":" + valid+"}";
    }
}
