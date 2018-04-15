import java.util.ArrayList;

public class Data {
    public double min,max,average,variance,stdev;
    private double sum,sum_of_squares;
    ArrayList<Double> datapoints;
    public int num_datapoints;

    public Data() {
        this.min = Double.POSITIVE_INFINITY;
        this.max = Double.NEGATIVE_INFINITY;
        this.average = Double.NaN;
        this.variance = Double.NaN;
        this.stdev = Double.NaN;
        this.sum = 0;
        this.sum_of_squares = 0;
        datapoints = new ArrayList<Double>();
        this.num_datapoints = 0;
    }
    public Data(double datapoint) {
        this.min = datapoint;
        this.max = datapoint;
        this.average = datapoint;
        this.variance = 0;
        this.stdev = 0;
        this.sum = datapoint;
        this.sum_of_squares = datapoint*datapoint;
        this.datapoints = new ArrayList<Double>();
        this.datapoints.add(datapoint);
        this.num_datapoints = 1;
    }
    public void add_datapoint(double datapoint){
        this.datapoints.add(datapoint);
        if(datapoint<min){min=datapoint;}
        if(datapoint>max){max=datapoint;}
        this.sum+=datapoint;
        this.sum_of_squares+=datapoint*datapoint;
        this.num_datapoints+=1;
        this.average = (sum)/this.num_datapoints;
        /*
        for(double a:datapoints){
            this.variance += (a-average)*(a-average);
        }
        */
        this.variance =(sum_of_squares-2*average*sum+num_datapoints*average*average)/num_datapoints;
        this.stdev = Math.sqrt(this.variance);
    }
    public Data(double[] datapoints) {
        this(datapoints[0]);
        for (int i = 1; i < datapoints.length; i++) {
            this.add_datapoint(datapoints[i]);
        }
    }
    public void print_statistics(){
        StdOut.printf("The set of %d datapoints is: ",num_datapoints);
        ArrayListOperations.print_arraylist(this.datapoints,2);
        StdOut.printf("<min,max> = <%.2f,%.2f>\n",min,max);
        StdOut.printf("<sum,sum_of_sq> = <%.2f,%.2f>\n",sum,sum_of_squares);
        StdOut.printf("<average,variance,stdev> = <%.2f,%.2f,%4f>\n",average,variance,stdev);

    }
    public void histogram(int num_buckets){
        Histogram  hist = new Histogram(min,max,num_buckets);
        for(double a:this.datapoints){
            hist.add(a);
        }
        hist.draw(true);
        return;
    }

    public static void main(String[] args){
        int n = 5;
        double[] d = new double[n];
        for (int i = 0; i < n; i++) {
            d[i] = Math.random();
        }
        Data data = new Data(d);
        data.print_statistics();
        data.histogram(5);
    }
}
