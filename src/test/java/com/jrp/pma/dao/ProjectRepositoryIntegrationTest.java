package com.jrp.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;

// While integration testing we need to load all the classes and methods and
// dependencies to run the testing. So, we need @ContextConfiguration annotation
// with value of a class which will load the application context for Spring.
// So that It brings all the beans,all the objects we need to autowire everything
// properly. We want to run unit or integration test just like the live server but in h2 memory.
// very first class to run our spring.
// @Runwith annotation is used for calling Spring Runner
// @DataJpaTest is to import database
// @SqlGroup is the group of sql files which we want to run


//@ContextConfiguration(classes = ProjectManagementApplication.class)
//@DataJpaTest

//Updated version
@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({
        @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts={"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts={"classpath:drop.sql"})})
public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository proRepo;

    @Test
    public void ifNewProjectSaved_thenSuccess(){
        Project newProject = new Project("New Test Project","COMPLETED", "Test Description");
        proRepo.save(newProject);
        assertEquals(5, proRepo.findAll().size());
    }
}
