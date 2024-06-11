import java.beans.Introspector;
import java.util.ArrayList;
import java.util.HashMap;

public class PortfolioManager implements PortfolioManagerInterface {
    public int idGenerator;
    private final HashMap<Integer, Teacher1> teachers = new HashMap<>();
    private final HashMap<Integer, Student1> students = new HashMap<>();
    private final HashMap<Integer, Event1> events = new HashMap<>();
    private final HashMap<Integer, Awards> awards = new HashMap<>();

    @Override
    public void addTeacher(Teacher1 newTeacher) {
        int teacherId = ++idGenerator;
        newTeacher.setId(teacherId);
        teachers.put(teacherId, newTeacher);
    }

    @Override
    public void addStudents(Student1 newStudent) {
        int studentId = ++idGenerator;
        newStudent.setId(studentId);
        students.put(studentId, newStudent);
        int teacherId = newStudent.getTeacherId();
        ArrayList<Student1> teachersStudent = teachers.get(teacherId).getStudentsList();
        teachersStudent.add(newStudent);
    }

    @Override
    public void addEvent(Event1 newEvent) {
        int eventId = ++idGenerator;
        newEvent.setEventId(eventId);
        events.put(eventId, newEvent);
        int teacherId = newEvent.getTeacherId();
        int studentId = newEvent.getStudentId();
        ArrayList<Integer> teacherEvents = teachers.get(teacherId).getEventId();
        ArrayList<Event1> teachersEventList = teachers.get(teacherId).getEvent1List();
        ArrayList<Integer> studentEvents = students.get(studentId).getEventId();
        teacherEvents.add(eventId);
        teachersEventList.add(newEvent);
        studentEvents.add(eventId);
        //добавить уровень мероприятия
    }

    @Override
    public void addAwardsForTeacher(Awards reward) {
        int rewardId = ++idGenerator;
        reward.setRewardId(rewardId);
        awards.put(rewardId, reward);
        int teacherId = reward.getTeacherId();
        ArrayList<Integer> teacherReward = teachers.get(teacherId).getAwardsId();
        ArrayList<Awards> teacherAwardsList = teachers.get(teacherId).getAwardsList();
        teacherReward.add(rewardId);
        teacherAwardsList.add(reward);
    }


    @Override
    public ArrayList<Teacher1> getTeachersList() {
        return new ArrayList<>(teachers.values());
    }

    @Override
    public ArrayList<Student1> getStudentsList() {
        return new ArrayList<>(students.values());
    }

    @Override
    public ArrayList<Event1> getEventsList() {
        return new ArrayList<>(events.values());
    }

    @Override
    public ArrayList<Awards> getAwardsList() {
        return new ArrayList<>(awards.values());
    }

    @Override
    public Teacher1 getTeacherById(int teacherId) {
        Teacher1 teacher = teachers.get(teacherId);
        if (teacher != null) {
            return teacher;
        }
        return null;
    }

    @Override
    public Student1 getStudentById(int studentId) {
        Student1 student = students.get(studentId);
        if (student != null) {
            return student;
        }
        return null;
    }

    @Override
    public Event1 getEventById(int eventId) {
        Event1 event = events.get(eventId);
        if (event != null) {
            return event;
        }
        return null;
    }

    @Override
    public Awards getRewardById(int rewordId) {
        Awards awards1 = awards.get(rewordId);
        if (awards1 != null) {
            return awards1;
        }
        return null;
    }

    @Override
    public void removeTeacherById(int teacherId) {
        ArrayList<Integer> eventsId = teachers.get(teacherId).getEventId();
        for (Integer eventId : eventsId) {
            eventsId.remove(eventId);
        }
        ArrayList<Integer> awardsId = teachers.get(teacherId).getAwardsId();
        for (Integer rewardId : awardsId) {
            awardsId.remove(rewardId);
        }
        teachers.remove(teacherId);
    }

    @Override
    public void removeStudentById(int studentId) {
        ArrayList<Integer> eventsId = students.get(studentId).getEventId();
        for (Integer eventId : eventsId) {
            eventsId.remove(eventId);
        }
        ArrayList<Integer> awardsId = students.get(studentId).getAwardsId();
        for (Integer rewardId : awardsId) {
            awardsId.remove(rewardId);
        }
        students.remove(studentId);
    }

    @Override
    public void removeEventById(int eventId) {
        int teacherId = events.get(eventId).getTeacherId();
        int studentId = events.get(eventId).getStudentId();
        ArrayList<Integer> teacherEventId = teachers.get(teacherId).getEventId();
        ArrayList<Integer> studentEventId = students.get(studentId).getEventId();
        teacherEventId.remove(eventId);
        studentEventId.remove(eventId);
    }

    @Override
    public void removeRewordById(int rewordId) {
        int teacherId = awards.get(rewordId).getTeacherId();
        int studentId = awards.get(rewordId).getStudentId();
        ArrayList<Integer> teacherAwardsId = teachers.get(teacherId).getAwardsId();
        ArrayList<Integer> studentAwardsId = students.get(studentId).getAwardsId();
        teacherAwardsId.remove(rewordId);
        studentAwardsId.remove(rewordId);
    }

    @Override
    public void removeAll() {
        teachers.clear();
        students.clear();
        events.clear();
        awards.clear();
    }

    @Override
    public void removeAllTeachers() {
        for (Teacher1 teacher : teachers.values()) {
            ArrayList<Integer> teachersEventId = teachers.get(teacher.getId()).getEventId();
            for (Integer eventId : teachersEventId) {
                events.remove(eventId);
            }
        }
        teachers.clear();
    }

    @Override
    public void removeAllStudents() {
        for (Student1 student : students.values()) {
            ArrayList<Integer> studentsEventId = students.get(student.getId()).getEventId();
            for (Integer eventId : studentsEventId) {
                events.remove(eventId);
            }
        }
        students.clear();
    }

    @Override
    public void removeAllEvents() {
        for (Teacher1 teacher : teachers.values()) {
            teacher.getEventId().clear();
        }
        for (Student1 student : students.values()) {
            student.getEventId().clear();
        }
        events.clear();
    }

    @Override
    public void removeAllAwards() {
        for (Teacher1 teacher : teachers.values()) {
            teacher.getAwardsId().clear();
        }
        for (Student1 student : students.values()) {
            student.getAwardsId().clear();
        }
        awards.clear();
    }

    @Override
    public ArrayList<Event1> getAllTeacherEventById(int teacherId) {
        ArrayList<Integer> teacherEventId = teachers.get(teacherId).getEventId();
        ArrayList<Event1> teachersEvent = new ArrayList<>();
        for (Integer eventId : teacherEventId) {
            teachersEvent.add(events.get(eventId));
        }
        return teachersEvent;
    }

    @Override
    public ArrayList<Event1> getAllStudentsEventById(int studentId) {
        ArrayList<Integer> studentEventsId = students.get(studentId).getEventId();
        ArrayList<Event1> studentsEvent = new ArrayList<>();
        for (Integer eventId : studentEventsId) {
            studentsEvent.add(events.get(eventId));
        }
        return studentsEvent;
    }

    @Override
    public ArrayList<Awards> getAllTeachersAwardsById(int teacherId) {
        ArrayList<Integer> teacherAwardsId = teachers.get(teacherId).getAwardsId();
        ArrayList<Awards> teacherAwards = new ArrayList<>();
        for (Integer awardsId : teacherAwardsId) {
            teacherAwards.add(awards.get(awardsId));
        }
        return teacherAwards;
    }

    @Override
    public ArrayList<Awards> getAllStudentsAwardsById(int studentId) {
        ArrayList<Integer> studentAwardsId = students.get(studentId).getAwardsId();
        ArrayList<Awards> studentAwards = new ArrayList<>();
        for (Integer awardsId : studentAwardsId) {
            studentAwards.add(awards.get(awardsId));
        }
        return studentAwards;
    }

    @Override
    public void updateTeachers(Teacher1 updateTeacher) {
        teachers.put(updateTeacher.getId(), updateTeacher);
    }

    @Override
    public void updateStudent(Student1 updateStudent) {
        students.put(updateStudent.getId(), updateStudent);
    }

    @Override
    public void updateEvent(Event1 updateEvent) {
        events.put(updateEvent.getEventId(), updateEvent);
    }

    @Override
    public void updateReword(Awards updateAwards) {
        awards.put(updateAwards.getRewardId(), updateAwards);
    }
}
