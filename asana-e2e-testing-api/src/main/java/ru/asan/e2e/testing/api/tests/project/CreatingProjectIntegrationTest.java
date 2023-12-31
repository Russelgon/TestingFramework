package ru.asan.e2e.testing.api.tests.project;

import static asana.e2e.core.baseTech.RandomValueGenerator.ENG;
import static asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers.CreateProjectMatchers.createProjectResponseDataWorkspaceMatcher;
import static asana.e2e.integration.models.entites.enums.ErrorsHelp.ERRORS_WORKSPACE;
import static asana.e2e.integration.models.entites.enums.ResourceTypes.PROJECT;
import static asana.e2e.integration.models.entites.enums.ResourceTypes.WORKSPACE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import asana.e2e.core.baseTech.RandomValueGenerator;
import asana.e2e.core.api.tech.data.DataLoaderApi;
import asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers.CreateProjectMatchers;
import asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers.GeneralProjectMatchers;
import asana.e2e.core.api.tech.tests.ApiBaseTest;
import asana.e2e.integration.models.api.project.ProjectRequest;
import asana.e2e.integration.models.api.project.ProjectRequest.Data;
import asana.e2e.integration.models.entites.ProjectUser;
import java.net.http.HttpResponse;
import jdk.jfr.Name;
import org.junit.Test;

public class CreatingProjectIntegrationTest extends ApiBaseTest {

    @Test
    @Name("TEST_1. Api. Creating. Creating project in Asana")
    public void TEST_1_Api__Creating__Creating_project_in_Asana() {

        // Step 1.1 Data preparation
        ProjectUser projectUser = DataLoaderApi.projectUser();
        ProjectRequest requestBody = new ProjectRequest()
                .setData(new Data()
                        .setName(RandomValueGenerator.randomLengthString(5, 10, ENG))
                        .setWorkspace(projectUser.getGid()));

        // Step 2.1 Send request to server
        HttpResponse<String> response = asanaApiProject.asanaExecuteCreateProject2хх(requestBody,
                projectUser);

        // Step Assert 3.1 Checking the results of sending a request
        CreateProjectMatchers.createProjectResponseDataMatcher(response)
                .gid(not(equalTo(nullValue())))
                .name(equalTo(requestBody.getData().getName()))
                .resource_type(equalTo(PROJECT.getType()))
                .workspace(createProjectResponseDataWorkspaceMatcher()
                        .gid(equalTo(projectUser.getGid()))
                        .resourceType(equalTo(WORKSPACE.getType())));
    }

    @Test
    @Name("TEST_2. Api. Creating. Workspace gid = null")
    public void TEST_2_Api__Creating__Workspace_Gid_is_null() {

        // Step 1.1 Data preparation
        ProjectUser projectUser = DataLoaderApi.projectUser();
        ProjectRequest requestBody = new ProjectRequest()
                .setData(new Data()
                        .setName(RandomValueGenerator.randomLengthString(5, 10, ENG))
                        .setWorkspace(null));

        // Step 2.1 Send request to server
        HttpResponse<String> response = asanaApiProject.asanaExecuteCreateProject4хх(requestBody,
                projectUser);

        // Step Assert 3.1 Checking the results of sending a request
        GeneralProjectMatchers
                .projectResponseErrorMatcher(response)
                .message(equalTo(ERRORS_WORKSPACE.getMessage()))
                .help(equalTo(ERRORS_WORKSPACE.getHelp()));
    }
}
