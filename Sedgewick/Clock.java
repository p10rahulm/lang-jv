import java.util.Calendar;
public class Clock {
    public static void main(String[] args){
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int minute = rightNow.get(Calendar.MINUTE);
        int second = rightNow.get(Calendar.SECOND);
        System.out.println(hour+":"+minute+":"+second);
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);

        for(int i =0;i<1000;i++) {
            StdDraw.clear();
            draw_clock_ends(hour,minute,second);
            StdDraw.pause(1000);
            {
                second+=1;
                if(second==60){minute+=1;}
                if(minute==60){hour+=1;}
                second=second%60;
                minute=minute%60;
                hour=hour%12;
            }
        }

    }
    public static void draw_clock_ends(int hour, int minute,int second){
        for(int i=0;i<12;i++){
            double clockdeg = (double)((3-i))/6*Math.PI;
            if(i%3==0){
                StdDraw.setPenRadius(3*0.005);
                StdDraw.line(0.87*Math.cos(clockdeg),0.87*Math.sin(clockdeg),Math.cos(clockdeg),Math.sin(clockdeg));
            } else {
                StdDraw.setPenRadius(2.5*0.005);
                StdDraw.line(0.95*Math.cos(clockdeg),0.95*Math.sin(clockdeg),Math.cos(clockdeg),Math.sin(clockdeg));
            }
        }
        double seconddeg = (double) ((15 - second)) / 30 * Math.PI;
        double minutedeg = (double) ((15 - (minute + (double) second / 60))) / 30 * Math.PI;
        double hourdeg = (double) ((3 - (hour + (double) minute / 60 + (double) second / 3600))) / 6 * Math.PI;
        StdDraw.setPenRadius(0.005);
        StdDraw.line(0, 0, Math.cos(seconddeg), Math.sin(seconddeg));
        StdDraw.setPenRadius(1.5 * 0.005);
        StdDraw.line(0, 0, 0.85 * Math.cos(minutedeg), 0.85 * Math.sin(minutedeg));
        StdDraw.setPenRadius(3 * 0.005);
        StdDraw.line(0, 0, 0.5 * Math.cos(hourdeg), 0.5 * Math.sin(hourdeg));
    }
}
