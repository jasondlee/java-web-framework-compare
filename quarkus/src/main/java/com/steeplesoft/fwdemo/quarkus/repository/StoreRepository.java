package com.steeplesoft.fwdemo.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.steeplesoft.fwdemo.shared.model.Store;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StoreRepository implements PanacheRepository<Store> {
}
