package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoodsSeeder implements CommandLineRunner {
    private MoodRepository moodRepository;

    public MoodsSeeder(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(this.moodRepository.count() <= 0) {
            List<Mood> moods = Arrays.stream(MoodName.values()).map(Mood::new).collect(Collectors.toList());

            this.moodRepository.saveAll(moods);
        }
    }
}
