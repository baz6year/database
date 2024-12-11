package Student;

import Admin.Schedule;
import Organizer.Registration;

import java.util.List;
import java.util.Scanner;

public class Student {
        static Scanner scanner = new Scanner(System.in);
        public static String greetings = "Greetings dear Student!\n" +
                "Select the option, if you are finished, then select 8:";
        public static void menu() {
            System.out.println("1. Show a list of all events;\n" +
                    "2. Show a list of members; \n" +
                    "3. Add member; \n" +
                    "4. Update member; \n" +
                    "5. Delete member; \n" +
                    "6. Show event's rating; \n" +
                    "7. Leave rating; \n" +
                    "8. Exit;");
        }
        public static String getChoice() {
            StudentCRUDUtils organizerCRUDUtils = new StudentCRUDUtils();
            String choice = "null";
            String numberRequest = "Please dial the menu number to work with the program:";
            System.out.print(numberRequest);
            String getchoice = scanner.next();

            if (getchoice.equals("1")) {
                List<Schedule> schedules = StudentCRUDUtils.getScheduleData("SELECT * FROM schedule");
                choice = schedules.toString();
            } else if (getchoice.equals("2")) {
                List<Registration> registrations = StudentCRUDUtils.getRegistrationData("SELECT * FROM registration");
                choice = registrations.toString();
            } else if (getchoice.equals("3")) {
                List<Registration> registrations = StudentCRUDUtils.createRegistration("Presentation", "Masha Dasha");
                choice = registrations.toString();
            } else if (getchoice.equals("4")) {
                List<Registration> registrations = StudentCRUDUtils.updateRegistration("Pasha Popov", "Concert");
                choice = registrations.toString();
            } else if (getchoice.equals("5")) {
                List<Registration> registrations = StudentCRUDUtils.deleteRegistration(2);
                choice = registrations.toString();
            } else if (getchoice.equals("6")) {
                List<Rating> ratings = StudentCRUDUtils.getRatingData("SELECT * FROM rating");
                choice = ratings.toString();
            } else if (getchoice.equals("7")) {
                List<Rating> ratings = StudentCRUDUtils.createRating("Conference", "70");
                choice = ratings.toString();
            } else if (getchoice.equals("8")) {
                choice = "The program is over, we look forward to your return!";
            }

            return choice;

        }
    }




