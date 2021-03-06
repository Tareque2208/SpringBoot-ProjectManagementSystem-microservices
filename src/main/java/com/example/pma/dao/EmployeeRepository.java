package com.example.pma.dao;

import java.util.List;

import com.example.pma.dto.EmployeeProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>  {

	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value = "select e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as ProjectCount FROM employee e left join project_employee pe ON e.employee_id=pe.employee_id GROUP BY e.first_name, e.last_name ORDER BY 3 DESC;")
	public List<EmployeeProject> employeeProjects();
}
