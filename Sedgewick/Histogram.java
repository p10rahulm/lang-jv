import java.awt.*;
import java.text.DecimalFormat;

public class Histogram {
    public final double lowerbound,upperbound;
    public final int num_buckets;
    public final double[] lower_bounds;
    public final double[] upper_bounds;
    public final int[] buckets;
    public Histogram(double lower_bound,double upperbound,int number_of_buckets){
        this.lowerbound = lower_bound;
        this.upperbound = upperbound;
        this.num_buckets = number_of_buckets;
        this.upper_bounds = new double[number_of_buckets];
        this.lower_bounds = new double[number_of_buckets];
        for (int i = 0; i < number_of_buckets; i++) {
            lower_bounds[i] = lowerbound + (double)i/number_of_buckets*(upperbound-lowerbound);
            upper_bounds[i] = lowerbound + (double)(i+1)/number_of_buckets*(upperbound-lowerbound);
        }
        buckets = new int[number_of_buckets];
    }
    public void add(double p){
        int i =0;
        if(p<lowerbound||p>upperbound)return;
        while(p>upper_bounds[i]&&i<upper_bounds.length-1){
            i++;
        }
        buckets[i]++;
    }
    public void draw(boolean draw_mean,boolean draw_variance){
        VectorOps.printvector(buckets);
        Histogrm.histogrammer(buckets,lower_bounds,upper_bounds,num_buckets, draw_mean, draw_variance);
    }
    public void draw(boolean draw_mean){
        VectorOps.printvector(buckets);
        Histogrm.histogrammer(buckets,lower_bounds,upper_bounds,num_buckets, draw_mean, false);
    }
    public void draw(){
        VectorOps.printvector(buckets);
        Histogrm.histogrammer(buckets,lower_bounds,upper_bounds,num_buckets, false, false);
    }
    private static double get_hist_mean(double l, double[] upperbounds,int[] buckets){
        double sum =0,sumbuckets=0;
        sum += ((l+upperbounds[0])/2)*buckets[0];
        for (int i = 1; i < upperbounds.length; i++) {
            sum += ((upperbounds[i-1]+upperbounds[i])/2)*buckets[i];
        }
        for (int i = 0; i < buckets.length; i++) {
            sumbuckets+=buckets[i];
        }
        return sum/sumbuckets;
    }
    private static double get_hist_variance(double l, double[] upperbounds,int[] buckets,double mean){
        double sum =0,sumbuckets=0;
        sum += (((l+upperbounds[0])/2)-mean)*(((l+upperbounds[0])/2)-mean)*buckets[0];
        for (int i = 1; i < upperbounds.length; i++) {
            sum += (((upperbounds[i-1]+upperbounds[i])/2)-mean)*(((upperbounds[i-1]+upperbounds[i])/2)-mean)*buckets[i];
        }
        for (int i = 0; i < buckets.length; i++) {
            sumbuckets+=buckets[i];
        }
        return Math.sqrt(sum/sumbuckets);
    }

    public static void draw_histogram(double l,double r,int hist_max,double[] bucket_upperbounds,int[] buckets,int number_of_buckets, boolean draw_mean, boolean draw_variance){
        StdDraw.setXscale(l-r/20,r);
        StdDraw.setYscale(-(double) hist_max/20,hist_max);
        StdDraw.line(l-r/20,0,r,0);
        StdDraw.line(l,-0.5,l,hist_max);
        // Draw the first rectangle
        StdDraw.filledRectangle((bucket_upperbounds[0]+l)/2,(double) buckets[0]/2,(bucket_upperbounds[0]-l)/2,(double)buckets[0]/2);
        for(int i =1;i<number_of_buckets;i++){
            StdDraw.filledRectangle((bucket_upperbounds[i]+bucket_upperbounds[i-1])/2,(double) buckets[i]/2,(bucket_upperbounds[i]-bucket_upperbounds[i-1])/2,(double)buckets[i]/2);
        }

        if(draw_mean||draw_variance){
            double mean = get_hist_mean(l, bucket_upperbounds,buckets);
            if(draw_mean){
                StdDraw.setPenColor(Color.BLUE);
                StdDraw.setPenRadius(0.02);
                StdDraw.line(mean,0,mean,hist_max);
                StdDraw.setPenColor();
                StdDraw.setPenRadius();
            }
            if(draw_variance){
                double variance = get_hist_variance(l, bucket_upperbounds,buckets,mean);
                StdDraw.setPenColor(Color.RED);
                StdDraw.setPenRadius(0.005);
                StdDraw.line(mean-variance,0,mean-variance,hist_max);
                StdDraw.line(mean+variance,0,mean+variance,hist_max);
                StdDraw.setPenColor();
                StdDraw.setPenRadius();
            }
        }

        DecimalFormat df = new DecimalFormat(".#");
        {
            double last = 0.0;
            StdDraw.text(l+r/40,-(double) hist_max/40,df.format(l));
            for(int i =0;i<number_of_buckets;i++) {
                //StdOut.println((double)i/number_of_buckets);
                if((double)(i+1)/number_of_buckets>=last+0.1){
                    StdDraw.text(bucket_upperbounds[i]-r/40,-(double) hist_max/40,df.format(bucket_upperbounds[i]));
                    last = (double)i/number_of_buckets;
                }
            }
        }
        {
            double last = 0.0;
            StdDraw.text(l-r/40,0.125, Integer.toString(0));
            for(int i =1;i<=hist_max;i++) {
                if((double)i/hist_max>=last+0.1){
                    StdDraw.text(l-r/40,i-0.125, Integer.toString(i));
                    last = (double)i/hist_max;
                }

            }
        }

    }
    public static void main(String[] args){
        int num_buckets = 10;
        int trials = 1000;
        Histogram hist = new Histogram(0,10,10);
        for (int i = 0; i < trials; i++) {
            hist.add(Random.gaussian(5.5,1.5));
        }
        hist.draw();
        StdOut.println("Done!");
    }
}
