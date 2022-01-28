package models;

public class User {
    private int id;
    private String name;
    private String surname;

    public User(){}

    public User(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public User(int id, String name, String surname) {
        this(name, surname);
        setId(id);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
