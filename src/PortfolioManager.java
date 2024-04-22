import java.util.ArrayList;
import java.util.HashMap;

public class PortfolioManager {
    public int idGenerator;
    private HashMap<Integer, Teacher1> teachers = new HashMap<>();
    private HashMap<Integer, Student1> students = new HashMap<>();
    private HashMap<Integer, Event1> events = new HashMap<>();

    public void addTeacher(Teacher1 newTeacher) {
        int teacherId = ++idGenerator;
        newTeacher.setId(teacherId);
        teachers.put(teacherId, newTeacher);
    }

    public void addStudents(Student1 newStudent) {
        int studentId = ++idGenerator;
        newStudent.setId(studentId);
        students.put(studentId, newStudent);
    }

    public void addEvent(Event1 newEvent) {
        int eventId = ++idGenerator;
        newEvent.setEventId(eventId);
        events.put(eventId, newEvent);
        int teacherId = newEvent.getTeacherId();
        int studentId = newEvent.getStudentId();
        ArrayList<Integer> teacherEvents = teachers.get(teacherId).getEventId();
        ArrayList<Integer> studentEvents = students.get(studentId).getEventId();
        teacherEvents.add(eventId);
        studentEvents.add(eventId);
        //добавить уровень мероприятия
    }

    public ArrayList<Teacher1> getTeachersList() {
        if (teachers.isEmpty()) {
            return null;
        } else {
            return new ArrayList<>(teachers.values());
        }
    }

    public ArrayList<Student1> getStudentsList(){
        if (students.isEmpty()){
            return null;
        } else {
            return new ArrayList<>(students.values());
        }
    }

    public ArrayList<Event1> getEventsList(){
        if (events.isEmpty()){
            return null;
        } else {
            return new ArrayList<>(events.values());
        }
    }

    public Teacher1 getTeacherById(int teacherId){
        Teacher1 teacher = teachers.get(teacherId);
        if (teacherId == 0 || teachers.isEmpty()){
            return null;
        } else {
            if (teachers.containsKey(teacherId)) {
                teacher = teachers.get(teacherId);
            }
        }
        return teacher;
    }

    public Student1 getStudentById(int studentId){
        Student1 student = students.get(studentId);
        if (studentId == 0 || students.isEmpty()){
            return null;
        } else {
            if (students.containsKey(studentId)){
                student = students.get(studentId);
            }
        }
        return student;
    }

    public Event1 getEventById(int eventId){
        Event1 event = events.get(eventId);
        if (eventId == 0 || events.isEmpty()){
            return null;
        }else {
            if (events.containsKey(eventId)){
                event = events.get(eventId);
            }
        }
        return event;
    }

    public void removeTeacherById(int teacherId) {
        if (teacherId != 0) {
            if (teachers.containsKey(teacherId)) {
                ArrayList<Integer> eventsId = teachers.get(teacherId).getEventId();
                for (Integer eventId : eventsId) {
                    eventsId.remove(eventId);
                }
                teachers.remove(teacherId);
            }
        }
    }

    public void removeStudentById(int studentId){
        if (studentId != 0){
            if (students.containsKey(studentId)){
                ArrayList<Integer> eventsId = students.get(studentId).getEventId();
                for (Integer eventId : eventsId) {
                    eventsId.remove(eventId);
                }
                students.remove(studentId);
            }
        }
    }

    public void removeEventById(int eventId){
        if (eventId != 0){
            if (events.containsKey(eventId)){
                int teacherId = events.get(eventId).getTeacherId();
                int studentId = events.get(eventId).getStudentId();
                ArrayList<Integer> teacherEventId = teachers.get(teacherId).getEventId();
                ArrayList<Integer> studentEventId = students.get(studentId).getEventId();
                teacherEventId.remove(eventId);
                studentEventId.remove(eventId);
            }
        }
    }

    public void removeAll(){
     teachers.clear();
     students.clear();
     events.clear();
    }

    public void removeAllTeachers(){
        for (Teacher1 teacher : teachers.values()) {
            ArrayList<Integer> teachersEventId = teachers.get(teacher.getId()).getEventId();
            for(Integer eventId : teachersEventId){
                events.remove(eventId);
            }
        }
        teachers.clear();
    }

    public void removeAllStudents(){
        for (Student1 student : students.values()) {
            ArrayList<Integer> studentsEventId = students.get(student.getId()).getEventId();
            for (Integer eventId : studentsEventId) {
                events.remove(eventId);
            }
        }
        students.clear();
    }

    public void removeAllEvents(){
        for (Teacher1 teacher : teachers.values()) {
            teacher.getEventId().clear();
        }
        for (Student1 student : students.values()) {
            student.getEventId().clear();
        }
        events.clear();
    }

    public ArrayList<Event1> getAllTeacherEventById(int teacherId){
        ArrayList<Integer> teacherEventId = teachers.get(teacherId).getEventId();
        ArrayList<Event1> teachersEvent = new ArrayList<>();
        for (Integer eventId : teacherEventId) {
            teachersEvent.add(events.get(eventId));
        }
        return teachersEvent;
    }

    public ArrayList<Event1> getAllStudentsEventById(int studentId){
        ArrayList<Integer> studentEventsId = students.get(studentId).getEventId();
        ArrayList<Event1> studentsEvent = new ArrayList<>();
        for (Integer eventId : studentEventsId) {
            studentsEvent.add(events.get(eventId));
        }
        return studentsEvent;
    }

    public void updateTeachers(Teacher1 updateTeacher){
        teachers.put(updateTeacher.getId(), updateTeacher);
    }

    public void updateStudent(Student1 updateStudent){
        students.put(updateStudent.getId(), updateStudent);
    }

    public void updateEvent(Event1 updateEvent){
        events.put(updateEvent.getEventId(), updateEvent);
    }
}
