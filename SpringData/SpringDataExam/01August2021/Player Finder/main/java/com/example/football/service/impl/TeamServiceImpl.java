package com.example.football.service.impl;

import com.example.football.models.dto.ImportTeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final Validator validator;
    private final ModelMapper mapper;
    private TeamRepository teamRepository;
    private Gson gson;
    private TownRepository townRepository;


    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;

        this.gson = new GsonBuilder().create();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        //src/main/resources/files/json/teams.json
        Path path = Path.of("src", "main", "resources", "files", "json", "teams.json");

        return String.join("\n", Files.readAllLines(path));
    }

    @Override
    public String importTeams() throws IOException {
        String json = this.readTeamsFileContent();

        ImportTeamDTO[] teamsDTOs = this.gson.fromJson(json, ImportTeamDTO[].class);

        return Arrays.stream(teamsDTOs)
                .map(this::ImportTeam)
                .collect(Collectors.joining("\n"));
    }

    private String ImportTeam(ImportTeamDTO dto) {
        Set<ConstraintViolation<ImportTeamDTO>> errors = this.validator.validate(dto);

        if (!errors.isEmpty()){
            return "Invalid Team";
        }

        Optional<Team> optTeam = teamRepository.findByName(dto.getName());

        if(optTeam.isPresent()){
            return "Invalid Team";
        }

        Team team = mapper.map(dto, Team.class);
        Optional<Town> town = this.townRepository.findByName(dto.getTownName());

        team.setTown(town.get());

        this.teamRepository.save(team);

        return String.format("Successfully imported Town %s - %d", dto.getTownName(), dto.getFanBase());

    }
}
