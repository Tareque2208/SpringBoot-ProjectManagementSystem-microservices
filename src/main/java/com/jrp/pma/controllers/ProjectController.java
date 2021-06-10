package com.jrp.pma.controllers;

import java.util.List;

import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
	
//	@Autowired
//	ProjectRepository projectRepo;


    @Autowired
    ProjectService proService;

    @Autowired
    EmployeeService empService;

    @GetMapping(value = "/new")
    public String displayProjectForm(Model model){
    	Project aProject = new Project();
    	Iterable<Employee> employees = empService.getAll();
    	model.addAttribute("project", aProject);
        model.addAttribute("employeeList", employees);
        return "projects/new-project";
    }
    
    
    @PostMapping("/save")
    public String createProject(Model model, Project project, @RequestParam List<Long> employees){
        proService.save(project);

        // use a redirect to prevent duplicate submissions
    	return "redirect:/projects/new";
    	
    }
    

    @RequestMapping
    public String displayProject(Model model){

    	//we are querying the database for project
    	List<Project> projects =  proService.getAll();
    	model.addAttribute("projectlist",projects);
    	
        return "projects/list-project";
    }

    
}
