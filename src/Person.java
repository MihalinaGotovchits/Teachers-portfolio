import java.util.Objects;

public abstract class Person {
    protected String firstName;
    protected String secondName;
    protected String surName;
    protected int id;

    public Person(String secondName, String firstName, String surName, int id){
        this.secondName = secondName;
        this.firstName = firstName;
        this.surName = surName;
        this.id = id;
    }

    public Person(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName =secondName;
    }

    public Person(String firstName, String secondName, String surName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
    }

    public Person(String firstName, String secondName, int id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && firstName.equals(person.firstName) && secondName.equals(person.secondName) && surName.equals(person.surName);
    }

    public int hashCode() {
        return Objects.hash(firstName, secondName, surName, id);
    }

    public String toString() {
        return "Человек{" +
                "Фамилия='" + secondName + '\'' +
                ", Имя='" + firstName + '\'' +
                ", Отчество='" + surName + '\'' +
                ", id=" + id +
                '}';
    }
}
