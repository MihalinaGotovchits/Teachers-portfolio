import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Event {
    BufferedReader reader;
    TimeOfWork timeOfWork = new TimeOfWork(reader);
    Student student = new Student(reader);
    HashMap<String, ArrayList<String>> events = new HashMap<>();
    private String eventName;
    private String eventLevel;
    private String eventLocation;
    private int participants;
    ArrayList<String> eventList = new ArrayList<>();
    Year[] yearToData = new Year[timeOfWork.workExperience];//массив со стажем работы

    public Event(BufferedReader read) {
        reader = read;

        for (int i = 0; i < yearToData.length; i++) {
            yearToData[i] = new Year();
        }
    }

    public void dateOfEvent() throws IOException {//ввод количества мероприятий в определенную дату
        System.out.println("Введите год");
        int year = Integer.parseInt(reader.readLine());

        System.out.println("Введите месяц");
        int month = Integer.parseInt(reader.readLine());

        System.out.println("Введите день");
        int day = Integer.parseInt(reader.readLine());

        System.out.println("Введите количество мероприятий");
        int countOfEvent = Integer.parseInt(reader.readLine());

        Year yearData = yearToData[year - 1];
        Month monthData = yearData.monthsNumber[month - 1];
        monthData.month[day - 1] = countOfEvent;
    }

    public void setEventName() throws IOException {
        System.out.println("Введите название мероприятия");
        eventName = reader.readLine();
    }

    public void setEventLocation() throws IOException {
        System.out.println("Введите место проведения мероприятия");
        eventLocation = reader.readLine();
    }

    public void setEventLevel() throws IOException {
        System.out.println("Введите уровень мероприятия");
        eventLevel = reader.readLine();
    }

    public void addEvents(){
        events.put(eventName, student.studentList());
    }

    public void numberOfParticipants() throws IOException {// ввод количества участников мероприятия
        System.out.println("Введите количество участников мероприятия");
        participants = Integer.parseInt(reader.readLine());
        if (participants < 0) {
            System.out.println("введите положительное число");
        }
    }

    public void printInformationOfEvent() {
        System.out.println(eventName + " уровень " + eventLevel + " " + eventLocation + "количество участников " + participants);
    }

    public int countOfEvents() {//если есть мероприятие счетчик: +1
        int count = 0;
        for (String s : eventList) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }

    public void printInformationNumberOfEvent() throws IOException {
        int year;
        int month;
        int day;

        printInformationOfEvent();
        int command = Integer.parseInt(reader.readLine());

        if (command == 1) {
            System.out.println("Введите год");
            year = Integer.parseInt(reader.readLine());
            if (year < 1970 || year > 2024) {
                System.out.println("Введено некорректное значение года. Повторите попытку.");
                System.out.println();
                return;
            }
            System.out.println("Введите месяц");
            month = Integer.parseInt(reader.readLine());
            if (month < 1 || month > 12) {
                System.out.println("Введено некорректное значение месяца. Пожалуйста, повторите попытку");
                System.out.println();
                return;
            }
            System.out.println("Введите день");
            day = Integer.parseInt(reader.readLine());
            if (day < 1 || day > 31) {
                System.out.println("Введено некорректное значение дня. Пожалуйста, повторите попытку");
                System.out.println();
                return;
            }

            //отсортировать массив на поиск нужного дня
        }
        if (command == 2) {
            System.out.println("Введите год");
            year = Integer.parseInt(reader.readLine());
            if (year < 1970 || year > 2024) {
                System.out.println("Введено некорректное значение года. Повторите попытку.");
                System.out.println();
                return;
            }
            System.out.println("Введите месяц");
            month = Integer.parseInt(reader.readLine());
            if (month < 1 || month > 12) {
                System.out.println("Введено некорректное значение месяца. Пожалуйста, повторите попытку");
                System.out.println();
                return;
            }
            //отсортировать массив на поиск нужного месяца
        }
        if (command == 3) {
            System.out.println("Введите год");
            year = Integer.parseInt(reader.readLine());
            if (year < 1970 || year > 2024) {
                System.out.println("Введено некорректное значение года. Повторите попытку.");
                System.out.println();
                return;
            }
        }
        //отсортировать массив на поиск нужного года
    }

    void printMenuInformationEvent() {
        System.out.println("За какой период вы хотите получить информацию?");
        System.out.println("1 - За день");
        System.out.println("2 - За месяц");
        System.out.println("3 - За год");
        System.out.println("4 - За пять лет");
    }
}
