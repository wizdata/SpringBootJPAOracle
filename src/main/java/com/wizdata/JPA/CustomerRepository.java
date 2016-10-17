package com.wizdata.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.NamedStoredProcedureQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
    //@Query("select c from Customer c where c.firstName = ?1")
    //List<Customer> findByFirstName(String firstName);
    
    @NamedStoredProcedureQuery(
    		name = "findByFirstName", 
    		procedureName = "CRIS_COA_DELEGATOR_PKG.FIND_CUSTOMER_FIRSTNAME_PROC", 
    		resultClasses = List.class, 
    		parameters = {
    			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class), 
    			@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class)
    		}
    	)
    List<Customer> findByFirstName(String firstName);
}
