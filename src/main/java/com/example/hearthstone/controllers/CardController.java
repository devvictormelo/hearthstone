package com.example.hearthstone.controllers;

import com.example.hearthstone.model.Card;
import com.example.hearthstone.model.Cheap;
import com.example.hearthstone.services.CardService;
import com.example.hearthstone.util.CardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Card findById(@PathVariable(value = "id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Card card) {
        CardValidator.validate(card);
        service.create(card);
        return ResponseEntity.ok(card);
    }

    @PostMapping(value = "list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Card>> createAll(@RequestBody List<Card> card) {
        service.saveAll(card);
        return ResponseEntity.ok().body(card);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Card update(@RequestBody Card card) {
        return service.update(card);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
