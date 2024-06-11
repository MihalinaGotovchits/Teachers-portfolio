import java.util.Objects;

public class Awards {
    private String awardsTitle;
    //private Date awardsDate;//дата награждения
    private String description;
    protected AwardsLevel awardsLevel = AwardsLevel.SCHOOL;
    private int teacherId;
    private String teachersName;
    private int eventId;
    private int studentId;
    private int rewardId;

    public Awards(String awardsTitle, String description, AwardsLevel awardsLevel) {
        this.awardsTitle = awardsTitle;
        this.description = description;
        this.awardsLevel = awardsLevel;
    }

    public Awards(String awardsTitle, String description, AwardsLevel awardsLevel, int teacherId, int eventId, int studentId) {
        this.awardsTitle = awardsTitle;
        this.description = description;
        this.awardsLevel = awardsLevel;
        this.teacherId = teacherId;
        this.eventId = eventId;
        this.studentId = studentId;
    }

    public Awards(String awardsTitle, String description, AwardsLevel awardsLevel, int teacherId, String teachersName) {
        this.awardsTitle = awardsTitle;
        this.description = description;
        this.awardsLevel = awardsLevel;
        this.teacherId = teacherId;
        this.teachersName = teachersName;
    }

    public Awards(String awardsTitle, String description, AwardsLevel awardsLevel, int studentId, int teacherId) {
        this.awardsTitle = awardsTitle;
        this.description = description;
        this.awardsLevel = awardsLevel;
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardsTitle() {
        return awardsTitle;
    }

    public void setAwardsTitle(String awardsTitle) {
        this.awardsTitle = awardsTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AwardsLevel getAwardsLevel() {
        return awardsLevel;
    }

    public void setAwardsLevel(AwardsLevel awardsLevel) {
        this.awardsLevel = awardsLevel;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Awards awards = (Awards) o;
        return teacherId == awards.teacherId && eventId == awards.eventId && studentId == awards.studentId && rewardId == awards.rewardId && awardsTitle.equals(awards.awardsTitle) && description.equals(awards.description) && awardsLevel == awards.awardsLevel;
    }

    public int hashCode() {
        return Objects.hash(awardsTitle, description, awardsLevel, teacherId, eventId, studentId, rewardId);
    }

    public String toString() {
        return "Награда{" +
                "Название награды='" + awardsTitle + '\'' +
                ", Описание='" + description + '\'' +
                ", Уровень=" + awardsLevel +
                ", Имя преподавателя=" + teachersName +
                ", Id мероприятия=" + eventId +
                ", Id учащегося=" + studentId +
                ", Id награды=" + rewardId +
                '}';
    }
}
