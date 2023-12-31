package asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers;

import asana.e2e.core.api.tech.matchers.createProject.responseMatcher.ProjectResponseErrorMatcher;
import java.net.http.HttpResponse;

public class GeneralProjectMatchers {

    public static ProjectResponseErrorMatcher projectResponseErrorMatcher(
            HttpResponse<String> response) {
        return new ProjectResponseErrorMatcher(response);
    }
}
