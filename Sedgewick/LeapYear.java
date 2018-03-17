public class LeapYear {
    public static void main(String[] blargs){
        int year = Integer.parseInt(blargs[0]);
        System.out.println(year%4 == 0 && year %100!=0 || year%400 ==0);
    }
}
