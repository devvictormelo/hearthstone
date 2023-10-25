package com.example.hearthstone.model;


import com.example.hearthstone.enums.EnumLatterClass;
import com.example.hearthstone.enums.EnumTypeLetter;
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
    List<Cheap> cheap;

    @Column(name = "name")
    private String name;

    @Column(name = "description" )
    private String description;

    @Column(name = "attack", length = 2)
    private Long attack;

    @Column(name = "defense", length = 2)
    private Long defense;


    @Column(name = "mana", length = 2)
    private Long mana;

    @Column(name = "latterCLass")
    @Enumerated(EnumType.STRING)
    private EnumLatterClass latterClass;

    @Column(name = "typeLetter")
    @Enumerated(EnumType.STRING)
    private EnumTypeLetter typeLetter;

    public EnumLatterClass getLatterClass() {
        return latterClass;
    }

    public void setLatterClass(EnumLatterClass latterClass) {
        this.latterClass = latterClass;
    }

    public EnumTypeLetter getTypeLetter() {
        return typeLetter;
    }

    public void setTypeLetter(EnumTypeLetter typeLetter) {
        this.typeLetter = typeLetter;
    }

    public Card(Long id, List<Cheap> cheap, String name, String description, Long attack, Long defense, Long mana) {
        this.id = id;
        this.cheap = cheap;
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

    public List<Cheap> getCheap() {
        return cheap;
    }

    public void setCheap(List<Cheap> cheap) {
        this.cheap = cheap;
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
