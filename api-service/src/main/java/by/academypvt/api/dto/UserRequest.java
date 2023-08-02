package by.academypvt.api.dto;

public class UserRequest {
    private String name;
    private String surname;
    private String login;
    private String password;

    public UserRequest(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
}
