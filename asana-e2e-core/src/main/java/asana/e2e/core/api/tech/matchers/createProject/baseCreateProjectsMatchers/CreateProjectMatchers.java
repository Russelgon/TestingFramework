package asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers;

import asana.e2e.core.api.tech.matchers.createProject.responseMatcher.CreateProjectResponseDataMatcher;
import java.net.http.HttpResponse;

public class CreateProjectMatchers {

    public static CreateProjectResponseDataMatcher createProjectResponseDataMatcher(
            HttpResponse<String> response) {
        return new CreateProjectResponseDataMatcher(response);
    }

    public static CreateProjectResponseDataMatcher.WorkspaceMatcher createProjectResponseDataWorkspaceMatcher() {
        return new CreateProjectResponseDataMatcher.WorkspaceMatcher();
    }
}
