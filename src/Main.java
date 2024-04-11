import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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
    }
}