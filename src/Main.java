import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileBackedPortfolioManager fileBackedPortfolioManager = new FileBackedPortfolioManager(Path.of(
                "./resurse/AllInformationAboutTeacher.csv"));


        // PortfolioManager portfolioManager = new PortfolioManager();

        Teacher1 teacher = new Teacher1("Ломовцева", "Михалина", "Валентиновна");
        Student1 student = new Student1("Семенова", "Анна", 1);
        Event1 event = new Event1("Конкурс", "КДШИ", EventLevel.MUNICIPAL, 1, 2);
        Awards awards = new Awards("Благодарственное письмо", "За работу", AwardsLevel.MUNICIPAL,
                1, "Ломовцева Михалина Валентиновна");

        Teacher1 teacher1 = new Teacher1("Готовчиц", "Оксана", "Викторовна");
        Event1 event1 = new Event1("Фестиваль", "Брест", EventLevel.REGION, 5, 2);
        Awards awards1 = new Awards("Грамота", "За работу", AwardsLevel.MUNICIPAL, 5,
                "Готовчиц Оксана Викторовна");

        fileBackedPortfolioManager.addTeacher(teacher);
        fileBackedPortfolioManager.addStudents(student);
        fileBackedPortfolioManager.addEvent(event);
        fileBackedPortfolioManager.addAwardsForTeacher(awards);

        fileBackedPortfolioManager.addTeacher(teacher1);
        fileBackedPortfolioManager.addEvent(event1);
        fileBackedPortfolioManager.addAwardsForTeacher(awards1);
        System.out.println(teacher1.getEventId());
        System.out.println(teacher1.getAwardsList());

       /* portfolioManager.addTeacher(teacher);
        //portfolioManager.addStudents(student);
        //portfolioManager.addEvent(event);
        portfolioManager.addAwardsForTeacher(awards);

        /*System.out.println(portfolioManager.getTeachersList());
        System.out.println(portfolioManager.getStudentsList());
        System.out.println(portfolioManager.getEventsList());

        System.out.println(portfolioManager.getTeacherById(1));
        System.out.println(portfolioManager.getStudentById(2));
        System.out.println(portfolioManager.getEventById(3));*/
        //System.out.println(portfolioManager.getAwardsList());
        //System.out.println(awards.getAwardsTitle());
        //System.out.println(portfolioManager.getRewardById(4));
    }
    /*public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Teacher teacher = new Teacher(reader);
        Student student = new Student(reader);
        Event event = new Event(reader);
        TimeOfWork timeOfWork = new TimeOfWork(reader);

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                teacher.setLastName();
                teacher.setFirstName();
                teacher.setSurName();
            } else if (command == 2) {
                teacher.setJobTitle();
            } else if (command == 3) {

            } else if (command == 4) {
                event.setEventName();
            } else if (command == 5) {
                event.setEventLocation();
            } else if (command == 6) {
                event.setEventLevel();
                event.printInformationOfEvent();
            } else if (command == 7) {
                
            } else if (command == 8) {
                student.setLastName();
                student.setFirstName();
                student.setSurName();
                student.addStudentsAtList();
                student.printStudentList();
            } else if (command == 9) {

            } else if (command == 10) {
                System.out.println("Количество мероприятий: " + event.countOfEvents());
            } else if (command == 11) {
                
            } else if (command == 12) {
                timeOfWork.timeOfWork();
            } else if (command == 13) {
                System.out.println("Выход");
                break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести ФИО");
        System.out.println("2 - Ввести должность");
        System.out.println("3 - Ввести дату мероприятия");
        System.out.println("4 - Ввести название мероприятия");
        System.out.println("5 - Ввести место проведения мероприятия");
        System.out.println("6 - Ввести уровень мероприятия");
        System.out.println("7 - Ввести количество участников мероприятия");
        System.out.println("8 - Ввести ФИО участников");
        System.out.println("9 - Ввести ФИО лауреатов");
        System.out.println("10 - Получить информацию по количеству мероприятий");
        System.out.println("11 - Получить информацию по количеству лауреатов");
        System.out.println("12 - Ввести стаж");
        System.out.println("13 - Выйти из программы");
    }*/
}