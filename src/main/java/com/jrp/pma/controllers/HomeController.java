package com.jrp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;
import com.jrp.pma.springExample.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	Car car;

	@Value("${version}")
	private String ver;

//	@Autowired
//	EmployeeRepository employeeRepo;

	@Autowired
	ProjectService proService;

	@Autowired
	EmployeeService empService;

	@GetMapping(value = "/")
	public String displayHome(Model model) throws JsonProcessingException {

		Map<String, Object> map = new HashMap<>();


		//we are querying the database for project
		List<Project> projects =  proService.getAll();
		model.addAttribute("projectlist",projects);

		//we are querying the database for project
		List<EmployeeProject> employeeProjectCnt =  empService.employeeProjects();
		model.addAttribute("employeeListProjectsCnt",employeeProjectCnt);


		//we are querying the database for project
		List<ChartData> projectStatus =  proService.getProjectStatus();

		//Converting ProjectStage data into json file
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectStatus);
		//We want these kind of json [string, value] : ["NotStarted", 1], ["INPROGRESS", 2], ["COMPLETED", 1]

		model.addAttribute("projectStatusCnt",jsonString);

		model.addAttribute("versionNumber",ver);
		return "main/home";
	}

}

