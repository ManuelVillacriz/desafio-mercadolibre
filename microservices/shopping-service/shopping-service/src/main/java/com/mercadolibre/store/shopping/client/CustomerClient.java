package com.mercadolibre.store.shopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mercadolibre.store.shopping.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name="customer-service", path = "/", url = CustomerClient.BASE_URL)
public interface CustomerClient {
	String BASE_URL = "http://localhost:8092";

	@CircuitBreaker(name = "customers", fallbackMethod = "getCustomerFallBack")
	@GetMapping(value = "/customers/{id}")	
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
	
	default ResponseEntity<Customer> getCustomerFallBack(Exception exception) {
		Customer customer = Customer.builder()
				.numberID("none")
				.firstName("none")
				.lastName("none")
				.email("none")
				.state("none").build();
		return ResponseEntity.ok(customer);
		//return Reply.builder().highestSeverity("FAILURE").build();
	}
	
}