import java.util.ArrayList;

public class Student1 extends Person{
    ArrayList<Integer> eventId = new ArrayList<>();
    public Student1(String secondName, String firstName, String surName, int id, ArrayList<Integer> eventId) {
        super(secondName, firstName, surName, id);
        this.eventId = eventId;
    }

    public Student1(String firstName, String secondName) {
        super(firstName, secondName);
    }

    public Student1(String firstName, String secondName, String surName) {
        super(firstName, secondName, surName);
    }

    public ArrayList<Integer> getEventId() {
        return eventId;
    }

    public void setEventId(ArrayList<Integer> eventId) {
        this.eventId = eventId;
    }
}
