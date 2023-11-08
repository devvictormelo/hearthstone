package com.example.hearthstone.controllers;

import com.example.hearthstone.model.Cheap;
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

    @GetMapping(value = "detailed",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cheap> findAllDetailed() {
        return service.findAllDetailed();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cheap findById(@PathVariable(value = "id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Cheap cheap) {
        service.create(cheap);
        return ResponseEntity.ok(cheap);
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
