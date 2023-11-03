package com.mercadolibre.store.shopping.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mercadolibre.store.shopping.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
@CircuitBreaker(name = "customer-service", fallbackMethod = "create")
public class CustomerServiceClientFallback implements FallbackFactory<CustomerClient> {

//	@Override
//	public ResponseEntity<Customer> getCustomer(long id) {
//		Customer customer = Customer.builder()
//				.numberID("none")
//				.firstName("none")
//				.lastName("none")
//				.email("none")
//				.state("none").build();
//		return ResponseEntity.ok(customer);
//	}
	
	public CustomerClient create(Throwable cause) {
        return new CustomerClient() {
            @Override
            public ResponseEntity<Customer> getCustomer(long id)  {
            	Customer customer = Customer.builder()
        				.numberID("none")
        				.firstName("none")
        				.lastName("none")
        				.email("none")
        				.state("none").build();
                return  ResponseEntity.ok(customer);
            }
        };
    }
}
