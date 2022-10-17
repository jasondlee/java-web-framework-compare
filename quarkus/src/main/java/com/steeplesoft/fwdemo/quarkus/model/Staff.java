package com.steeplesoft.fwdemo.quarkus.model;

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
@Table(name = "staff")
public class Staff extends BaseModel {
    @Id
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_staff_id_seq", allocationSize=1)
    @GeneratedValue(generator = "staff_seq")
    @Column(name = "staff_id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String email;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
    private boolean active;
    private String userName;
    private String password;

    public Long getId() {
        return id;
    }

    public Staff setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Staff setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Staff setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Staff setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Staff setEmail(String email) {
        this.email = email;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public Staff setStore(Store store) {
        this.store = store;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Staff setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Staff setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Staff setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return active == staff.active &&
                Objects.equals(id, staff.id) &&
                firstName.equals(staff.firstName) &&
                lastName.equals(staff.lastName) &&
                Objects.equals(address, staff.address) &&
                Objects.equals(email, staff.email) &&
                Objects.equals(store, staff.store) &&
                Objects.equals(userName, staff.userName) &&
                Objects.equals(password, staff.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, email, store, active, userName, password);
    }
}
