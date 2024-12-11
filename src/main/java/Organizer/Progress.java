package Organizer;

public class Progress {
    private int id;
    private String event_name;
    private String status;

    @Override
    public String toString() {
        return "Organizer.Progress{" +
                "id=" + id +
                ", event_name='" + event_name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Progress() {
    }

    public Progress(int id, String event_name, String status) {
        this.id = id;
        this.event_name = event_name;
        this.status = status;
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
