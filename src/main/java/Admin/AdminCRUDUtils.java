package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminCRUDUtils {
    private static String INSERT_EVENTS= "INSERT INTO schedule(event_name, event_date, event_time, location) VALUES (?, ?, ?, ?);";
    private static String DELETE_EVENTS= "DELETE FROM schedule WHERE id=?;";
    private static String INSERT_USER= "INSERT INTO profile(event, name) VALUES (?, ?);";
    private static String DELETE_USER= "DELETE FROM profile WHERE id=?;";

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
    public static List<Profile> getProfileData(String query) {
        List<Profile> profiles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String name = rs.getString("name");
                String status = rs.getString("status");

                profiles.add(new Profile(id, name, status));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return profiles;
    }
    public static List<Profile> createProfile(String profileName, String profileStatus) {
        List<Profile> profiles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, profileName);
            preparedStatement.setString(2, profileStatus);
            preparedStatement.executeUpdate();

            PreparedStatement allProfile = connection.prepareStatement("SELECT * FROM profile");
            ResultSet rs = allProfile.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String name = rs.getString("name");
                String status = rs.getString("status");

                profiles.add(new Profile(id, name, status));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return profiles;
    }
    public static List<Profile> deleteProfile(int profileId) {
        List<Profile> updateProfile = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, profileId);
            preparedStatement.executeUpdate();

            PreparedStatement allProfile = connection.prepareStatement("SELECT * FROM profile");
            ResultSet rs = allProfile.executeQuery();

            while(rs.next()) {
                int id =  rs.getInt("id");
                String event = rs.getString("event");
                String name = rs.getString("name");

                updateProfile.add(new Profile(id, name, event));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateProfile;
    }

}
