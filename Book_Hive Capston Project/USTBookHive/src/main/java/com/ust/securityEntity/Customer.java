package com.ust.securityEntity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookHive_Customer")
public class Customer {

    @GeneratedValue
    @Id
    private Long customerID;

    //
    private String firstName, lastName, address;

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne
    private AppUser user;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }
    //

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID);
    }

}
