package com.steeplesoft.jwfc.quarkus.service;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.jwfc.quarkus.model.Customer;
import com.steeplesoft.jwfc.quarkus.repository.CustomerRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class CustomerService {
    @Inject
    protected CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.listAll(Sort.by("lastName"));
    }

    public Customer find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Customer Customer) {
        repository.persist(Customer);
    }

    @Transactional
    public void update(Customer customer) {
        Customer entity = find(customer.getId());
        if (entity != null) {
            entity.setFirstName(customer.getFirstName())
                    .setLastName(customer.getLastName())
                    .setActive(customer.isActive())
                    .setAddress(customer.getAddress())
                    .setEmail(customer.getEmail())
                    .setActive(customer.isActive())
                    .setStore(customer.getStore());
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
