package asana.e2e.integration.models.entites;

public class ProjectUser {

    private String token;

    public String getToken() {
        return token;
    }

    public ProjectUser setToken(String token) {
        this.token = token;
        return this;
    }

    private String gid;

    public String getGid() {
        return gid;
    }

    public ProjectUser setGid(String gid) {
        this.gid = gid;
        return this;
    }
}
