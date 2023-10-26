package com.example.hearthstone.model;

import com.example.hearthstone.enums.EnumPlayerClass;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "life")
    private Long life;

    @Column(name = "mana")
    private Long mana;

    @Column(name = "playerClass")
    private EnumPlayerClass playerClass;

    public EnumPlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(EnumPlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    private enum PlayerClass {
        Mage,
        Hunter,
        Warrior,
        Druid

    }

    public Player(Long id, String name, Long life, Long mana) {
        this.id = id;
        this.name = name;
        this.life = life;
        this.mana = mana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLife() {
        return life;
    }

    public void setLife(Long life) {
        this.life = life;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }
}
