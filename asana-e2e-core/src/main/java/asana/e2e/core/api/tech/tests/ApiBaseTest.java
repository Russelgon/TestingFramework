package asana.e2e.core.api.tech.tests;

import asana.e2e.core.api.AsanaApiProject;
import asana.e2e.core.api.tech.constructors.ArrayConstructors;
import asana.e2e.core.api.tech.data.DataLoaderApi;
import java.io.IOException;
import java.net.URISyntaxException;
import lombok.SneakyThrows;
import org.junit.After;

public abstract class ApiBaseTest {

    protected final AsanaApiProject asanaApiProject = new AsanaApiProject();
    protected final ArrayConstructors arrayConstructors = new ArrayConstructors();

    @After
    @SneakyThrows
    public void deleteProjects() {
        var projectUser = DataLoaderApi.projectUser();
        var response = AsanaApiProject.asanaExecuteGetMultipleProjects2xx(projectUser);
        var listOfGid = arrayConstructors.getAllGidsConstructor(response);
        asanaApiProject.asanaExecuteDeleteMultiplyProjects(projectUser, listOfGid);
    }
}
