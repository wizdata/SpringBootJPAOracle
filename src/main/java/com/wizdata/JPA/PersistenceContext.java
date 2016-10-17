package com.wizdata.JPA;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableJpaRepositories(basePackages = {"com.wizdata.JPA"},
	repositoryFactoryBeanClass = CustomerSpRepositoryFactoryBean.class
)
@EnableTransactionManagement
public class PersistenceContext {

}
