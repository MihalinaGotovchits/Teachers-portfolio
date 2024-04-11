import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    BufferedReader reader;
    private String firstName;
    private String lastName;
    private String surName;
    private ArrayList<String> studentList = new ArrayList<>();

    public Student(BufferedReader bufferedReader){
        reader = bufferedReader;
    }

    public void setFirstName() throws IOException {
        System.out.println("Введите имя учащегося");
        firstName = reader.readLine();
        if (firstName.isEmpty()){
            System.out.println("Пожалуйста, введите имя учащегося");
        }
    }

    public void setLastName() throws IOException{
        System.out.println("Введите фамилию учащегося");
        lastName = reader.readLine();
        if (lastName.isEmpty()){
            System.out.println("Пожалуйста, введите фамилию учащегося");
        }
    }

    public void setSurName() throws IOException{
        System.out.println("Введите отчество учащегося");
        surName = reader.readLine();
        if (surName.isEmpty()){
            System.out.println("Пожалуйста, введите отчество учащегося");
        }
    }

    public void addStudentsAtList(){
        studentList.add(lastName + " " + firstName + " " + surName);
    }

    public ArrayList<String> studentList(){
        return studentList;
    }

    public void printStudentList(){
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }
}
