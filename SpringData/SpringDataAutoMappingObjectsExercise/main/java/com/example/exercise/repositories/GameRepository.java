package com.example.exercise.repositories;

import com.example.exercise.entities.game.Game;
import com.example.exercise.entities.game.GameDetails;
import com.example.exercise.entities.game.GameNameDTO;
import com.example.exercise.entities.game.GameNamePriceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface GameRepository extends JpaRepository<Game, Integer> {
    int countByTitle(String title);
    int countByTitleAndDeletedFalse(String title);
//    Optional<Game> findByTitleAndDeletedFalse(String title);

    Optional<Game> findByIdAndDeletedFalse(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Game g SET g.deleted = true WHERE g.id = :id AND g.deleted = false")
    int updateDeleteTrueById(Long id);

    @Query("SELECT g.title AS title FROM Game g WHERE g.id = :id")
    GameNameDTO selectTitleById(Long id);

    @Query("SELECT g.title AS title, g.price AS price FROM Game g")
    Set<GameNamePriceDTO> selectAllTitleAndPrice();

    Optional<GameDetails> findByTitle(String title);

    Set<Game> findByTitleIn(Collection<String> cart);
}
