import java.util.ArrayList;

public interface PortfolioManagerInterface {
    void addTeacher(Teacher1 newTeacher);

    void addStudents(Student1 newStudent);

    void addEvent(Event1 newEvent);

    void addAwardsForTeacher(Awards reward);

    ArrayList<Teacher1> getTeachersList();

    ArrayList<Student1> getStudentsList();

    ArrayList<Event1> getEventsList();

    ArrayList<Awards> getAwardsList();

    Teacher1 getTeacherById(int teacherId);

    Student1 getStudentById(int studentId);

    Event1 getEventById(int eventId);

    Awards getRewardById(int rewordId);

    void removeTeacherById(int teacherId);

    void removeStudentById(int studentId);

    void removeEventById(int eventId);

    void removeRewordById(int rewordId);

    void removeAll();

    void removeAllTeachers();

    void removeAllStudents();

    void removeAllEvents();

    void removeAllAwards();

    ArrayList<Event1> getAllTeacherEventById(int teacherId);

    ArrayList<Event1> getAllStudentsEventById(int studentId);

    ArrayList<Awards> getAllTeachersAwardsById(int teacherId);

    ArrayList<Awards> getAllStudentsAwardsById(int studentId);

    void updateTeachers(Teacher1 updateTeacher);

    void updateStudent(Student1 updateStudent);

    void updateEvent(Event1 updateEvent);

    void updateReword(Awards updateAwards);
}
