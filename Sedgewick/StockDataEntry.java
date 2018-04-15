import java.util.Date;

public class StockDataEntry {
    private final String stock_name;
    private final Date date;
    private final double open,high,low,close;
    private final long volume;

    public StockDataEntry(String stock_name, Date date, double open, double high, double low, double close,long volume) {
        this.stock_name = stock_name;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String getStock_name() {
        return stock_name;
    }

    public Date getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }
    public long getVolume(){
        return volume;
    }

}
