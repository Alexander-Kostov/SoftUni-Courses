package com.example.exercise.entities.game;

import java.time.LocalDate;

public interface GameDetails {
    String GAME_INFO = "Title: %s%n" +
            "Price: %.2f%n" +
            "Description: %s%n" +
            "Release date: %s";

    String getDescription();

    LocalDate getReleaseDate();

}
