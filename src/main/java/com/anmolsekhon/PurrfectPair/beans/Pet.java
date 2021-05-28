package com.anmolsekhon.PurrfectPair.beans;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String gender;
}