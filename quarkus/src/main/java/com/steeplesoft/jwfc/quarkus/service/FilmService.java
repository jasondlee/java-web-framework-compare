package com.steeplesoft.jwfc.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.jwfc.quarkus.model.Film;
import com.steeplesoft.jwfc.quarkus.repository.FilmRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class FilmService {
    @Inject
    protected FilmRepository repository;

    public List<Film> findAll() {
        return repository.listAll(Sort.by("title"));
    }

    public Film find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Film film) {
        repository.persist(film);
    }

    @Transactional
    public void update(Film film) {
        Film entity = find(film.getId());
        if (entity != null) {
            entity.setTitle(film.getTitle())
                    .setDescription(film.getDescription())
                    .setReleaseYear(film.getReleaseYear())
                    .setRentalRate(film.getRentalRate())
                    .setLength(film.getLength())
                    .setReplacementCost(film.getReplacementCost())
                    .setRating(film.getRating())
                    .setSpecialFeatures(film.getSpecialFeatures())
                    .setFullText(film.getFullText());
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
