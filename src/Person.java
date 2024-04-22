public class Person {
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
}
