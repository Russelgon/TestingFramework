package asana.e2e.core.api.tech.asserts;

import static asana.e2e.core.api.AsanaApiProject.asanaExecuteGetProject2xx;
import static asana.e2e.core.api.AsanaApiProject.asanaExecuteGetProject4xx;
import static asana.e2e.core.api.tech.enums.StatusCodes.CODES2XX;
import static asana.e2e.core.api.tech.enums.StatusCodes.CODES4XX;
import static asana.e2e.core.baseTech.logger.LoggerMapper.LOGGER;
import static asana.e2e.integration.models.entites.enums.ErrorsHelp.ERRORS_PROJECT_ID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.fail;

import asana.e2e.core.api.tech.http.HttpMapper;
import asana.e2e.core.api.tech.matchers.createProject.baseCreateProjectsMatchers.GeneralProjectMatchers;
import asana.e2e.integration.models.entites.ProjectUser;
import java.net.http.HttpResponse;
import java.util.Arrays;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertsApi extends HttpMapper {

    public static <T> void statusAssert2XX(HttpResponse<String> response) {
        if (Arrays.stream(CODES2XX.getCodes())
                .anyMatch(code -> code == response.statusCode())) {
            LOGGER.info("HTTP response code: {}", CODES2XX);
        } else {
            LOGGER.error("Error while http response: " + response.body());
            fail("HTTP response code: " + response.statusCode());
        }
    }

    public static <T> void statusAssert4XX(HttpResponse<String> response) {
        if (Arrays.stream(CODES4XX.getCodes())
                .anyMatch(code -> code == response.statusCode())) {
            LOGGER.info("HTTP response code: {}", CODES4XX);
        } else {
            LOGGER.error("Error while http response: " + response.body());
            fail("HTTP response code: " + response.statusCode());
        }
    }

    public static HttpResponse<String> assertThatProjectExists(ProjectUser projectUser,
            String projectGid) {
        var response = asanaExecuteGetProject2xx(projectUser, projectGid);
        return response;
    }

    @SneakyThrows
    public static HttpResponse<String> assertThatProjectNotExists(ProjectUser projectUser,
            String projectGid) {
        var response = asanaExecuteGetProject4xx(projectUser, projectGid);

        GeneralProjectMatchers
                .projectResponseErrorMatcher(response)
                .message(startsWith(ERRORS_PROJECT_ID.getMessage(projectGid)))
                .help(equalTo(ERRORS_PROJECT_ID.getHelp()));
        return response;
    }
}
