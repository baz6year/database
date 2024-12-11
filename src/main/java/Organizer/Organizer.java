package Organizer;

import Admin.Schedule;

import java.util.List;
import java.util.Scanner;

public class Organizer {
        Scanner scanner = new Scanner(System.in);
        public static String greetings = "Greetings dear Organizer!\n" +
                "Select the option, if you are finished, then select 10:";
        public void menu () {
            System.out.println("1. Show a list of all events;\n" +
                    "2. Create an event; \n" +
                    "3. Delete event; \n" +
                    "4. Update event; \n" +
                    "5. Show a list of users; \n" +
                    "6. Add member; \n" +
                    "7. Delete member; \n" +
                    "8. Show event's progression; \n" +
                    "9. Update event's progression; \n" +
                    "10. Exit;");
        }
        public String getChoice () {
            OrganizerCRUDUtils organizerCRUDUtils = new OrganizerCRUDUtils();
            String choice = "null";
            String numberRequest = "Please dial the menu number to work with the program:";
            System.out.print(numberRequest);
            String getchoice = scanner.next();

            if (getchoice.equals("1")) {
                List<Schedule> schedules = OrganizerCRUDUtils.getScheduleData("SELECT * FROM schedule");
                choice = schedules.toString();
            } else if (getchoice.equals("2")) {
                List<Schedule> schedules = OrganizerCRUDUtils.createSchedule("Match", "12 June", "18:00", "Stadion");
                choice = schedules.toString();
            } else if (getchoice.equals("3")) {
                List<Schedule> schedules = OrganizerCRUDUtils.deleteSchedule(1);
                choice = schedules.toString();
            } else if (getchoice.equals("4")) {
                List<Schedule> schedules = OrganizerCRUDUtils.updateSchedule("13 May", "12:00", "Conference");
                choice = schedules.toString();
            } else if (getchoice.equals("5")) {
                List<Registration> registrations = OrganizerCRUDUtils.getRegistrationData("SELECT * FROM registration");
                choice = registrations.toString();
            } else if (getchoice.equals("6")) {
                List<Registration> registrations = OrganizerCRUDUtils.createRegistration("Presentation", "Masha Dasha");
                choice = registrations.toString();
            } else if (getchoice.equals("7")) {
                List<Registration> registrations = OrganizerCRUDUtils.deleteRegistration(2);
                choice = registrations.toString();
            } else if (getchoice.equals("8")) {
                List<Progress> progresses = OrganizerCRUDUtils.getProgressData("SELECT * FROM progress");
                choice = progresses.toString();
            } else if (getchoice.equals("9")) {
                List<Progress> progresses = OrganizerCRUDUtils.updateProgress("Done", "Meeting");
                choice = progresses.toString();
            } else if (getchoice.equals("10")) {
                choice = "The program is over, we look forward to your return!";
            }

            return choice;

        }
    }


