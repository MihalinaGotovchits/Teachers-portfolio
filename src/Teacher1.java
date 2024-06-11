import java.util.ArrayList;
import java.util.Objects;

public class Teacher1 extends Person {
    ArrayList<Integer> eventId = new ArrayList<>();
    ArrayList<Integer> awardsId = new ArrayList<>();
    ArrayList<Student1> studentsList = new ArrayList<>();
    ArrayList<Awards> awardsList = new ArrayList<>();
    ArrayList<Event1> event1List = new ArrayList<>();

    public Teacher1(String secondName, String firstName, String surName, int id, ArrayList<Integer> eventId) {
        super(secondName, firstName, surName, id);
        this.eventId = eventId;
    }

    public Teacher1(String secondName, String firstName) {
        super(firstName, secondName);
    }

    public Teacher1(String secondName, String firstName, String surName) {
        super(firstName, secondName, surName);
    }

    public Teacher1(String secondName, String firstName, String surName, int id, ArrayList<Integer> eventId,
                    ArrayList<Integer> awardsId) {
        super(secondName, firstName, surName, id);
        this.eventId = eventId;
        this.awardsId = awardsId;
    }

    public Teacher1(String secondName, String firstName, String surName, ArrayList<Awards> awardsList){
        super(secondName, firstName, surName);
        this.awardsList = awardsList;
    }

    public ArrayList<Integer> getEventId() {
        return eventId;
    }

    public ArrayList<Integer> getAwardsId() {
        return awardsId;
    }

    public ArrayList<Awards> getAwardsList(){
        return awardsList;
    }

    public ArrayList<Event1> getEvent1List() {
        return event1List;
    }

    public ArrayList<Student1> getStudentsList() {
        return studentsList;
    }

    public void setAwardsId(ArrayList<Integer> awardsId) {
        this.awardsId = awardsId;
    }

    public void setEventId(ArrayList<Integer> eventId) {
        this.eventId = eventId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher1 teacher1 = (Teacher1) o;
        return eventId.equals(teacher1.eventId) && awardsId.equals(teacher1.awardsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eventId, awardsId);
    }

    @Override
    public String toString() {
        return "Преподаватель{" +
                "Фамилия=" + secondName +
                ", Имя=" + firstName +
                ", Отчество='" + surName + '\'' +
                ", Id награды='" + awardsId + '\'' +
                ", Id мероприятия='" + eventId + '\'' +
                ", id преподавателя=" + id +
                '}';
    }
}
