import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import java.util.Calendar;

public class AppointmentCalendar {
    private Appointment[] appointments;
    private final String name;
    private int next_pointer=0,num_nulls=0;
    public AppointmentCalendar(String name, Appointment[] appts,int size){
        this.name = name;
        appointments = new Appointment[size];
        for (int i = 0; i < appts.length; i++) {
            appointments[i] = appts[i];
        }
        next_pointer = appts.length;
    }
    public AppointmentCalendar(String name, Calendar[] calendars,int[] durations, String[] Titles, String[] Descriptions){
        this.name=name;
        if(calendars.length!=Titles.length||Titles.length!=Descriptions.length)throw new RuntimeException("Please check size of inputs");
        //We have to choose a length of Calendar array. We will choose the two power just above the size of current array.
        int size;
        {
            int twopow = 0;
            while(MMath.twopower(twopow) < calendars.length) {twopow++;}
            size = MMath.twopower(twopow);
        }
        this.appointments = new Appointment[size];
        for (int i = 0; i < calendars.length; i++) {
            appointments[i]=new Appointment(UUID.randomUUID().toString(),name,calendars[i],durations[i],Titles[i],Descriptions[i]);
        }
        next_pointer = calendars.length;
    }
    public AppointmentCalendar(String name, Calendar cal,int duration, String Title, String Description){
        this.name=name;
        //We have to choose a length of Calendar array. We will choose 8 as minimum.
        int size =8;
        this.appointments = new Appointment[size];
        appointments[0]=new Appointment(UUID.randomUUID().toString(),name,cal,duration,Title,Description);
        next_pointer = 1;
    }
    public AppointmentCalendar(String name){
        this.name=name;
        //We have to choose a length of Calendar array. We will choose 8 as minimum.
        int size =8;
        this.appointments = new Appointment[size];
    }
    public AppointmentCalendar copycalendar(int size){
        return new AppointmentCalendar(this.name,this.appointments,size);
    }
    public void add_appointment(Calendar AppointmentCal, int duration, String title, String description){
        int last_apptmnt = does_time_have_appointment(AppointmentCal,duration);
        if(last_apptmnt>=0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

            StdOut.print("Unable to add; time: " + sdf.format(AppointmentCal.getTime())+" to time:");
            AppointmentCal.add(Calendar.MINUTE,duration);
            StdOut.println(sdf.format(AppointmentCal.getTime())+" already has another appointment, "+appointments[last_apptmnt].getTitle());
            return;
        }
        if(next_pointer==appointments.length){
            Appointment[] newcal = new Appointment[appointments.length*2];
            for (int i = 0; i < appointments.length; i++) {
                newcal[i] = appointments[i];
            }
            this.appointments = newcal;
        }
        appointments[next_pointer] = new Appointment(UUID.randomUUID().toString(),name,AppointmentCal,duration,title,description);
        //StdOut.println(appointments[next_pointer].toString());
        next_pointer++;
    }

    public void remove_appointment(int rownum){
        appointments[rownum] = null;
        num_nulls++;

        /*
        If need be, we can remove old deleted stuff, but guess thats not necessary.
        if(num_nulls>appointments.length/2){
            Appointment[] newcal = new Appointment[appointments.length*2];
            for (int i = 0; i < appointments.length; i++) {
                newcal[i] = appointments[i];
            }
            this.appointments = newcal;
        }*/
    }
    public int does_time_have_appointment(Calendar cal,int duration_in_mins){
        long startmillis = cal.getTimeInMillis();
        long endmillis = cal.getTimeInMillis()+duration_in_mins*Appointment.MINSTOMILLIS;
        for (int i = 0; i < next_pointer; i++) {
            long starteventmillis = appointments[i].getCalendar().getTimeInMillis();
            long endeventmillis = appointments[i].getCalendar().getTimeInMillis()+appointments[i].getduration()*Appointment.MINSTOMILLIS;
            if((startmillis<=starteventmillis&&endmillis>=starteventmillis)||
                    (startmillis<=endeventmillis&&endmillis>=endeventmillis)){
                //damn mutable calendar!
                //StdOut.printf("i = %d,startmillis = %d,endmillis = %d,starteventmillis = %d,endeventmillis = %d\n",i,startmillis,endmillis,starteventmillis,endeventmillis);
                return i;
            }
        }
        return -1;
    }
    public void writetoDB(String filename){
        Out file = new Out(filename);
        file.printf("Sl.No\tUID\tCalendar Name\tdate\tduration in minutes\tTitle\tDescription\n");
        for (int i = 0; i < next_pointer; i++) {
            if(appointments[i]!=null) {
                file.printf("%s\t%s\n", i, appointments[i].toDBstring());
            }
        }
    }
    public static void main(String[] args){
        String filename = "data/Appointmentdb.dbsimple";
        AppointmentCalendar Rahul = new AppointmentCalendar("Rahul");
        Calendar cal = Calendar.getInstance();
        Rahul.add_appointment(cal,30,"Check","some  more check");
        Rahul.writetoDB(filename);
        for (int i = 0; i < 10; i++) {
            //Calendar being mutable. Have to set this from new.
            Rahul.add_appointment(new GregorianCalendar(2018,01,17-i),30+i,"Check"+i,"isn't eet working for the "+i + "th time");
        }
        Rahul.remove_appointment(7);
        Rahul.add_appointment(new GregorianCalendar(2018,01,17),30,"Check non addition","isn't eet ironic");
        Rahul.writetoDB(filename);
    }
}
