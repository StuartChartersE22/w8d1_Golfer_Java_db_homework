package models;

import javax.persistence.*;

@Entity
@Table(name = "golfers")
public class Golfer {

    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Golfer(){}

    public Golfer(String firstName, String lastName, int age){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
