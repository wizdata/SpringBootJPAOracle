/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wizdata.JPA;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerSpRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    private Customer2Repository customers;
 
	@Test
    public void testFindByFirstNameSP() {
        Customer customer = new Customer("first", "last");
        System.out.println("hello");
        entityManager.persist(customer);
        System.out.println("hi");
        customers = new Customer2Repository();
        List<Customer> findByFirstName = customers.findByFirstName(customer.getFirstName());
		
		assertThat(findByFirstName).extracting(Customer::getFirstName).containsOnly(customer.getFirstName());
    }
}