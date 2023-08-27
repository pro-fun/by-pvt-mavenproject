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
                "userid=" + userid +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid == user.userid && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, surname, login, password, role);
    }


    public User(String name, String surname, String login, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;

    }
}
