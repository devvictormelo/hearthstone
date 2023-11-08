package com.example.hearthstone.enums;

public enum EnumTypeLetter {
    SPELL("spell"),

    MINION("minions"),

    WEAPONS("weapons");

    private final String typeLatter;

    EnumTypeLetter(String typeLatter) {
        this.typeLatter = typeLatter;
    }

    public String getTypeLatter() {
        return typeLatter;
    }
}
