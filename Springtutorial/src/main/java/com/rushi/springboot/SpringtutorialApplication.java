package com.rushi.springboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/Customers")
public class SpringtutorialApplication {
	
	private final CustomerRepo repo ;

	
	public SpringtutorialApplication(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

	Customer customer = new Customer();
	public static void main(String[] args) {
		SpringApplication.run(SpringtutorialApplication.class, args);
	}
	
	public String customer() {
		
		return "hello from customer";
	}
	
	@GetMapping
	public List<Customer> getCustomer(){
		
		return repo.findAll();
		}
	record NewCustomerRequest(String name,String email,Integer age) 
	{
		//Add customer
	}
	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) 
	{
		Customer customer = new Customer();
		customer.setName(request.name);
		customer.setAge(request.age);
		customer.setEmail(request.email);
		
		repo.save(customer);
	}
	
	@DeleteMapping("{CustomerId}")
	public void deleteCustomer(@PathVariable("CustomerId") Integer Id) {
		
		repo.deleteById(Id);
	}
	
	/*
	 * record UpdateCustomer(String name,String email,Integer age,Integer id) {
	 * //update customer }
	 * 
	 * public void UpdateCustomer(UpdateCustomer UpdateRequest) {
	 * 
	 * Customer customer = new Customer();
	 * 
	 * customer.setName(UpdateRequest.name); customer.setAge(UpdateRequest.age);
	 * customer.setEmail(UpdateRequest.email); repo.save(customer); }
	 */
	
	
	
	
	
	
	
}
