package com.mindbowser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindbowser.model.EmployeeEntity;
import com.mindbowser.model.ManagerEntity;
import com.mindbowser.repository.EmployeeRepository;
import com.mindbowser.repository.ManagerRepository;

@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<EmployeeEntity> getEmployeeDetails()
	{
	return employeeRepository.findAll();
	}
	
	public void saveUpdateEmployeeDetails(EmployeeEntity employeeEntity) throws Exception {
		employeeRepository.save(employeeEntity);
	}
	
	public void deleteEmployee(String empId) throws Exception {
		employeeRepository.deleteById(Integer.parseInt(empId));
	}
	
}
