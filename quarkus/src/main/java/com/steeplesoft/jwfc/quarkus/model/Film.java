package com.steeplesoft.jwfc.quarkus.model;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.steeplesoft.jwfc.quarkus.util.RatingConverter;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.basic.YearType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "film")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
@TypeDef(
        name = "year",
        typeClass = YearType.class
)
public class Film extends BaseModel {
    @Id
    @SequenceGenerator(name = "film_seq", sequenceName = "film_film_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "film_seq")
    @Column(name = "film_id")
    private Long id;
    private String title;
    private String description;
    @Type(type = "year")
    @Column(name = "release_year")
    private Year releaseYear;
    @Column(name = "rental_rate")
    private Double rentalRate;
    private Integer length;
    @Column(name = "replacement_cost")
    private Double replacementCost;
    @Convert(converter = RatingConverter.class)
    private Rating rating;
    @Type(type = "list-array")
    @Column(name = "special_features")
    private List<String> specialFeatures;
    private String fullText;

    @OneToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    public Long getId() {
        return id;
    }

    public Film setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Film setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Film setDescription(String description) {
        this.description = description;
        return this;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public Film setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public Film setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public Film setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public Film setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public Film setRating(Rating mpaaRating) {
        this.rating = mpaaRating;
        return this;
    }

    public List<String> getSpecialFeatures() {
        return specialFeatures;
    }

    public Film setSpecialFeatures(List<String> specialFeatures) {
        this.specialFeatures = specialFeatures;
        return this;
    }

    public String getFullText() {
        return fullText;
    }

    public Film setFullText(String fullText) {
        this.fullText = fullText;
        return this;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public Film setActors(List<Actor> actors) {
        this.actors = actors;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(releaseYear, film.releaseYear) && Objects.equals(rentalRate, film.rentalRate) && Objects.equals(length, film.length) && Objects.equals(replacementCost, film.replacementCost) && rating == film.rating && Objects.equals(specialFeatures, film.specialFeatures) && Objects.equals(fullText, film.fullText) && Objects.equals(actors, film.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseYear, rentalRate, length, replacementCost, rating, specialFeatures, fullText, actors);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating=" + rating +
                ", specialFeatures=" + specialFeatures +
                ", fullText='" + fullText + '\'' +
                ", actors=" + actors +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
