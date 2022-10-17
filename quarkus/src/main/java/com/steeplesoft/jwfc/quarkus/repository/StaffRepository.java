package com.steeplesoft.jwfc.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.steeplesoft.jwfc.quarkus.model.Staff;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StaffRepository implements PanacheRepository<Staff> {
}
