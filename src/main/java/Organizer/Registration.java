package Organizer;

public class Registration {
    private int id;
    private String event;
    private String name;

    @Override
    public String toString() {
        return "Organizer.Registration{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Registration() {
    }

    public Registration(int id, String event, String name) {
        this.id = id;
        this.name = name;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
