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
