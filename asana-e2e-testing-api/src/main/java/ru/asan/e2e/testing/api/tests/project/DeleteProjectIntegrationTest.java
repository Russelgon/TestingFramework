package ru.asan.e2e.testing.api.tests.project;

import static asana.e2e.core.baseTech.RandomValueGenerator.ENG;
import static asana.e2e.core.baseTech.RandomValueGenerator.num;
import static asana.e2e.core.baseTech.RandomValueGenerator.randomLengthString;
import static asana.e2e.core.api.tech.asserts.AssertsApi.assertThatProjectNotExists;
import static asana.e2e.integration.models.entites.enums.ErrorsHelp.ERRORS_PROJECT_ID;
import static org.hamcrest.CoreMatchers.equalTo;

import asana.e2e.core.baseTech.RandomValueGenerator;
import asana.e2e.core.api.tech.data.DataLoaderApi;
import asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers.GeneralProjectMatchers;
import asana.e2e.core.api.tech.tests.ApiBaseTest;
import asana.e2e.integration.models.api.project.ProjectRequest;
import asana.e2e.integration.models.api.project.ProjectRequest.Data;
import asana.e2e.integration.models.entites.ProjectUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import jdk.jfr.Name;
import org.junit.Test;

public class DeleteProjectIntegrationTest extends ApiBaseTest {

    @Test
    @Name("TEST_3. Api. Delete. Delete project in Asana")
    public void TEST_3_Api__Delete__Delete_project_in_Asana()
            throws IOException, URISyntaxException, InterruptedException {

        // Step 1.1 Data preparation
        ProjectUser projectUser = DataLoaderApi.projectUser();
        ProjectRequest requestBody = new ProjectRequest()
                .setData(new Data()
                        .setName(RandomValueGenerator.randomLengthString(5, 10, ENG))
                        .setWorkspace(projectUser.getGid()));

        // Step 2.1 Creating project
        var projectGid = asanaApiProject.asanaExecuteCreateProjectGetGid(requestBody, projectUser);

        // Step 2.2 Delete project
        asanaApiProject.asanaExecuteDeleteProject2хх(projectUser, projectGid);

        // Step Assert 3.1 Check that project no more exist
        assertThatProjectNotExists(projectUser, projectGid);
    }

    @Test
    @Name("TEST_4. Api. Delete. Not correct ID when trying to delete project in Asana")
    public void TEST_4_Api__Delete__Delete_project_in_Asana_with_not_correct_ID()
            throws IOException, URISyntaxException, InterruptedException {

        // Step 1.1 Data preparation
        ProjectUser projectUser = DataLoaderApi.projectUser();
        String projectGid = randomLengthString(16, 16, num);

        // Step 2.2 Delete project
        HttpResponse<String> response = asanaApiProject.asanaExecuteDeleteProject4хх(projectUser, projectGid);

        // Step Assert 3.1 Checking the results of sending a request
        GeneralProjectMatchers
                .projectResponseErrorMatcher(response)
                .message(equalTo(ERRORS_PROJECT_ID.getMessage(projectGid)))
                .help(equalTo(ERRORS_PROJECT_ID.getHelp()));
    }
}
