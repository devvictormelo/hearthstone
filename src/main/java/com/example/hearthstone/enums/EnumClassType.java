package com.example.hearthstone.enums;

public enum EnumClassType {
    MAGE("mage"),
    DRUID("druid"),
    HUNTER("hunter"),
    PALADIN("paladin"),
    ANY("any");

    private final String classType;

    EnumClassType(String classType) {
        this.classType = classType;
    }

    public String getClassType() {
        return classType;
    }


}
