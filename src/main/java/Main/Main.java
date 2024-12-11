package Main;

import Admin.Admin;
import Login.Login;
import Organizer.Organizer;
import Student.Student;
import Teacher.Teacher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        int a = 0;
        String loginRequest = "Please enter your type of account: ";
        System.out.print(loginRequest);
        String typeOfAccount = scanner.next();
        while(a < 5) {
            if(typeOfAccount.equals(login.adminLogin)){
                Admin admin = new Admin();
                String passwordRequest = "Please enter your password: ";
                System.out.print(passwordRequest);
                String password1 = scanner.next();
                if(password1.equals(login.adminPassword)){
                    System.out.println(Admin.greetings);
                    admin.menu();
                    String choice = admin.getChoice();
                    System.out.println(choice);
                }
                else {
                    System.out.println("Sorry, but password entered incorrectly, please try again!");
                }
            }
            else if(typeOfAccount.equals(login.organizerLogin)){
                Organizer organizer = new Organizer();
                String passwordRequest = "Please enter your password: ";
                System.out.print(passwordRequest);
                String password2 = scanner.next();
                if(password2.equals(login.organizerPassword)){
                    System.out.println(Organizer.greetings);
                    organizer.menu();
                    String choice = organizer.getChoice();
                    System.out.println(choice);
                }
                else {
                    System.out.println("Sorry, but password entered incorrectly, please try again!");
                }
            }
            else if(typeOfAccount.equals(login.studentLogin)){
                Student student = new Student();
                String passwordRequest = "Please enter your password: ";
                System.out.print(passwordRequest);
                String password3 = scanner.next();
                if(password3.equals(login.studentPassword)){
                    System.out.println(Student.greetings);
                    Student.menu();
                    String choice = Student.getChoice();
                    System.out.println(choice);
                }
                else {
                    System.out.println("Sorry, but password entered incorrectly, please try again!");
                }
            }
            else if(typeOfAccount.equals(login.teacherLogin)){
                Teacher teacher = new Teacher();
                String passwordRequest = "Please enter your password: ";
                System.out.print(passwordRequest);
                String password4 = scanner.next();
                if(password4.equals(login.teacherPassword)){
                    System.out.println(Teacher.greetings);
                    Teacher.menu();
                    String choice = Teacher.getChoice();
                    System.out.println(choice);
                }
                else {
                    System.out.println("Sorry, but password entered incorrectly, please try again!");
                }

            }
            a++;
        }
    }
}