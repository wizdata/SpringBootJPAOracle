package com.wizdata.JPA;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
	import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
	import org.springframework.data.repository.core.RepositoryMetadata;
	import org.springframework.data.repository.core.support.RepositoryFactorySupport;
	 
	import javax.persistence.EntityManager;
	import java.io.Serializable;
	 
	public class CustomerSpRepositoryFactoryBean<R extends JpaRepository<T, ID>, T,
	        ID extends Serializable> extends JpaRepositoryFactoryBean<R, T, ID> {
	 
	    @Override
	    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
	        return new CustomerSpRepositoryFactory(em);
	    }
	 
	    private static class CustomerSpRepositoryFactory<T, ID extends Serializable>
	            extends JpaRepositoryFactory {
	 
	        private final EntityManager em;
	 
	        public CustomerSpRepositoryFactory(EntityManager em) {
	            super(em);
	            this.em = em;
	        }
	 	      
	        @Override
	        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
	            return CustomerSpRepositoryImpl.class;
	        }
	    }
	}

