package com.example.hearthstone.services;

import com.example.hearthstone.exceptions.ResourceNotFoundException;
import com.example.hearthstone.model.Card;
import com.example.hearthstone.model.Cheap;
import com.example.hearthstone.repositories.CardRepository;
import com.example.hearthstone.repositories.CheapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CheapService {

    private Logger logger = Logger.getLogger(Cheap.class.getName());

    @Autowired
    CheapRepository repository;

    public List<Cheap> findAll() {

        logger.info("Fiding all people!");

        return repository.findAll();
    }

    public Cheap findById(Long id) {

        logger.info("Fiding one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Cheap create(Cheap cheap) {

        logger.info("Creating one person!");

        Cheap savedCheap = repository.save(cheap);
        return this.findById(savedCheap.getId());
    }

    public Cheap update(Cheap cheap) {


        logger.info("Updating one person!");

        var entity = repository.findById(cheap.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));


        return repository.save(cheap);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
