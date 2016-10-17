package com.wizdata.JPA;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CustomerSpRepository<T, ID extends Serializable>
	extends Repository<T, ID>{
	
	List<T> findByFirstName(String firstName);
}
