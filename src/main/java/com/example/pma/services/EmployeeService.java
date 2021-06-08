package com.example.pma.services;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dto.EmployeeProject;
import com.example.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {




	//Field Injection
	//1 way to solve bean error is to give @primary annotation in
	//any class I want
	//Another is using @Qualifier annotation and using subclass name as value.
	//While using subclass name as value we MUST use first letter as lowerCase
	@Qualifier("staffRepositoryImplementation1")
	@Autowired
	IStaffRepository empRepo;

//	EmployeeRepository empRepo;
	//Constructor Injection
	//But for constructor injection we need to comment out autowired in the initialization
//	public EmployeeService(IStaffRepository empRepo) {
//		this.empRepo = empRepo;
//	}

	//Setter Injection
	//But for setter injection we need to comment out autowired in the initialization
	//Using @Qualifier annotation in setter injection is similar to field injection
//	@Qualifier("staffRepositoryImplementation1")
//	@Autowired
//	public void setEmpRepo(IStaffRepository empRepo) {
//		this.empRepo = empRepo;
//	}

//	public Employee save(Employee employee) {
//		return empRepo.save(employee);
//	}
//
//
//	public Iterable<Employee> getAll() {
//		return empRepo.findAll();
//	}
//
//
//	public List<EmployeeProject> employeeProjects() {
//		return empRepo.employeeProjects();
//	}


}