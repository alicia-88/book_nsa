package com.nsa.book_nsa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eve_id")
    private Long id;

    @NotBlank(message = "Le nom de l'événement est obligatoire")
    @Size(max = 45, message = "Le nom de l'événement ne doit pas dépasser 45 caractères")
    @Column(name = "eve_name", nullable = false)
    private String name;

    @Column(name = "user_use_id")
    private Long userId;

    @NotBlank(message = "La date de l'événement est obligatoire")
    @Size(max = 45, message = "La date de l'événement ne doit pas dépasser 45 caractères")
    @Column(name = "eve_date", nullable = false)
    private String date;

    @Size(max = 45, message = "L'heure de début ne doit pas dépasser 45 caractères")
    @Column(name = "eve_time_start")
    private String timeStart;

    @Size(max = 45, message = "L'heure de fin ne doit pas dépasser 45 caractères")
    @Column(name = "eve_time_end")
    private String timeEnd;

    @Size(max = 45, message = "La ville ne doit pas dépasser 45 caractères")
    @Column(name = "eve_city")
    private String city;

    @Size(max = 45, message = "Le lieu ne doit pas dépasser 45 caractères")
    @Column(name = "eve_place")
    private String place;

    @Column(name = "author_aut_id")
    private Long authorId;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
