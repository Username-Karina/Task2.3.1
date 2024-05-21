package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users_in_my_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String username;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;

    public User() {}

    public User(String username, String surname, int age) {
        this.username = username;
        this.surname = surname;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", surname=" + surname + ", age=" + age +"]";
    }


}
