package com.example.hearthstone.repositories;


import com.example.hearthstone.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //As anotações @Service e @Repository são utilizadas no Spring Boot para indicar que uma classe é um serviço e um repositório, respectivamente
public interface CardRepository extends JpaRepository<Card, Long> {}
