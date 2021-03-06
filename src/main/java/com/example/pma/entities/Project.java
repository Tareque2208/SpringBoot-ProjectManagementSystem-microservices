package com.example.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;

@Entity
public class Project {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "project_seq")
    private long projectId;
    private String name;

	private String stage;
    private String description;
    
//    @OneToMany()
//    @OneToMany(mappedBy="oneProject")
//    private List<Employee> employees;
    
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
    		CascadeType.REFRESH, CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
    joinColumns=@JoinColumn(name="project_id"),
    inverseJoinColumns=@JoinColumn(name="employee_id"))
    private List<Employee> employees;
    

    public Project() {

    }

    //projectId is the responsibility of database and we are not going to assign
    // that so we are not going to use that in constructor
    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }
    

    public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public void addEmployee(Employee emp) {
		if(employees==null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
		// TODO Auto-generated method stub
		
	}
}

