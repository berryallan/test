package com.workstation.demo.model;

import lombok.Data;

import java.util.Map;

@Data
public class CharacterDetails {
    private String name;
    private Map<String,String> details;
}
