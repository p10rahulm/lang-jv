// please input the month and the year as java Calendar MM YYYY
public class Calendar {
    public static void main(String[] args){
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        boolean leapyear = isleapyear(year);
        int numdays;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){numdays=31;}
        else if(month==2){if(leapyear){numdays=29;} else{numdays=28;}}
        else {numdays=30;}
        String monthString;
        switch (month) {
            case 1:  monthString = "January";       break;
            case 2:  monthString = "February";      break;
            case 3:  monthString = "March";         break;
            case 4:  monthString = "April";         break;
            case 5:  monthString = "May";           break;
            case 6:  monthString = "June";          break;
            case 7:  monthString = "July";          break;
            case 8:  monthString = "August";        break;
            case 9:  monthString = "September";     break;
            case 10: monthString = "October";       break;
            case 11: monthString = "November";      break;
            case 12: monthString = "December";      break;
            default: monthString = "Invalid month"; break;
        }
        StdOut.printf("%s, %d\n",monthString,year);
        StdOut.printf("%5s%5s%5s%5s%5s%5s%5s\n","Su","Mo","Tu","We","Th","Fr","Sa");
        int dayofFirst = day_of_week(1,month,year);
        int counter = 0;
        for(int i =0;i<dayofFirst;i++){StdOut.printf("%5s","");counter++;}
        for(int i =1;i<=numdays;i++){
            StdOut.printf("%5d",i);
            counter++;
            if(counter%7==0){StdOut.println();}
        }


    }
    // 0  is sunday and 6 is saturday
    public static int day_of_week(int day, int month, int year){
        int y0 = year - (14-month)/12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12*((14-month)/12)-2;
        int d0 = (day + x + (31*m0)/12) % 7;
        return d0;
    }
    //returns true or false
    public static boolean isleapyear(int year){
        return (year%4 == 0 && year %100!=0 || year%400 ==0);
    }

}
