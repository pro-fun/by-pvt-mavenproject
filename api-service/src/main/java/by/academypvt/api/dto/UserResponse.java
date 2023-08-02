package by.academypvt.api.dto;

public class UserResponse {
    private String name;
    private String surname;
    private String login;
    private String fullName;

    public UserResponse(String name, String surname, String login, String fullName) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.fullName = fullName;
    }
}
