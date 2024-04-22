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

    public Event1(String eventTitle, String eventLocation, EventLevel eventLevel, int teacherId, int studentId, int eventId) {
        this.eventTitle = eventTitle;
        this.eventLocation = eventLocation;
        this.eventLevel = eventLevel;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.eventId = eventId;
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
}
