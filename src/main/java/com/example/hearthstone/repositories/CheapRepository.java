package com.example.hearthstone.repositories;

import com.example.hearthstone.model.Cheap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheapRepository extends JpaRepository<Cheap, Long> {

}
