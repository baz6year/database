package Admin;

import java.util.List;
import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    public static String greetings = "Greetings dear Admin!\n" +
            "Select the option, if you are finished, then select 7:";
    public void menu () {
        System.out.println("1. Show a list of all events;\n" +
                "2. Create an event; \n" +
                "3. Delete event; \n" +
                "4. Show a list of users; \n" +
                "5. Add user; \n" +
                "6. Delete user; \n" +
                "7. Exit;");
    }
    public String getChoice () {
        AdminCRUDUtils adminCRUDUtils = new AdminCRUDUtils();
        String choice = "null";
        String numberRequest = "Please dial the menu number to work with the program:";
        System.out.print(numberRequest);
        String getchoice = scanner.next();

        if (getchoice.equals("1")) {
            List<Schedule> schedules = AdminCRUDUtils.getScheduleData("SELECT * FROM schedule");
            choice = schedules.toString();
        } else if (getchoice.equals("2")) {
            List<Schedule> schedules = AdminCRUDUtils.createSchedule("Match", "12 June", "18:00", "Stadion");
            choice = schedules.toString();
        } else if (getchoice.equals("4")) {
            List<Schedule> schedules = AdminCRUDUtils.deleteSchedule(1);
            choice = schedules.toString();
        } else if (getchoice.equals("5")) {
            List<Profile> profiles = AdminCRUDUtils.getProfileData("SELECT * FROM profile");
            choice = profiles.toString();
        } else if (getchoice.equals("6")) {
            List<Profile> profiles = AdminCRUDUtils.createProfile("Damon Salvatore", "Student");
            choice = profiles.toString();
        } else if (getchoice.equals("7")) {
            List<Profile> profiles = AdminCRUDUtils.deleteProfile(1);
            choice = profiles.toString();
        } else if (getchoice.equals("8")) {
            choice = "The program is over, we look forward to your return!";
        }

        return choice;

    }
}
