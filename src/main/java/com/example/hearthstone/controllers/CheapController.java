package com.example.hearthstone.controllers;

import com.example.hearthstone.model.Card;
import com.example.hearthstone.model.Cheap;
import com.example.hearthstone.services.CardService;
import com.example.hearthstone.services.CheapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cheap")
public class CheapController {

    @Autowired
    private CheapService service;

    @Autowired
    private CardService cardService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> findAll() {
        return cardService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cheap findById(@PathVariable(value = "id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cheap create(@RequestBody Cheap cheap) {
        return service.create(cheap);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cheap update(@RequestBody Cheap cheap) {
        return service.update(cheap);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
