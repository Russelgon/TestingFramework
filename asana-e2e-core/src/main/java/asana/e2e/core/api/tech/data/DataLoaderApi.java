package asana.e2e.core.api.tech.data;

import static asana.e2e.core.baseTech.readers.FileReader.readValueFromFile;

import asana.e2e.integration.models.entites.ProjectUser;
import java.util.Properties;

public class DataLoaderApi {

    static Properties properties = new Properties();
    private static final String FILE_NAME = "E:\\porgrams\\IntelliJ IDEA Community Edition 2023.3.1\\asana-e2e\\data\\data.properties";
    private static final String TOKEN_PROPERTY_NAME = "token";
    private static final String GID_PROPERTY_NAME = "gid";

    public static ProjectUser projectUser() {
        return new ProjectUser()
                .setToken(readToken())
                .setGid(readGid());
    }

    //********************************CONFIGURATION*****************************************************

    private static String readToken() {
        return readValueFromFile(TOKEN_PROPERTY_NAME, FILE_NAME);
    }

    private static String readGid() {
        return readValueFromFile(GID_PROPERTY_NAME, FILE_NAME);
    }
}
