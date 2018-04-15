import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StockTable {
    public final String name;
    public StockDataEntry[] historic_prices;

    public StockTable(String name, String filename){
        this.name = name;
        In file = new In(filename);
        int filelength =0;
        try {
            filelength = FileMethods.countLines(filename) - 1;
        } catch(IOException e){
            e.printStackTrace();
        }
        StockDataEntry[] historic_data = new StockDataEntry[filelength];
        file.readLine(); //let one line go.
        DateFormat df = new SimpleDateFormat("dd-MMM-yy");
        for (int i = 0; i < filelength; i++) {
            String line = file.readLine();
            String[] s = line.split(",");
            Date sdate = new Date();
            try {
                sdate = df.parse(s[0]);
            } catch (ParseException e) {
                StdOut.println("failing here");
                e.printStackTrace();
            }
            double open = Double.parseDouble(s[1]);
            double high = Double.parseDouble(s[2]);
            double low = Double.parseDouble(s[3]);
            double close = Double.parseDouble(s[4]);
            long vol = Long.parseLong(s[5]);
            historic_data[i] = new StockDataEntry(name,sdate,open,high,low,close,vol);
        }
        this.historic_prices = historic_data;
    }
    public double[] get_param_given_dates(Date datestart,Date datetill, String param){
        /*int days = (int) TimeMethods.getTimeDiffindays(datetill, datestart);
        StdOut.println(days);
        double[] out = new double[days];*/
        ArrayList<Double> outer = new ArrayList<Double>();
        int j =0;
        for (int i = 0; i < historic_prices.length; i++) {
            if(historic_prices[i].getDate().equals(datestart)||historic_prices[i].getDate().after(datestart)&&historic_prices[i].getDate().before(datetill)){
                if(param =="open") {
                    outer.add(historic_prices[i].getOpen());
                    //out[j] = historic_prices[i].getOpen();
                } else if(param =="high") {
                    outer.add(historic_prices[i].getHigh());
                    //out[j] = historic_prices[i].getHigh();
                } else if(param =="low") {
                    outer.add(historic_prices[i].getLow());
                    //out[j] = historic_prices[i].getLow();
                } else if(param =="close") {
                    outer.add(historic_prices[i].getClose());
                    //out[j] = historic_prices[i].getClose();
                }
                j++;
            }
        }
        double[] out = new double[outer.size()];
        for (int i = 0; i < outer.size(); i++) {
            out[i] = outer.get(i);
        }
        return out;
    }

    public static void main(String[] args){
        String filename = args[0];
        StockTable djia = new StockTable("DJIA",filename);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date datestart = new Date();
        Date dateend = new Date();
        try {
            datestart = formatter.parse("15-Jan-2002");
            dateend = formatter.parse("15-Jan-2003");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double[] close = djia.get_param_given_dates(datestart,dateend,"close");
        VectorOps.printvector(close);
        double[] x = new double[close.length];
        for (int i = 0; i < x.length; i++) {
            x[i]=i+1;
        }
        PlotFunction.plot_function(x,close);


    }

}
