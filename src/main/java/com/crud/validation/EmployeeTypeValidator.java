package com.crud.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class EmployeeTypeValidator implements ConstraintValidator<ValidateEmployeeType,String>
{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		List<String> empType = Arrays.asList("PERMNENT","VENDOR");
		
		return empType.contains(value);
	}

	

}
