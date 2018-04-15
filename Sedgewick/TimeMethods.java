import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeMethods {
    public static long getTimeDiffindays(Date dateOne, Date dateTwo) {
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
        long days = TimeUnit.MILLISECONDS.toDays(timeDiff);
        return days;
    }
}
