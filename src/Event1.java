import java.util.Objects;

public class Event1 {
    private String eventTitle;
    private String eventLocation;
    protected EventLevel eventLevel = EventLevel.SCHOOL;
    private int participants;// количесство участников
    private int teacherId;
    private int studentId;
    private int eventId;

    public Event1(String eventTitle, String eventLocation, EventLevel eventLevel, int participants, int teacherId, int studentId, int eventId) {
        this.eventTitle = eventTitle;
        this.eventLocation = eventLocation;
        this.eventLevel = eventLevel;
        this.participants = participants;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.eventId = eventId;
    }

    public Event1(String eventTitle, EventLevel eventLevel, int participants, int teacherId, int eventId) {
        this.eventTitle = eventTitle;
        this.eventLevel = eventLevel;
        this.participants = participants;
        this.teacherId = teacherId;
        this.eventId = eventId;
    }

    public Event1(String eventTitle, String eventLocation, EventLevel eventLevel, int teacherId, int studentId) {
        this.eventTitle = eventTitle;
        this.eventLocation = eventLocation;
        this.eventLevel = eventLevel;
        this.teacherId = teacherId;
        this.studentId = studentId;
    }

    public Event1(String eventTitle, String eventLocation, EventLevel eventLevel, int teacherId){
        this.eventTitle = eventTitle;
        this.eventLocation = eventLocation;
        this.eventLevel = eventLevel;
        this.teacherId = teacherId;
    }

    public Event1(String eventTitle, int teacherId, int studentId) {
        this.eventTitle = eventTitle;
        this.teacherId = teacherId;
        this.studentId = studentId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public EventLevel getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(EventLevel eventLevel) {
        this.eventLevel = eventLevel;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event1 event1 = (Event1) o;
        return participants == event1.participants &&
               teacherId == event1.teacherId &&
               studentId == event1.studentId &&
               eventId == event1.eventId &&
               eventTitle.equals(event1.eventTitle) &&
               eventLocation.equals(event1.eventLocation) &&
               eventLevel == event1.eventLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventTitle, eventLocation, eventLevel, participants, teacherId, studentId, eventId);
    }

    @Override
    public String toString() {
        return "Мероприятие{" +
                "Название мероприятия='" + eventTitle + '\'' +
                ", Место проведения='" + eventLocation + '\'' +
                ", Уровень=" + eventLevel +
                ", Количество участников=" + participants +
                ", Id преподавателя=" + teacherId +
                ", Id учащегося=" + studentId +
                ", Id мероприятия=" + eventId +
                '}';
    }
}
