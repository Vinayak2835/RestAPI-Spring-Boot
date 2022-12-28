package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.model.Employee;


public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
