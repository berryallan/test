package com.workstation.demo.controller;

import com.workstation.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/superheros")
public class DemoController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/characters")
    public ResponseEntity<Map<String,String>> getCharacterDetails(
            @RequestParam String characterName)
    {
        Map<String,String> characterDetails = characterService.getCharacterDetails(characterName);
       return new ResponseEntity<>(characterDetails, HttpStatus.OK);
    }


}
