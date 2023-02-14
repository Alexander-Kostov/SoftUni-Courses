package com.likebookapp.repository;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    Optional<Mood> findByMoodName(MoodName mood);
}
