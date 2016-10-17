package com.wizdata.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

@Repository
public class Customer2Repository {
	
	@PersistenceContext
    EntityManager entityManager;
	
	public Customer2Repository(){}
	
	public List<Customer> findByFirstName(String firstName) {
		StoredProcedureQuery query = entityManager
			    .createStoredProcedureQuery("CRIS_COA_DELEGATOR_PKG.FIND_CUSTOMER_FIRSTNAME_PROC")
			    .registerStoredProcedureParameter(1, String.class, 
			         ParameterMode.IN)
			    .registerStoredProcedureParameter(2, List.class, 
			         ParameterMode.REF_CURSOR)
			    .setParameter(1, firstName);
			 
			query.execute();
			 
			List<Customer> customers = (List<Customer>) query.getResultList();
			
			return customers;
	}
}
	
