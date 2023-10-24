package com.example.hearthstone.model;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "card")
public class Card implements Serializable {

    @Serial //Essa anotação é usada para marcar classes e métodos que são relevantes para a serialização
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Cheap> cheaps;

    @Column(name = "name")
    private String name;

    @Column(name = "description" )
    private Long description;

    @Column(name = "attack", length = 2)
    private Long attack;

    @Column(name = "defense", length = 2)
    private Long defense;


    @Column(name = "mana", length = 2)
    private Long mana;

    private enum type {
        Spell,
        Minions,
        Weapons

    }

    private enum letterClass {
        Mage,
        Hunter,
        Warrior,
        Druid
    }

    public Card(Long id, List<Cheap> cheaps, String name, Long description, Long attack, Long defense, Long mana) {
        this.id = id;
        this.cheaps = cheaps;
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.defense = defense;
        this.mana = mana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cheap> getCheaps() {
        return cheaps;
    }

    public void setCheaps(List<Cheap> cheaps) {
        this.cheaps = cheaps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public Long getAttack() {
        return attack;
    }

    public void setAttack(Long attack) {
        this.attack = attack;
    }

    public Long getDefense() {
        return defense;
    }

    public void setDefense(Long defense) {
        this.defense = defense;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }
}
