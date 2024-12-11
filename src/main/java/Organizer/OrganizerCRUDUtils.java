package Organizer;

import Admin.DBUtils;
import Admin.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizerCRUDUtils {
        private static String INSERT_EVENTS= "INSERT INTO schedule(event_name, event_date, event_time, location) VALUES (?, ?, ?, ?);";
        private static String DELETE_EVENTS= "DELETE FROM schedule WHERE id=?;";
        private static String UPDATE_EVENTS = "UPDATE schedule SET event_date=?, even_time=? WHERE event=?;";
        private static String INSERT_MEMBER= "INSERT INTO registration(event, name) VALUES (?, ?);";
        private static String DELETE_MEMBER= "DELETE FROM registration WHERE id=?;";
        private static String UPDATE_STATUS = "UPDATE progress SET status=? WHERE event_name=?;";
        public static List<Schedule> getScheduleData(String query) {
            List<Schedule> schedules = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()) {
                    int id =  rs.getInt("id");
                    String  event_name = rs.getString(" event_name");
                    String event_date = rs.getString("event_date");
                    String event_time = rs.getString("event_time");
                    String location = rs.getString("location");

                    schedules.add(new Schedule(id, event_name, event_date, event_time, location));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return schedules;
        }

    public static List<Schedule> createSchedule(String eventName, String eventDate, String eventTime, String eventLocation) {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENTS)) {
            preparedStatement.setString(1, eventName);
            preparedStatement.setString(2, eventDate);
            preparedStatement.setString(3, eventTime);
            preparedStatement.setString(4, eventLocation);
            preparedStatement.executeUpdate();

            PreparedStatement allSchedule = connection.prepareStatement("SELECT * FROM schedule");
            ResultSet rs = allSchedule.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String  event_name = rs.getString("event_name");
                String event_date = rs.getString("event_date");
                String event_time = rs.getString("event_time");
                String location = rs.getString("location");

                schedules.add(new Schedule(id, event_name, event_date, event_time, location));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return schedules;
    }
    public static List<Schedule> updateSchedule(String eventDate, String eventTime, String eventName) {
        List<Schedule> updateSchedule = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EVENTS)) {
            preparedStatement.setString(1, eventDate);
            preparedStatement.setString(2, eventTime);
            preparedStatement.setString(3, eventName);
            preparedStatement.executeUpdate();

            PreparedStatement allSchedule = connection.prepareStatement("SELECT * FROM schedule");
            ResultSet rs = allSchedule.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String  event_name = rs.getString("event_name");
                String event_date = rs.getString("event_date");
                String event_time = rs.getString("event_time");
                String location = rs.getString("location");

                updateSchedule.add(new Schedule(id, event_name, event_date, event_time, location));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateSchedule;
    }

        public static List<Schedule>deleteSchedule(int eventId) {
            List<Schedule> updateSchedules = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EVENTS)) {
                preparedStatement.setInt(1, eventId);
                preparedStatement.executeUpdate();

                PreparedStatement allSchedule = connection.prepareStatement("SELECT * FROM schedule");
                ResultSet rs = allSchedule.executeQuery();

                while(rs.next()) {
                    int id =  rs.getInt("id");
                    String  event_name = rs.getString("event_name");
                    String event_date = rs.getString("event_date");
                    String event_time = rs.getString("event_time");
                    String location = rs.getString("location");

                    updateSchedules.add(new Schedule(id, event_name, event_date, event_time, location));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return updateSchedules;
        }
    public static List<Registration> getRegistrationData(String query) {
        List<Registration> registrations = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event = rs.getString("event");
                String name = rs.getString("name");

                registrations.add(new Registration(id, name, event));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return registrations;
    }
    public static List<Registration> createRegistration(String registrationEvent, String registrationName) {
        List<Registration> registrations = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBER)) {
            preparedStatement.setString(1, registrationEvent);
            preparedStatement.setString(2, registrationName);
            preparedStatement.executeUpdate();

            PreparedStatement allRegistration = connection.prepareStatement("SELECT * FROM registration");
            ResultSet rs = allRegistration.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event = rs.getString("event");
                String name = rs.getString("name");

                registrations.add(new Registration(id, name, event));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return registrations;
    }
    public static List<Registration> deleteRegistration(int registrationId) {
        List<Registration> updateRegistrations = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MEMBER)) {
            preparedStatement.setInt(1, registrationId);
            preparedStatement.executeUpdate();

            PreparedStatement allRegistration = connection.prepareStatement("SELECT * FROM registration");
            ResultSet rs = allRegistration.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event = rs.getString("event");
                String name = rs.getString("name");

                updateRegistrations.add(new Registration(id, name, event));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateRegistrations;
    }
    public static List<Progress> getProgressData(String query) {
        List<Progress> progresses = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String  event_name = rs.getString("event_name");
                String status = rs.getString("status");

                progresses.add(new Progress(id, event_name, status));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return progresses;
    }
    public static List<Progress> updateProgress(String eventName, String eventStatus) {
        List<Progress> updateProgress = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS)) {
            preparedStatement.setString(3, eventName);
            preparedStatement.executeUpdate();

            PreparedStatement allProgress = connection.prepareStatement("SELECT * FROM progress");
            ResultSet rs = allProgress.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String  event_name = rs.getString("event_name");
                String status = rs.getString("status");

                updateProgress.add(new Progress(id, event_name, status));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateProgress;
    }


}
