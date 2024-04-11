import java.io.BufferedReader;
import java.io.IOException;

public class Teacher {
    BufferedReader reader;
    private String firstName;
    private String lastName;
    private String surName;
    private String jobTitle;

    public Teacher(BufferedReader bufferedReader){
        reader = bufferedReader;
    }

    public void setFirstName() throws IOException{
        System.out.println("Введите свое имя");
        firstName = reader.readLine();
    }

    public void setLastName() throws IOException{
        System.out.println("Введите свою фамилию");
        lastName = reader.readLine();
    }

    public void setSurName() throws IOException{
        System.out.println("Введите свое отчество");
        surName = reader.readLine();
    }

    public void setJobTitle() throws IOException{
        System.out.println("Введите свою должность");
        jobTitle = reader.readLine();
    }

    void printFullNameAndTitle(){
        System.out.println(lastName + " " + firstName + " " + surName);
        System.out.println(jobTitle);
    }
}
