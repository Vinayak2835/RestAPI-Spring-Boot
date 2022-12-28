package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.exception.ResourceNotFoundException;
import com.crud.exception.WrongpasswordFormatexception;
import com.crud.model.Employee;
import com.crud.repository.EmpRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepository empRepository;

	public Employee save(Employee employee) {

		// Password Logic
		if (employee.getPassword().contains("VINAY")) {
			employee.setPassword(employee.getPassword());
		} else {
			throw new WrongpasswordFormatexception("Password should begins with:" + employee.getPassword());
		}
		System.out.println(employee);
		return this.empRepository.save(employee);
	}

	public Employee getEmployeeById(int id) {
		return this.empRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with an id: " + id));
	}

	public Employee updateEmployee(int id, Employee emp) {

		Employee employee = this.empRepository.findById(id).get();
		employee.setEmpId(emp.getEmpId());
		employee.setName(emp.getName());
		employee.setSalary(emp.getSalary());
		employee.setLocation(emp.getLocation());
		employee.setAge(emp.getAge());
		employee.setEmpType(emp.getEmpType());

		this.empRepository.save(employee);

		return employee;
	}

}
