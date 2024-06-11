import java.util.ArrayList;
import java.util.Objects;

public class Student1 extends Person {
    ArrayList<Integer> eventId = new ArrayList<>();
    ArrayList<Integer> awardsId = new ArrayList<>();
    int teacherId;
    String teachersSecondName;
    String teachersFirstName;
    String teachersSurName;

    public Student1(String secondName, String firstName, String surName, int id, ArrayList<Integer> eventId) {
        super(secondName, firstName, surName, id);
        this.eventId = eventId;
    }

    public Student1(String secondName, String firstName, int id, int teacherId) {
        super(firstName, secondName, id);
        this.teacherId = teacherId;
    }

    public Student1(String secondName, String firstName) {
        super(firstName, secondName);
    }

    public Student1(String secondName, String firstName, String surName) {
        super(firstName, secondName, surName);
    }

    public Student1(String secondName, String firstName, int teacherId) {
        super(firstName, secondName);
        this.teacherId = teacherId;
    }

    public ArrayList<Integer> getEventId() {
        return eventId;
    }

    public void setEventId(ArrayList<Integer> eventId) {
        this.eventId = eventId;
    }

    public ArrayList<Integer> getAwardsId() {
        return awardsId;
    }

    public void setAwardsId(ArrayList<Integer> awardsId) {
        this.awardsId = awardsId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student1 student1 = (Student1) o;
        return teacherId == student1.teacherId && eventId.equals(student1.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eventId, teacherId);
    }

    @Override
    public String toString() {
        return "Учащийся{" +
                "Фамилия=" + secondName +
                ", Имя=" + firstName +
                ", Отчество='" + surName + '\'' +
                ", Id преподавателя='" + teacherId + '\'' +
                ", Id мероприятия='" + eventId + '\'' +
                ", id учащегося=" + id +
                '}';
    }
}
