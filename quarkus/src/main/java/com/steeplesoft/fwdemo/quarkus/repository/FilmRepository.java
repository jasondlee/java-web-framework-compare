package com.steeplesoft.fwdemo.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.steeplesoft.fwdemo.quarkus.model.Film;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<Film> {
}
