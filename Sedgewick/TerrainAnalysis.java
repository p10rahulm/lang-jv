public class TerrainAnalysis {
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
        for(int i =0;i<n;i++) {
            StdDraw.text(bucket_upperbounds[i]-0.25,-.25,Double.toString(bucket_upperbounds[i]));
        }
        StdDraw.text(l-0.25,0.125,Integer.toString(0));
        for(int i =1;i<=hist_max;i++) {
            StdDraw.text(l-0.25,i-0.125,Integer.toString(i));
        }

    }
}
