package Teacher;

import Admin.DBUtils;
import Admin.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherCRUDUtils {
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
}
