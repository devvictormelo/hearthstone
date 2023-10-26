package com.example.hearthstone.util;

import com.example.hearthstone.model.Card;

public class CardValidator {

    public static void validate(Card card) {
        if (card.getId() > 30) {
            throw new IllegalStateException("O id do card deve ser menor ou igual a 30.");
        }
    }

}