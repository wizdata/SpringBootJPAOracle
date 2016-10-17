package com.wizdata.JPA;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerSpRepositoryImpl<T, ID extends Serializable>
	extends SimpleJpaRepository<T, ID> implements CustomerSpRepository<T, ID> {

	private final EntityManager entityManager;
	
	public CustomerSpRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
	  super(domainClass, entityManager);
	
	  // Keep the EntityManager around to used from the newly introduced methods.
	  this.entityManager = entityManager;
	}
	
	public List<T> findByFirstName(String firstName) {
		StoredProcedureQuery query = entityManager
			    .createStoredProcedureQuery("cris.findByFirstName")
			    .registerStoredProcedureParameter(1, String.class, 
			         ParameterMode.IN)
			    .registerStoredProcedureParameter(2, List.class, 
			         ParameterMode.REF_CURSOR)
			    .setParameter(1, firstName);
			 
			query.execute();
			 
			List<T> customers = (List<T>) query.getResultList();
			
			return customers;
	}
	
}
