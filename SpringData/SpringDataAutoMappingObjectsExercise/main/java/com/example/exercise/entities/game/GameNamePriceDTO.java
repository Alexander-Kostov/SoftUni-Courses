package com.example.exercise.entities.game;

import java.math.BigDecimal;

public interface GameNamePriceDTO extends GameNameDTO{
    BigDecimal getPrice();

    default String info() {
        return getTitle() + " " +getPrice();
    }
}
