package com.workstation.demo.service;

import com.workstation.demo.source.MockSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CharacterService {

    @Autowired
    MockSource mockSource;

    public Map<String, String> getCharacterDetails(String characterName) {
        if(characterName.equalsIgnoreCase("avengers")){
           List<Character> characters = mockSource. getAvengers();
        }

        Map<String, String> hero = new TreeMap<>();
        return hero;

    }
}
