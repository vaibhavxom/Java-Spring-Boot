package com.rushi.springboot;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Customer {
	@Id
	@SequenceGenerator
	( 	name = "Customer_Id_Sequence",sequenceName = "Customer_Id_Sequence",allocationSize = 1   )
	
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "Customer_Id_Sequence")
	private Integer id ;
	private String name;
	private Integer age ;
	private String email;
	
	public Customer(Integer id, String name, Integer age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	

	public Customer() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, email, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(age, other.age) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	
	
	



	
	 

}
