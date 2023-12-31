package asana.e2e.core.api;

import static asana.e2e.core.api.tech.asserts.AssertsApi.statusAssert2XX;
import static asana.e2e.core.api.tech.asserts.AssertsApi.statusAssert4XX;
import static asana.e2e.core.baseTech.logger.LoggerMapper.httpLogger;
import static asana.e2e.integration.models.entites.ApiHeadersEntites.AUTHORIZATION_HEADER;
import static asana.e2e.integration.models.entites.ApiHeadersEntites.BEARER_HEADER;
import static asana.e2e.integration.models.entites.ApiHeadersEntites.CONTENT_TYPE_HEADER;
import static asana.e2e.integration.models.entites.ApiHeadersEntites.JSON_HEADER;
import static asana.e2e.integration.models.entites.ApiHttpEntites.ASANA_API_PROJECTS;
import static java.net.http.HttpRequest.BodyPublishers.ofString;

import asana.e2e.core.api.tech.http.HttpMapper;
import asana.e2e.integration.models.api.project.ProjectRequest;
import asana.e2e.integration.models.api.project.ProjectResponse;
import asana.e2e.integration.models.entites.ProjectUser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import lombok.SneakyThrows;

public class AsanaApiProject extends HttpMapper {

    static HttpClient client = HttpClient.newHttpClient();

    //******CREATE_PROJECT*********************************************************************************

    /**
     * Executes a POST request to create a project in Asana API.
     *
     * @param requestBody the request body containing the project data
     * @param projectUser the user associated with the project
     * @return the HTTP response containing the result of the request
     */
    @SneakyThrows
    private static HttpResponse<String> asanaExecuteCreateProject(ProjectRequest requestBody,
            ProjectUser projectUser) {

        var bodyValue = objectMapper.writeValueAsString(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ASANA_API_PROJECTS))
                .header(AUTHORIZATION_HEADER, BEARER_HEADER + projectUser.getToken())
                .header(CONTENT_TYPE_HEADER, JSON_HEADER)
                .POST(ofString(bodyValue))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        httpLogger(response, request, bodyValue);
        return response;
    }

    public HttpResponse<String> asanaExecuteCreateProject2хх(ProjectRequest requestBody,
            ProjectUser projectUser) {
        HttpResponse<String> response = asanaExecuteCreateProject(requestBody, projectUser);
        statusAssert2XX(response);
        return response;
    }

    public HttpResponse<String> asanaExecuteCreateProject4хх(ProjectRequest requestBody,
            ProjectUser projectUser) {
        HttpResponse<String> response = asanaExecuteCreateProject(requestBody, projectUser);
        statusAssert4XX(response);
        return response;
    }

    @SneakyThrows
    public String asanaExecuteCreateProjectGetGid(ProjectRequest requestBody,
            ProjectUser projectUser) {

        HttpResponse<String> response = asanaExecuteCreateProject2хх(requestBody, projectUser);
        var projectResponse = objectMapper.readValue(response.body(), ProjectResponse.class);

        return projectResponse.getData().getGid();
    }

    //******DELETE_PROJECT*********************************************************************************

    /**
     * Executes a DELETE request to delete a project in the Asana API.
     *
     * @param projectUser the user associated with the project
     * @param projectGid  the ID of the project to be deleted
     * @return the HTTP response containing the result of the request
     */
    @SneakyThrows
    private static HttpResponse<String> asanaExecuteDeleteProject(
            ProjectUser projectUser, String projectGid) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ASANA_API_PROJECTS + projectGid))
                .header(AUTHORIZATION_HEADER, BEARER_HEADER + projectUser.getToken())
                .header(CONTENT_TYPE_HEADER, JSON_HEADER)
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        httpLogger(response, request);
        return response;
    }

    public HttpResponse<String> asanaExecuteDeleteProject2хх(ProjectUser projectUser,
            String projectGid) {
        HttpResponse<String> response = asanaExecuteDeleteProject(projectUser, projectGid);
        statusAssert2XX(response);
        return response;
    }

    public void asanaExecuteDeleteMultiplyProjects(ProjectUser projectUser,
            List<String> listOfGid) {

        for (var projectGid : listOfGid) {
            HttpResponse<String> response = asanaExecuteDeleteProject(projectUser, projectGid);
            statusAssert2XX(response);
        }
    }

    public HttpResponse<String> asanaExecuteDeleteProject4хх(ProjectUser projectUser,
            String projectGid) {
        HttpResponse<String> response = asanaExecuteDeleteProject(projectUser, projectGid);
        statusAssert4XX(response);
        return response;
    }

    //******GET_PROJECT*********************************************************************************

    /**
     * Executes a GET request to retrieve project details from the Asana API.
     *
     * @param projectUser the user associated with the project
     * @param projectGid  the ID of the project to retrieve
     * @return the HTTP response containing the project details
     */
    @SneakyThrows
    private static HttpResponse<String> asanaExecuteGetProject(
            ProjectUser projectUser, String projectGid) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ASANA_API_PROJECTS + projectGid))
                .header(AUTHORIZATION_HEADER, BEARER_HEADER + projectUser.getToken())
                .header(CONTENT_TYPE_HEADER, JSON_HEADER)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        httpLogger(response, request);
        return response;
    }

    public static HttpResponse<String> asanaExecuteGetProject2xx(ProjectUser projectUser,
            String projectGid) {
        HttpResponse<String> response = asanaExecuteGetProject(projectUser, projectGid);
        statusAssert2XX(response);
        return response;
    }

    public static HttpResponse<String> asanaExecuteGetProject4xx(ProjectUser projectUser,
            String projectGid) {
        HttpResponse<String> response = asanaExecuteGetProject(projectUser, projectGid);
        statusAssert4XX(response);
        return response;
    }

    //******GET_MULTIPLE_PROJECTS*********************************************************************************

    /**
     * Executes a GET request to retrieve multiple projects from the Asana API.
     *
     * @param projectUser the user associated with the projects
     * @return the HTTP response containing the multiple projects
     */

    @SneakyThrows
    private static HttpResponse<String> asanaExecuteGetMultipleProjects(
            ProjectUser projectUser) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ASANA_API_PROJECTS))
                .header(AUTHORIZATION_HEADER, BEARER_HEADER + projectUser.getToken())
                .header(CONTENT_TYPE_HEADER, JSON_HEADER)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        httpLogger(response, request);
        return response;
    }

    public static HttpResponse<String> asanaExecuteGetMultipleProjects2xx(ProjectUser projectUser) {
        HttpResponse<String> response = asanaExecuteGetMultipleProjects(projectUser);
        statusAssert2XX(response);
        return response;
    }
}
