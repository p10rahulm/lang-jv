import java.awt.*;
import java.text.DecimalFormat;

public class Histogrm {

    public static void main(String[] args){
        double l = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        double[] bucket_upperbounds = new double[n];
        for(int i =0;i<n;i++){
            bucket_upperbounds[i] = l+(r-l)/n*(i+1);
        }
        int[] buckets = new int[n];
        while(!StdIn.isEmpty()){
            double a = StdIn.readDouble();
            boolean found = false;
            int i =0;
            while(found == false&&i<n){
                if(a<bucket_upperbounds[i]){buckets[i]++;found=true;} else{i++;}
            }
        }
        int hist_max=0; // ditch hist_min as it's not sure that we want axis moved ,hist_min=buckets[0];
        for (int i =0;i<n;i++) {
            if(buckets[i]>hist_max){
                hist_max = buckets[i];
            }
        }
        System.out.println("histmax = "+hist_max);
        VectorOps.printvector(bucket_upperbounds);
        VectorOps.printvector(buckets);
        StdDraw.setXscale(l-0.5,r);
        StdDraw.setYscale(-0.5,hist_max);
        StdDraw.line(l-0.5,0,r,0);
        StdDraw.line(l,-0.5,l,hist_max);
        // Draw the first rectangle
        StdDraw.filledRectangle((bucket_upperbounds[0]+l)/2,(double) buckets[0]/2,(bucket_upperbounds[0]-l)/2,(double)buckets[0]/2);
        for(int i =1;i<n;i++){
            StdDraw.filledRectangle((bucket_upperbounds[i]+bucket_upperbounds[i-1])/2,(double) buckets[i]/2,(bucket_upperbounds[i]-bucket_upperbounds[i-1])/2,(double)buckets[i]/2);
        }
        StdDraw.text(l+0.125,-.25,Double.toString(l));
        DecimalFormat df = new DecimalFormat(".#");
        for(int i =0;i<n;i++) {
            StdDraw.text(bucket_upperbounds[i]-0.25,-.25,df.format(bucket_upperbounds[i]));
        }
        StdDraw.text(l-0.25,0.125, Integer.toString(0));
        for(int i =1;i<=hist_max;i++) {
            StdDraw.text(l-0.25,i-0.125, Integer.toString(i));
        }

    }
    private static void initializebucket_upper_lower_bounds(double[] bucket_lowerbounds,double[] bucket_upperbounds,double lower_x, double upper_x,int numbuckets){
        for(int i =0;i<numbuckets;i++){
            bucket_upperbounds[i] = lower_x+(upper_x-lower_x)/numbuckets*(i+1);
        }
        for(int i =0;i<numbuckets;i++){
            bucket_lowerbounds[i] = lower_x+(upper_x-lower_x)/numbuckets*(i);
        }
        return;
    }
    private static void fillbuckets(int[] buckets,double[] bucket_lowerbounds,double[] bucket_upperbounds,double[] histogram_x, int[] histogram_y){
        // Since we do not know the distribution within a single bucket x, we will assume the concentration is at the x.
        // While other distributions are possible, we will not attempt them here.
        for(int i =0;i<histogram_y.length;i++){
            int num_in_bucket = histogram_y[i];
            double bucket_point = histogram_x[i];
            boolean found = false;
            int j =0;
            while(found == false&&j<bucket_upperbounds.length){
                if(bucket_point<bucket_upperbounds[j]&&bucket_point>=bucket_lowerbounds[j]){
                    buckets[j]+=num_in_bucket;
                    found=true;
                } else{
                    j++;
                }
            }
        }
        return;
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
    private static void draw_histogram(double l,double r,int hist_max,double[] bucket_upperbounds,int[] buckets,int number_of_buckets, boolean draw_mean, boolean draw_variance){
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
    public static void histogram_from_hist_array(int[] histogram_y, double[] histogram_x, int num_histogram_buckets, boolean draw_mean, boolean draw_variance) {
        //histogram-ys indicate the number of occurances in the histogram x_s, so it is an int array
        double l = VectorOps.array_min(histogram_x);
        double r = VectorOps.array_max(histogram_x);
        int n = num_histogram_buckets;
        double[] bucket_upperbounds = new double[n];
        double[] bucket_lowerbounds = new double[n];
        initializebucket_upper_lower_bounds(bucket_lowerbounds, bucket_upperbounds, l, r, n);

        int[] buckets = new int[n];
        fillbuckets(buckets, bucket_lowerbounds, bucket_upperbounds, histogram_x, histogram_y);

        int hist_max = VectorOps.array_max(buckets); // ditch hist_min as it's not sure that we want axis moved ,hist_min=buckets[0];
        draw_histogram(l,r,hist_max,bucket_upperbounds,buckets,n, draw_mean, draw_variance);
    }
    public static void histogrammer(int[] buckets, double[] x_lowerbounds, double[] x_upperbounds, int num_histogram_buckets, boolean draw_mean, boolean draw_variance) {
        //histogram-ys indicate the number of occurances in the histogram x_s, so it is an int array
        double l = x_lowerbounds[0];
        double r = x_upperbounds[x_upperbounds.length-1];
        int n = num_histogram_buckets;
        StdOut.println("buckets");
        VectorOps.printvector(buckets);
        StdOut.println("x_lowerbounds");
        VectorOps.printvector(x_lowerbounds);
        StdOut.println("x_upperbounds");
        VectorOps.printvector(x_upperbounds);
        StdOut.println("l = "+l+", r="+r);
        int hist_max = VectorOps.array_max(buckets); // ditch hist_min as it's not sure that we want axis moved ,hist_min=buckets[0];
        draw_histogram(l,r,hist_max,x_upperbounds,buckets,n, draw_mean, draw_variance);
    }
}


