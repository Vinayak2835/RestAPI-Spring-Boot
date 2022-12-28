package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.crud.validation.ValidateEmployeeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@NotBlank(message="Name shouldn't be null")
	private String name;
	
	@NotBlank
	private String location;
	
	private double salary;
	
	@Min(18)
	@Max(40)
	private int age;
	
	@ValidateEmployeeType   //Custom annotation
	private String empType; //Permnent or Vendor
	
	private String password;
}
