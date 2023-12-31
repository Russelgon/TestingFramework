package asana.e2e.core.api.tech.matchers.createProject.responseMatcher;

import static asana.e2e.core.api.tech.http.HttpMapper.objectMapper;
import static org.hamcrest.MatcherAssert.assertThat;

import asana.e2e.integration.models.api.project.ProjectResponse;
import asana.e2e.integration.models.api.project.ProjectResponse.Data;
import java.net.http.HttpResponse;
import lombok.SneakyThrows;
import org.hamcrest.Matcher;

public class CreateProjectResponseDataMatcher extends Data {

    private static ProjectResponse projectResponse;

    @SneakyThrows
    public CreateProjectResponseDataMatcher(HttpResponse<String> response) {
        var projectResponse = objectMapper.readValue(response.body(), ProjectResponse.class);
        this.projectResponse = projectResponse;
    }

    public CreateProjectResponseDataMatcher name(Matcher<? super String> matcher) {
        assertThat(projectResponse.getData().getName(), matcher);
        return this;
    }

    public CreateProjectResponseDataMatcher gid(Matcher<? super String> matcher) {
        assertThat(projectResponse.getData().getGid(), matcher);
        return this;
    }

    public CreateProjectResponseDataMatcher resource_type(Matcher<? super String> matcher) {
        assertThat(projectResponse.getData().getResourceType(), matcher);
        return this;
    }

    public CreateProjectResponseDataMatcher workspace(WorkspaceMatcher matcher) {
        return this;
    }

    public static class WorkspaceMatcher
            extends Data.Workspace {

        public WorkspaceMatcher gid
                (Matcher<? super String> matcher) {
            assertThat(projectResponse.getData().getWorkspace().getGid(), matcher);
            return this;
        }

        public WorkspaceMatcher name
                (Matcher<? super String> matcher) {
            assertThat(projectResponse.getData().getWorkspace().getName(), matcher);
            return this;
        }

        public WorkspaceMatcher resourceType
                (Matcher<? super String> matcher) {
            assertThat(projectResponse.getData().getWorkspace().getResourceType(), matcher);
            return this;
        }
    }
}
