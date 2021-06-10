package com.jrp.pma.controllers;

import javax.validation.Valid;
import com.jrp.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jrp.pma.entities.Employee;


@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;


    @GetMapping
    public String displayEmployees(Model model){
        //we are querying the database for project
        Iterable<Employee> employees = empService.getAll();
        model.addAttribute("employees",employees);
        return "employees/list-employee";
    }

    @GetMapping(value = "/new")
    public String displayEmployeeForm(Model model){
    	Employee aEmployee = new Employee();
    	model.addAttribute("employee", aEmployee);
        return "employees/new-employee";
    }
    
    
    @PostMapping("/save")
    public String createEmployee(Model model, @Valid Employee employee){

        //need to add @RequestParam List<Long> projects, in the parameter
//    	Iterable<Project> chosenProjects = proRepo.findAllById(projects);
//    	for(Project pro : chosenProjects) {
//    		pro.setEmployee(employee);
//    		proRepo.save(pro);
//    	}


        empService.save(employee);
    	return "redirect:/employees/new";
    	
    }

    

}
