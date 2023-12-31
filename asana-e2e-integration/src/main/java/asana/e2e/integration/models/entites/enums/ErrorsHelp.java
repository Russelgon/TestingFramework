package asana.e2e.integration.models.entites.enums;

public enum ErrorsHelp {

    ERRORS_WORKSPACE("You should specify one of workspace, team",
            "For more information on API status codes and how to handle them, "
                    + "read the docs on errors: https://developers.asana.com/docs/errors"),

    ERRORS_PROJECT_ID("project: Not a recognized ID: %s",
            "For more information on API status codes and how to handle them, "
                + "read the docs on errors: https://developers.asana.com/docs/errors");

    private final String message;
    private final String help;

    ErrorsHelp(String message, String help) {
        this.message = message;
        this.help = help;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String value) {
        return String.format(message, value);
    }

    public String getHelp() {
        return help;
    }
}
