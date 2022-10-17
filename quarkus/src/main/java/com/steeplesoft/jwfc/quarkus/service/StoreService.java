package com.steeplesoft.jwfc.quarkus.service;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.jwfc.quarkus.model.Store;
import com.steeplesoft.jwfc.quarkus.repository.StoreRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class StoreService {
    @Inject
    protected StoreRepository repository;

    public List<Store> findAll() {
        return repository.listAll();
    }

    public Store find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Store store) {
        repository.persist(store);
    }

    @Transactional
    public void update(Store store) {
        Store entity = find(store.getId());
        if (entity != null) {
            entity.setAddress(store.getAddress())
                    .setManagerId(store.getId())
                    .setInventory(store.getInventory());
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
