package com.example.pma;


import java.util.Arrays;

import com.example.pma.springExample.Car;
import com.example.pma.springExample.Doors;
import com.example.pma.springExample.Engine;
import com.example.pma.springExample.Tires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;


@SpringBootApplication(scanBasePackages = {"com.example.pma", "com.example.utils"})
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository proRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner() {
//	return args -> {
//
//		Employee emp1 = new Employee("John", "Warton","warton@gmail.com");
//		Employee emp2 = new Employee("Mike", "Lanister","lanister@gmail.com");
//		Employee emp3 = new Employee("Steve", "Reeves","Reeves@gmail.com");
//		Employee emp4 = new Employee("Ronald", "Carson","connor@gmail.com");
//		Employee emp5 = new Employee("Jim", "Salvator","Sal@gmail.com");
//		Employee emp6 = new Employee("Peter", "Henley","henley@gmail.com");
//		Employee emp7 = new Employee("Richard", "Carson","carson@gmail.com");
//		Employee emp8 = new Employee("Honor", "Mills","miles@gmail.com");
//		Employee emp9 = new Employee("Tony", "Roggers","roggers@gmail.com");
//
//		Project pro1 = new Project("Large Production Deploy", "NOTSTARTED","This is a all hand job to develop and deploy in cloud");
//		Project pro2 = new Project("New Employee Budget", "COMPLETED","New talents must be recruited in either way");
//		Project pro3 = new Project("Office Reconstruction", "INPROGRESS","More employees means more space.");
//		Project pro4 = new Project("Improve Intranet Security", "INPROGRESS","This is gonna be awesome");
//
//		//need to set both sides relation manually
//		pro1.addEmployee(emp1);
//		pro1.addEmployee(emp3);
//		pro2.addEmployee(emp1);
//		pro3.addEmployee(emp1);
//		pro3.addEmployee(emp6);
//		pro4.addEmployee(emp6);
//		//need to set both sides relation manually
//		emp1.setProjects(Arrays.asList(pro1,pro2,pro3));
//		emp3.setProjects(Arrays.asList(pro1));
//		emp6.setProjects(Arrays.asList(pro3,pro4));
//
//		//save employees in DB
//		empRepo.save(emp1);
//		empRepo.save(emp2);
//		empRepo.save(emp3);
//		empRepo.save(emp4);
//		empRepo.save(emp5);
//		empRepo.save(emp6);
//		empRepo.save(emp7);
//		empRepo.save(emp8);
//		empRepo.save(emp9);
//
//		//save projects in DB
//		proRepo.save(pro1);
//		proRepo.save(pro2);
//		proRepo.save(pro3);
//		proRepo.save(pro4);
//
//
//		};
//	}
}
