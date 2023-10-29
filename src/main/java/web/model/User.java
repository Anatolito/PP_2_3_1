package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "surname")
    private String userSurname;

    @Column(name = "age")
    private int userAge;

    public User() {
    }

    public User(String name, int age) {
        this.userName = name;
        this.userAge = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int age) {
        this.userAge = age;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String surname) {
        this.userSurname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
