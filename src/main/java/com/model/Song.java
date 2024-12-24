package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[^@;,.=+$*%]+$")
    private String title;

    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[^@;,.=+$*%]+$")
    private String artist;

    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[^@;.=+$*%]+$")
    private String genre;

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
