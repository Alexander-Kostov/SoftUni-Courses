package com.example.football.service.impl;

import com.example.football.models.dto.ImportPlayerDTO;
import com.example.football.models.dto.ImportPlayerRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Validator validator;
    private PlayerRepository playerRepository;
    private Unmarshaller unmarshaller;
    private final ModelMapper mapper;

    private TeamRepository teamRepository;

    private TownRepository townRepository;

    private StatRepository statRepository;


    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, TownRepository townRepository, StatRepository statRepository) throws JAXBException {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;

        JAXBContext jaxbContext = JAXBContext.newInstance(ImportPlayerRootDTO.class);
        this.unmarshaller = jaxbContext.createUnmarshaller();
        this.mapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.mapper.addConverter(ctx -> LocalDate.parse(ctx.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                String.class, LocalDate.class);
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        //src/main/resources/files/xml/players.xml
        Path path = Path.of("src", "main", "resources", "files", "xml", "players.xml");

        return String.join("\n", Files.readString(path));
    }

    @Override
    public String importPlayers() throws FileNotFoundException, JAXBException {
        Path path = Path.of("src", "main", "resources", "files", "xml", "players.xml");

        ImportPlayerRootDTO playerDTOs = (ImportPlayerRootDTO)
                this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));


        playerDTOs.getPlayers().stream().map(this::ImportPlayer).collect(Collectors.joining("\n"));
        return null;
    }

    private String ImportPlayer(ImportPlayerDTO dto) {
        Set<ConstraintViolation<ImportPlayerDTO>> errors = validator.validate(dto);

        if(!errors.isEmpty()){
            return "Invalid Player";
        }

        Optional<Player> optPlayer = this.playerRepository.findByEmail(dto.getEmail());

        if (optPlayer.isPresent()){
            return "Invalid Player";
        }

        Optional<Team> team = this.teamRepository.findByName(dto.getTeamName().getName());
        Optional<Town> town = this.townRepository.findByName(dto.getTownName().getName());
        Optional<Stat> stat = this.statRepository.findById(dto.getStat().getId());

        Player player = mapper.map(dto, Player.class);

        player.setTeam(team.get());
        player.setTown(town.get());
        player.setStat(stat.get());

        this.playerRepository.save(player);

        return "Successfully imported Player " + player.getFirstName() + " " + player.getLastName() + " - "
                + player.getPosition().toString();


    }

    @Override
    public String exportBestPlayers() {
        LocalDate before = LocalDate.of(2003,01,01);
        LocalDate after = LocalDate.of(1995,01,01);

        List<Player> players = this.playerRepository.findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);


        return players.stream().map(Player::toString).collect(Collectors.joining("\n"));
    }
}
