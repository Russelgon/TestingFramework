package asana.e2e.core.api.tech.data.user;

public class UserUi {

    private String mail;

    public String getMail() {
        return mail;
    }

    public UserUi setMail(String mail) {
        this.mail = mail;
        return this;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public UserUi setPassword(String password) {
        this.password = password;
        return this;
    }

    private String name;

    public String getName() {
        return name;
    }

    public UserUi setName(String name) {
        this.name = name;
        return this;
    }
}
