package Teacher;

import Admin.Schedule;

import java.util.List;
import java.util.Scanner;

public class Teacher {
    static Scanner scanner = new Scanner(System.in);
    public static String greetings = "Greetings dear Teacher!\n" +
            "Select the option, if you are finished, then select  2:";
    public static void menu() {
        System.out.println("1. Show a list of all events;\n" +
                "2. Exit;");
    }
    public static String getChoice() {
        TeacherCRUDUtils organizerCRUDUtils = new TeacherCRUDUtils();
        String choice = "null";
        String numberRequest = "Please dial the menu number to work with the program:";
        System.out.print(numberRequest);
        String getchoice = scanner.next();

        if (getchoice.equals("1")) {
            List<Schedule> schedules = TeacherCRUDUtils.getScheduleData("SELECT * FROM schedule");
            choice = schedules.toString();
        }  else if (getchoice.equals("6")) {
            choice = "The program is over, we look forward to your return!";
        }

        return choice;

    }
}





