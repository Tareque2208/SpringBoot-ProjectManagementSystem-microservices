package com.example.pma.services;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dto.EmployeeProject;
import com.example.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	//3 types of injections. Best is Field Injection

	//Field Injection
	@Autowired
	EmployeeRepository empRepo;

	//Constructor Injection
	//But for constructor injection we need to comment out autowired in the initialization
//	public EmployeeService(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}

	//Setter Injection
	//But for setter injection we need to comment out autowired in the initialization
//	@Autowired
//	public void setEmpRepo(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}

	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public Iterable<Employee> getAll() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}


}