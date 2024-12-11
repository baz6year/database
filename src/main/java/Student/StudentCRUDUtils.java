package Student;

import Admin.DBUtils;
import Admin.Schedule;
import Organizer.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCRUDUtils {
    private static String INSERT_MEMBER= "INSERT INTO registration(event, name) VALUES (?, ?);";
    private static String DELETE_MEMBER= "DELETE FROM registration WHERE id=?;";
    private static String UPDATE_MEMBER= "UPDATE registration SET name=? WHERE event=?;";
    private static String INSERT_EVENTS= "INSERT INTO schedule(event_name, event_date, event_time, location) VALUES (?, ?, ?, ?);";
    private static String INSERT_RATING= "INSERT INTO rating(event_name, score) VALUES (?, ?);";
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
    public static List<Registration> updateRegistration(String studentName, String studentEvent) {
        List<Registration> updateRegistration = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MEMBER)) {
            preparedStatement.setString(1, studentName);
            preparedStatement.setString(2, studentEvent);
            preparedStatement.executeUpdate();

            PreparedStatement allRegistration = connection.prepareStatement("SELECT * FROM registration");
            ResultSet rs = allRegistration.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event = rs.getString("event");
                String name = rs.getString("name");

               updateRegistration.add(new Registration(id, name, event));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateRegistration;
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
    public static List<Schedule> getScheduleData(String query) {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

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

    public static List<Rating> getRatingData(String query) {
        List<Rating> ratings = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event_name = rs.getString("event_name");
                String score = rs.getString("score");

                ratings.add(new Rating(id, event_name, score));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ratings;
    }
    public static List<Rating> createRating(String ratingEvent_name, String ratingScore) {
        List<Rating> ratings = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RATING)) {
            preparedStatement.setString(1, ratingEvent_name);
            preparedStatement.setString(2, ratingScore);
            preparedStatement.executeUpdate();

            PreparedStatement allRating = connection.prepareStatement("SELECT * FROM rating");
            ResultSet rs = allRating.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event_name = rs.getString("event_name");
                String score = rs.getString("score");

                ratings.add(new Rating(id, event_name, score));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ratings;
    }

}
