package com.example.hearthstone.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cheap")
public class Cheap implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "card_cheap",
            joinColumns = @JoinColumn(name = "cheap_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    List<Card> cards;

    public Cheap(Long id, List<Card> cards) {
        this.id = id;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
