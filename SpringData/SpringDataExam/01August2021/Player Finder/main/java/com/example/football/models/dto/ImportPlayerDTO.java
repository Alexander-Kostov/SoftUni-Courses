package com.example.football.models.dto;

import com.example.football.models.entity.PlayerPosition;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPlayerDTO {

    @XmlElement(name = "first-name")
    @Size(min = 2)
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2)
    private String lastName;
    @XmlElement
    @Email
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement
    private PlayerPosition position;

    @XmlElement(name = "town")
    private NameDTO townName;

    @XmlElement(name = "team")
    private NameDTO teamName;

    @XmlElement(name = "stat")
    private StatIdDTO stat;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public NameDTO getTownName() {
        return townName;
    }

    public NameDTO getTeamName() {
        return teamName;
    }

    public StatIdDTO getStat() {
        return stat;
    }
}
