package com.steeplesoft.jwfc.quarkus.service;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.steeplesoft.jwfc.quarkus.model.Staff;
import com.steeplesoft.jwfc.quarkus.repository.StaffRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class StaffService {
    @Inject
    protected StaffRepository staffRepository;

    public List<Staff> findAll() {
        return staffRepository.listAll(Sort.by("lastName"));
    }

    public Staff find(Long id) {
        return staffRepository.findById(id);
    }

    @Transactional
    public void create(Staff staff) {
        staffRepository.persist(staff);
    }

    @Transactional
    public void update(Staff staff) {
        Staff entity = find(staff.getId());
        if (entity != null) {
            entity.setFirstName(staff.getFirstName())
                    .setLastName(staff.getLastName())
                    .setActive(staff.isActive())
                    .setAddress(staff.getAddress())
                    .setUserName(staff.getUserName())
                    .setEmail(staff.getEmail())
                    .setPassword(staff.getPassword())
                    .setStore(staff.getStore());
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }
}
