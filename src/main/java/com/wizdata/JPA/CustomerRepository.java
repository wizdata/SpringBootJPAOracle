package com.wizdata.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
    //@Query("select c from Customer c where c.firstName = ?1")
    //List<Customer> findByFirstName(String firstName);
  
    @Procedure
    List<Customer> findByFirstName(String firstName);
}
