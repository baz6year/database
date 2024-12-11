package Student;

public class Rating {
    private int id;
    private String event_name;
    private String score;

    @Override
    public String toString() {
        return "Student.Rating{" +
                "id=" + id +
                ", event_name='" + event_name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public Rating() {
    }

    public Rating(int id, String event_name, String score) {
        this.id = id;
        this.event_name = event_name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getStatus() {
        return score;
    }

    public void setStatus(String status) {
        this.score = score;
    }
}
