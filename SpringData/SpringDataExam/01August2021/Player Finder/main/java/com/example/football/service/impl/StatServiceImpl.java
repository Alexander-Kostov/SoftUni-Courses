package com.example.football.service.impl;

import com.example.football.models.dto.ImportStatDTO;
import com.example.football.models.dto.ImportStatRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final Unmarshaller unmarshaller;

    private final Path path = Path.of("src", "main", "resources", "files", "xml", "stats.xml");
    private final Validator validator;
    private final ModelMapper mapper;


    @Autowired
    public StatServiceImpl(StatRepository statRepository) throws JAXBException {
        this.statRepository = statRepository;
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportStatRootDTO.class);
        this.unmarshaller = jaxbContext.createUnmarshaller();

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        //src/main/resources/files/xml/stats.xml
        return Files.readString(path);
    }

    @Override
    public String importStats() throws FileNotFoundException, JAXBException {
        ImportStatRootDTO statDTOs = (ImportStatRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return statDTOs.getStats().stream().map(this::importStat).collect(Collectors.joining("\n"));
    }

    private String importStat(ImportStatDTO dto) {
        Set<ConstraintViolation<ImportStatDTO>> dtoErrors = validator.validate(dto);

        if(!dtoErrors.isEmpty()){
            return "Invalid Stat";
        }

        Optional<Stat> optStat = this.statRepository.findByShootingAndPassingAndEndurance
                (dto.getShooting(), dto.getPassing(), dto.getEndurance());

        if (optStat.isPresent()) {
            return "Invalid Stat";
        }

        Stat stat = this.mapper.map(dto, Stat.class);

        this.statRepository.save(stat);

        return "Successfully imported Stat " + stat.getPassing() + " - " + stat.getShooting() + " - " + stat.getEndurance();
    }
}
