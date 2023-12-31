package asana.e2e.integration.models.entites;

public class ApiHttpEntites {

    public static final String ASANA_API_BASE_URL = "https://app.asana.com/api/1.0";
    public static final String ASANA_API_PROJECTS = slashConcat(ASANA_API_BASE_URL, "projects/");

    private static String slashConcat(String... s) {
        return String.join("/", s);
    }
}
