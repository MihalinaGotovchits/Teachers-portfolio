import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileBackedPortfolioManager extends PortfolioManager {
    File file;
    TypeOfFile typeOfFile;
    String stringFormat = null;
    private static final String FIRST_LINE_ONLY_PERSONAL_TEACHERS_DATA = "id, FirstName, Name, SurName, DateOfBirth";
    private static final String AWARDS_INFORMATION_ABOUT_TEACHER = "id, FirstName, Name, SurName, DateOfBirth, Awards";

    private static final String TEACHERS_INFORMATION_ABOUT_EVENTS = "id, FirstName, Name, SurName, DateOfBirth, Events";
    private static final String ALL_INFORMATION_ABOUT_TEACHER = "id, FirstName, Name, SurName, DateOfBirth, Awards," +
            "Events, Students";

    public FileBackedPortfolioManager(Path path) {
        this.file = new File(String.valueOf(path));
    }

    void save(TypeOfFile typeOfFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            switch (typeOfFile) {
                case PERSONAL_TEACHERS_DATA:
                    writer.write(FIRST_LINE_ONLY_PERSONAL_TEACHERS_DATA);
                    writer.newLine();
                    for (Teacher1 teacher1 : getTeachersList()) {
                        writer.write(toStringPersonalTeachersData(teacher1));
                        writer.newLine();
                    }
                case TEACHERS_INFORMATION_ABOUT_AWARDS:
                    writer.write(AWARDS_INFORMATION_ABOUT_TEACHER);
                    writer.newLine();
                    for (Teacher1 teacher1 : getTeachersList()) {
                        writer.write(toStringAwardsInformationAboutTeachers(teacher1));
                        writer.newLine();
                    }
                case TEACHERS_INFORMATION_ABOUT_EVENTS:
                    writer.write(TEACHERS_INFORMATION_ABOUT_EVENTS);
                    writer.newLine();
                    for (Teacher1 teacher1 : getTeachersList()) {
                        writer.write(toStringTeacherInformationAboutEvents(teacher1));
                        writer.newLine();
                    }
                case ALL_INFORMATION_ABOUT_TEACHER:
                    writer.write(ALL_INFORMATION_ABOUT_TEACHER);
                    writer.newLine();
                    addTeacherToFile(writer);
                    writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addTeacherToFile(BufferedWriter writer) throws IOException {
        for (Teacher1 teacher1 : getTeachersList()) {
            writer.write(toStringAllInformationAboutTeacher(teacher1));

            for (Awards awards : teacher1.getAwardsList()) {
                writer.write(toString(awards));
            }

            for (Event1 event1 : teacher1.getEvent1List()) {
                writer.write(toString(event1));
            }
            writer.newLine();
        }
    }


    private void addEventsToFile(BufferedWriter writer) throws IOException {
        for (Event1 event1 : getEventsList()) {
            writer.write(toString(event1));
            writer.newLine();
        }
    }

    private String toStringPersonalTeachersData(Teacher1 teacher1) {
        return teacher1.getId() + ", " + ", " + teacher1.getSecondName() + teacher1.getFirstName() + ", " +
                teacher1.getSurName();
    }

    private String toStringAwardsInformationAboutTeachers(Teacher1 teacher1) {
        return teacher1.getId() + ", " + teacher1.getSecondName() + ", " + teacher1.getFirstName() + ", " +
                teacher1.getSurName() + ", " + teacher1.getAwardsId();
    }

    //подумать над аргументами метода
    private String toStringTeacherInformationAboutEvents(Teacher1 teacher1){
        return teacher1.getId() + ", " + teacher1.getSecondName() + ", " + teacher1.getFirstName() + ", " +
            teacher1.getSurName() + ", " + teacher1.getEvent1List();
    }

    private String toStringAllInformationAboutTeacher(Teacher1 teacher1) {
        return teacher1.getId() + ", " + teacher1.getSecondName() + ", " + teacher1.getFirstName() + ", " +
                teacher1.getSurName() + ", ";
    }

    private String toString(Awards awards) {
        return awards.getAwardsTitle() + " " + awards.getDescription() + " " + awards.getAwardsLevel() + ", ";
    }

    private String toString(Event1 event1) {
        return event1.getEventTitle() + " " + event1.getEventLevel();
    }

    @Override
    public void addTeacher(Teacher1 newTeacher) {
        super.addTeacher(newTeacher);
        save(TypeOfFile.PERSONAL_TEACHERS_DATA);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_AWARDS);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_EVENTS);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void addStudents(Student1 newStudent) {
        super.addStudents(newStudent);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void addEvent(Event1 newEvent) {
        super.addEvent(newEvent);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void addAwardsForTeacher(Awards reward) {
        super.addAwardsForTeacher(reward);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public Teacher1 getTeacherById(int teacherId) {
        Teacher1 teacher1 = super.getTeacherById(teacherId);
        save(TypeOfFile.PERSONAL_TEACHERS_DATA);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_AWARDS);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_EVENTS);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
        return teacher1;
    }

    @Override
    public Student1 getStudentById(int studentId) {
        Student1 student1 = super.getStudentById(studentId);
        return student1;
    }

    @Override
    public Event1 getEventById(int eventId) {
        return super.getEventById(eventId);
    }

    @Override
    public Awards getRewardById(int rewordId) {
        Awards awards = super.getRewardById(rewordId);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
        return awards;
    }

    @Override
    public void removeTeacherById(int teacherId) {
        super.removeTeacherById(teacherId);
        save(TypeOfFile.PERSONAL_TEACHERS_DATA);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_AWARDS);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_EVENTS);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void removeStudentById(int studentId) {
        super.removeStudentById(studentId);
    }

    @Override
    public void removeEventById(int eventId) {
        super.removeEventById(eventId);
    }

    @Override
    public void removeRewordById(int rewordId) {
        super.removeRewordById(rewordId);
    }

    @Override
    public void removeAll() {
        super.removeAll();
        save(TypeOfFile.PERSONAL_TEACHERS_DATA);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_AWARDS);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_EVENTS);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void removeAllTeachers() {
        super.removeAllTeachers();
        save(TypeOfFile.PERSONAL_TEACHERS_DATA);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_AWARDS);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_EVENTS);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void removeAllStudents() {
        super.removeAllStudents();
    }

    @Override
    public void removeAllEvents() {
        super.removeAllEvents();
    }

    @Override
    public void removeAllAwards() {
        super.removeAllAwards();
    }

    @Override
    public void updateTeachers(Teacher1 updateTeacher) {
        super.updateTeachers(updateTeacher);
        save(TypeOfFile.PERSONAL_TEACHERS_DATA);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_AWARDS);
        save(TypeOfFile.TEACHERS_INFORMATION_ABOUT_EVENTS);
        save(TypeOfFile.ALL_INFORMATION_ABOUT_TEACHER);
    }

    @Override
    public void updateStudent(Student1 updateStudent) {
        super.updateStudent(updateStudent);
    }

    @Override
    public void updateEvent(Event1 updateEvent) {
        super.updateEvent(updateEvent);
    }

    @Override
    public void updateReword(Awards updateAwards) {
        super.updateReword(updateAwards);
    }

    public TypeOfFile getTypeOfFile() {
        return typeOfFile;
    }
}
