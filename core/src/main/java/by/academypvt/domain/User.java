package by.academypvt.domain;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import by.academypvt.api.dto.user.Role;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -7994607932307928487L;
    private long userid;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +'\'' +
                "login=" + login +'\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                '}' + "\n";
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public User(String name, String surname, String login, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(long userid, String name, String surname, String login, String password, Role role) {
        this.userid = userid;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
