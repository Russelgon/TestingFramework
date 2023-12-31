package asana.e2e.integration.models.entites.enums;

public enum ResourceTypes {

    USER("user"),

    WORKSPACE("workspace"),

    PROJECT("project"),

    TASK("task"),

    TAG("tag"),

    ATTACHMENT("attachment"),

    STORY("story"),

    TEAM("team");

    private final String type;

    ResourceTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
