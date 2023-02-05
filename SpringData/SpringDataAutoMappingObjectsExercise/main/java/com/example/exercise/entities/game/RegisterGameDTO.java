package com.example.exercise.entities.game;

import com.example.exercise.exceptions.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegisterGameDTO {

    public static final Pattern YOUTUBE_ID_REGEX = Pattern.compile(
            "^(?=[a-zA-z0-9]*[A-Z])(?=[a-zA-z0-9]*[0-9])(?=[a-zA-z0-9]*[a-z])[a-zA-z0-9]{11}$");
    private static final Pattern TITLE_REGEX = Pattern.compile("^[A-Z].*$");
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final Integer minTitleLength = 3;
    private static final Integer maxTitleLength = 100;
    private static final Integer minDescriptionLength = 20;

    private String title;
    private BigDecimal price;
    private double sizeInMB;
    private String youtubeId;
    private String imageThumbnailURL;
    private String description;
    private LocalDate releaseDate;
    private final List<String> invalidParameters;

    public RegisterGameDTO() {
        this.invalidParameters = new ArrayList<>();
    }

    public RegisterGameDTO(String[] input) {
        this();
        if (input[0].equals("EditGame")) {
            this.update(input);
        } else {
            setTitle(input[1]);
            setPrice(BigDecimal.valueOf(Double.parseDouble(input[2])));
            setSizeInMB(Double.parseDouble(input[3]));
            setYoutubeId(input[4]);
            setImageThumbnailURL(input[5]);
            setDescription(input[6]);
            this.releaseDate = LocalDate.parse(input[7], DateTimeFormatter.ofPattern(DATE_FORMAT));
        }
        this.validate();
    }

    private void update(String[] input) {
        for (int i = 2; i < input.length; i++) {
            String field = input[i].split("=")[0];
            String value = input[i].split("=")[1];

            switch (field) {
                case "price" -> this.setPrice(BigDecimal.valueOf(Double.parseDouble(value)));
                case "size" -> this.setSizeInMB(Double.parseDouble(value));
                case "trailer" -> this.setYoutubeId(value);
                case "thumbnailURL" -> this.setImageThumbnailURL(value);
                case "description" -> this.setDescription(value);
                case "title" -> this.setTitle(value);
                default -> this.invalidParameters.add("No such field");
            }
        }
    }

    public void validate() {
        if (!this.invalidParameters.isEmpty()) {
            String message = String.join(System.lineSeparator(), this.invalidParameters);

            throw new ValidationException(message);
        }
    }

    public void setTitle(String title) {
        if (title.length() < minTitleLength) {
            this.invalidParameters.add("Game title too short");
        }

        if (title.length() > maxTitleLength) {
            this.invalidParameters.add("Game title too long");
        }

        if (!TITLE_REGEX.matcher(title).find()) {
            this.invalidParameters.add("Title must start with uppercase");
        } else {
            this.title = title;
        }
    }

    public void setPrice(BigDecimal price) {
        if (price.signum() <= 0) {
            this.invalidParameters.add("Price not valid");
        } else {
            this.price = price;
        }
    }

    public void setSizeInMB(double sizeInMB) {
        if (sizeInMB <= 0) {
            this.invalidParameters.add("Size not valid");
        } else {
            this.sizeInMB = sizeInMB;
        }
    }

    public void setYoutubeId(String youtubeId) {
        if (!YOUTUBE_ID_REGEX.matcher(youtubeId).find()) {
            this.invalidParameters.add("Invalid email");
        } else {
            this.youtubeId = youtubeId;
        }
    }

    public void setImageThumbnailURL(String imageThumbnailURL) {
        boolean rightURL = imageThumbnailURL.startsWith("https://") || imageThumbnailURL.startsWith("http://");

        if (!rightURL) {
            this.invalidParameters.add("Wrong thumbnail");
        } else {
            this.imageThumbnailURL = imageThumbnailURL;
        }
    }

    public void setDescription(String description) {
        if (description.length() < minDescriptionLength) {
            this.invalidParameters.add("Description too short");
        } else {
            this.description = description;
        }
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getSizeInMB() {
        return sizeInMB;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public String getImageThumbnailURL() {
        return imageThumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
