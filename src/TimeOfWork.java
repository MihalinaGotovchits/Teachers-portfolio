import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class TimeOfWork {
    BufferedReader reader;
    int yearStartOfWork;
    int currentYearOfWork;
    int workExperience;

    TimeOfWork(BufferedReader read){
        reader = read;
    }


    void timeOfWork() throws IOException {//метод, заполняющий период работы с - по
        System.out.println("Введите год начала работы");
        yearStartOfWork = Integer.parseInt(reader.readLine());
        System.out.println("Введите текущий год");
        currentYearOfWork = Integer.parseInt(reader.readLine());
        workExperience = currentYearOfWork - yearStartOfWork; //стаж работы
        int[] timeOfWork = new int[workExperience +1];// создание массива с колличеством ячеек, равному стажу
        int count = 0;

        for (int i = yearStartOfWork; i <= currentYearOfWork; i++) {
            timeOfWork[count] = i;
            count++;
        }
        for (int i = 0; i < timeOfWork.length; i++) {
            System.out.println(timeOfWork[i]);
        }
    }
}
