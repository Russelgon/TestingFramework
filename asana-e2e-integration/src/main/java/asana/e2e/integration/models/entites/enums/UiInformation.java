package asana.e2e.integration.models.entites.enums;

public enum UiInformation {
    ERRORS_EMAIL("Email address", "Please enter a valid email address."),

    ERRORS_PASSWORD("Password", "The username or password is not correct. Did you forget your password?");

    private final String message;
    private final String error;

    UiInformation(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String value) {
        return String.format(message, value);
    }

    public String getError() {
        return error;
    }
}
