package com.steeplesoft.jwfc.quarkus.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store extends BaseModel {
    @Id
    @SequenceGenerator(name = "store_seq", sequenceName = "store_store_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "store_seq")
    @Column(name = "store_id")
    private Long id;
    @Column(name = "manager_staff_id")
    private Long managerId;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public Store setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getManagerId() {
        return managerId;
    }

    public Store setManagerId(Long managerId) {
        this.managerId = managerId;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Store setAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(id, store.id) &&
                Objects.equals(managerId, store.managerId) &&
                Objects.equals(address, store.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerId, address);
    }
}
