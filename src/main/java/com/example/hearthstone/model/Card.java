package com.example.hearthstone.model;

import com.example.hearthstone.enums.EnumClassType;
import com.example.hearthstone.enums.EnumTypeLetter;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "card")
public class Card implements Serializable {

    @Serial //Essa anotação é usada para marcar classes e métodos que são relevantes para a serialização
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "attack", length = 2)
    private Long attack;

    @Column(name = "defense", length = 2)
    private Long defense;


    @Column(name = "mana", length = 2)
    private Long mana;

    @Column(name = "typeLetter")
    @Enumerated(EnumType.STRING)
    private EnumTypeLetter typeLetter;

    @Column(name = "classType")
    @Enumerated(EnumType.STRING)
    private EnumClassType classType;

    public EnumTypeLetter getTypeLetter() {
        return typeLetter;
    }

    public void setTypeLetter(EnumTypeLetter typeLetter) {
        this.typeLetter = typeLetter;
    }

    public EnumClassType getClassType() {
        return classType;
    }

    public void setClassType(EnumClassType classType) {
        this.classType = classType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
