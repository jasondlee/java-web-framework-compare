package com.steeplesoft.fwdemo.shared.model;

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
@Table(name = "address")
public class Address extends BaseModel {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "address_seq")
    @Column(name = "address_id")
    private Long id;
    private String address;
    private String address2;
    private String district;
    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public Address setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Address setDistrict(String district) {
        this.district = district;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Address setCity(City city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Address setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) && address.equals(address1.address) &&
                Objects.equals(address2, address1.address2) && Objects.equals(district, address1.district) &&
                city.equals(address1.city) && postalCode.equals(address1.postalCode) &&
                Objects.equals(phone, address1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, city, postalCode, phone);
    }
}
