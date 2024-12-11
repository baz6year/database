package Admin;

public class Schedule {
    private int id;
    private String event_name;
    private String event_date;
    private String event_time;
    private String location;

    @Override
    public  String toString() {
        return "Student.Student{" +
                "id=" + id +
                ", event_name=" + event_name +
                ", event_date='" + event_date + '\'' +
                ", event_time='" + event_time + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Schedule() {

    }

    public Schedule(int id, String event_name, String event_date, String event_time, String location) {
        this.id = id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_time = event_time;
        this.location = location;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_name(){
        return event_name;
    }
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_date() {
        return event_date;
    }
    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time () {
        return event_time;
    }
    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getLocation () {
        return location;
    }
    public void setLocation(String course_name) {
        this.location = location;
    }

}

