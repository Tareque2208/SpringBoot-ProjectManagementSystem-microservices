package com.example.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pma.dao.ProjectRepository;
import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	ProjectRepository empRepo;

    @GetMapping(value = "/new")
    public String displayProjectForm(Model model){
    	Project aProject = new Project();
    	model.addAttribute("project", aProject);
        return "projects/new-project";
    }
    
    
    @PostMapping("/save")
    public String createProject(Model model, Project project){
    	projectRepo.save(project);
    	
    	//need to add @RequestParam List<Long> employees, in the parameter
//    	Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
//    	for(Employee emp : chosenEmployees) {
//    		emp.setProject(project);
//    		empRepo.save(emp);
//    	}
    	
    	return "redirect:/projects/new";
    	
    }
    

    @RequestMapping
    public String displayProject(Model model){

    	//we are querying the database for project
    	List<Project> projects =  projectRepo.findAll();
    	model.addAttribute("projectlist",projects);
    	
        return "projects/list-project";
    }

    
}
