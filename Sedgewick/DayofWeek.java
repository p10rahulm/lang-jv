public class DayofWeek {
    public static void main(String[] args){
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        day = Calendar.day_of_week(day,month,year);
        System.out.println(day);
    }

}
