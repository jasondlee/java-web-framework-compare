package com.steeplesoft.fwdemo.shared.model;

import java.time.LocalDate;
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
@Table(name = "customer")
public class Customer extends BaseModel {
    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_customer_id_seq", allocationSize=1)
    @GeneratedValue(generator = "customer_seq")
    @Column(name = "customer_id")
    private Long id;
    @OneToOne
    @JoinColumn(name="store_id")
    private Store store;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    private boolean active;
    @Column(name="create_date", updatable = false)
    private LocalDate create_date;

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public Customer setStore(Store store) {
        this.store = store;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Customer setActive(boolean active) {
        this.active = active;
        return this;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public Customer setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active && Objects.equals(id, customer.id) && Objects.equals(store, customer.store) && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && email.equals(customer.email) && Objects.equals(address, customer.address) && Objects.equals(create_date, customer.create_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, store, firstName, lastName, email, address, active, create_date);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", store=" + store +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", active=" + active +
                ", create_date=" + create_date +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
