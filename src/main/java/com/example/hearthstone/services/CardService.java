package com.example.hearthstone.services;

import com.example.hearthstone.exceptions.ResourceNotFoundException;
import com.example.hearthstone.model.Card;
import com.example.hearthstone.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CardService {

    private Logger logger = Logger.getLogger(Card.class.getName());

    @Autowired
    CardRepository repository;

    public List<Card> findAll() {

        logger.info("Fiding all people!");

        return repository.findAll();
    }

    public Card findById(Long id) {

        logger.info("Fiding one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public void create(Card person) {

        logger.info("Creating one person!");

        repository.save(person);
    }

    public void saveAll(List<Card> persons) {

        logger.info("Creating many person!");

        repository.saveAll(persons);
    }

    public Card update(Card card) {


        logger.info("Updating one person!");

        var entity = repository.findById(card.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        card.setName(card.getName());
        card.setAttack(card.getAttack());
        card.setDefense(card.getDefense());
        card.setMana(card.getMana());
        card.setDescription(card.getDescription());
        card.setClassType(card.getClassType());
        card.setTypeLetter(card.getTypeLetter());

        return repository.save(card);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
