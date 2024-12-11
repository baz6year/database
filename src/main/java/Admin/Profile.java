package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Profile {
    private int id;
    private String name;
    private String status;

    @Override
    public String toString() {
        return "Student.Student{" +
                "id=" + id +
                ", name=" + name +
                ", status='" + status + '\'' +
                '}';
    }

    public Profile() {

    }

    public Profile(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public static class AdminCRUDUtils {
        private static String INSERT_EVENTS= "INSERT INTO schedules(event_name, event_date, event_time, location) VALUES (?, ?, ?, ?);";
        private static String DELETE_EVENTS= "DELETE FROM schedules WHERE id=?;";
        private static String INSERT_WORKERS= "INSERT INTO workers(name, status) VALUES (?, ?);";
        private static String DELETE_WORKERS= "DELETE FROM workers WHERE id=?;";
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

        public static List<Schedule> saveSchedule(Schedule schedule) {
            List<Schedule> schedules = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENTS)) {
                preparedStatement.setString(1, schedule.getEvent_name());
                preparedStatement.setString(2, schedule.getEvent_date());
                preparedStatement.setString(3, schedule.getEvent_time());
                preparedStatement.setString(4, schedule.getLocation());
                preparedStatement.executeUpdate();

                PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM schedules");
                ResultSet rs = allStudents.executeQuery();

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

        public static List<Schedule>deleteSchedule(int eventId) {
            List<Schedule> updateSchedules = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EVENTS)) {
                preparedStatement.setInt(1, eventId);
                preparedStatement.executeUpdate();

                PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM schedules");
                ResultSet rs = allStudents.executeQuery();

                while(rs.next()) {
                    int id =  rs.getInt("id");
                    String  event_name = rs.getString(" event_name");
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
        public static List<Profile> getWorkerData(String query) {
            List<Profile> profiles = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()) {
                    int id =  rs.getInt("id");
                    String  name = rs.getString("name");
                    String status = rs.getString("status");

                    profiles.add(new Profile(id, name, status));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return profiles;
        }
        public static List<Profile> saveWorker(Profile profile) {
            List<Profile> profiles = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKERS)) {
                preparedStatement.setString(1, profile.getName());
                preparedStatement.setString(2, profile.getStatus());
                preparedStatement.executeUpdate();

                PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM schedules");
                ResultSet rs = allStudents.executeQuery();

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
        public static List<Profile>deleteWorker(int workerId) {
            List<Profile> updateOwner = new ArrayList<>();
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WORKERS)) {
                preparedStatement.setInt(1, workerId);
                preparedStatement.executeUpdate();

                PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM schedules");
                ResultSet rs = allStudents.executeQuery();

                while(rs.next()) {
                    int id =  rs.getInt("id");
                    String name = rs.getString("name");
                    String status = rs.getString("status");

                    updateOwner.add(new Profile(id, name, status));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return updateOwner;
        }

    }
}

