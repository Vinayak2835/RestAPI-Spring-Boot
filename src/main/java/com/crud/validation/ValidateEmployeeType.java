package com.crud.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {
	
	public String message() default "Invalid Employee: must be PERMNENT OR VENDOR";
   
    public Class<?>[] groups() default {};
    
    public Class<? extends Payload>[] payload() default {};

}
