import java.util.Calendar;

public class Appointment {
    public static final int MINSTOMILLIS = 60000;
    private final String UID;
    private String belongs_to;
    private Calendar calendar;
    private int duration_in_minutes;
    private String Title;
    private String Description;

    public Appointment(String id, String belongs_to, Calendar cal, int duration_mins, String title, String description) {
        this.UID = id;
        this.belongs_to = belongs_to;
        calendar = cal;
        Title = title;
        Description = description;
        duration_in_minutes = duration_mins;
    }

    public String getId() {
        return UID;
    }

    public String getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(String belongs_to) {
        this.belongs_to = belongs_to;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public void setDate(Calendar cal) {
        this.calendar = cal;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getduration() {
        return duration_in_minutes;
    }
    public void setduration(int duration_mins) {
        duration_in_minutes = duration_mins;
    }

    public String toString() {
        return "Appointment \"" + Title +"\" belonging to " + belongs_to + " is on " + calendar + " for "+
                duration_in_minutes +" minutes.\nDetails: " + Description;
    }
    public String toDBstring() {
        StringBuilder s = new StringBuilder("");
        s.append(UID+"\t").append(belongs_to+"\t").append(calendar+"\t").append(duration_in_minutes+"\t").append(Title+"\t").append(Description+"\t");
        return s.toString();
    }


}
