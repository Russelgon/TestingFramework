package asana.e2e.core.api.tech.matchers.createProject.responseMatcher;

import static asana.e2e.core.api.tech.http.HttpMapper.objectMapper;
import static org.hamcrest.MatcherAssert.assertThat;

import asana.e2e.integration.models.api.project.ProjectResponse;
import asana.e2e.integration.models.api.project.ProjectResponse.Errors;
import java.net.http.HttpResponse;
import lombok.SneakyThrows;
import org.hamcrest.Matcher;

public class ProjectResponseErrorMatcher extends Errors {

    private static ProjectResponse projectResponse;

    @SneakyThrows
    public ProjectResponseErrorMatcher(HttpResponse<String> response) {
        var projectResponse = objectMapper.readValue(response.body(), ProjectResponse.class);
        this.projectResponse = projectResponse;
    }

    public ProjectResponseErrorMatcher message(Matcher<? super String> matcher) {
        assertThat(projectResponse.getErrors()[0].getMessage(), matcher);
        return this;
    }

    public ProjectResponseErrorMatcher help(Matcher<? super String> matcher) {
        assertThat(projectResponse.getErrors()[0].getHelp(), matcher);
        return this;
    }

    public ProjectResponseErrorMatcher phrase(Matcher<? super String> matcher) {
        assertThat(projectResponse.getErrors()[0].getPhrase(), matcher);
        return this;
    }
}
