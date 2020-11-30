package entity;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable {
    private static final long serialVersionUID = -4337805810905229435L;

    private int id;
    private String name;
    private String login;
    private String email;
    private String phoneNumber;
    private UserType userType;
    private String password;

    public UserData(int id, String name, String login, String email, String phoneNumber, UserType userType, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.password = password;
    }

    public UserData() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType=" + userType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData user = (UserData) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, phoneNumber, userType);
    }
}

