// tag::sample[]
package com.wizdata.JPA;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@SequenceGenerator(
	        name="CUSTOMER_SEQUENCE_GENERATOR",
	        sequenceName="CUSTOMER_SEQ"
	    )
	@Id() 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_SEQUENCE_GENERATOR")    
    @Column(name="customer_id")
    private Long id;
	
    @Column(name="customer_first_nm")
    private String firstName;
    
    @Column(name="customer_last_nm")
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

// end::sample[]

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

