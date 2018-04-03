public class ArrayStats {
    public static double max(double[] a){
        return VectorOps.array_max(a);
    }
    public static int max(int[] a){
        return VectorOps.array_max(a);
    }
    public static double min(double[] a){
        return VectorOps.array_min(a);
    }
    public static int min(int[] a){
        return VectorOps.array_min(a);
    }
    public static double average(int[] a){
        double avg = 0;
        for(int i =0;i<a.length;i++){avg+=a[i];}
        avg/=a.length;
        return avg;
    }
    public static double average(double[] a){
        double avg = 0;
        for(int i =0;i<a.length;i++){avg+=a[i];}
        avg/=a.length;
        return avg;
    }
    public static double mean(int[] a){
        double avg = 0;
        for(int i =0;i<a.length;i++){avg+=a[i];}
        avg/=a.length;
        return avg;
    }
    public static double mean(double[] a){
        double avg = 0;
        for(int i =0;i<a.length;i++){avg+=a[i];}
        avg/=a.length;
        return avg;
    }
    public static double variance(double[] a){
        double avg = average(a);
        double var = 0;
        for(int i =0;i<a.length;i++){var+=(a[i]-avg)*(a[i]-avg);}
        var/=a.length;
        return var;
    }
    public static double variance(int[] a){
        double avg = average(a);
        double var = 0;
        for(int i =0;i<a.length;i++){var+=((double)a[i]-avg)*((double)a[i]-avg);}
        var/=a.length;
        return var;
    }
    public static double stdev(double[] a){
        double var = variance(a);
        double stdev = Math.sqrt(var);
        return stdev;
    }
    public static double stdev(int[] a){
        double var = variance(a);
        double stdev = Math.sqrt(var);
        return stdev;
    }
    public static double median(double[] a){
        int num_middle=a.length/2;
        // below hugely inefficient. Solve when you get time.
        double[] b = VectorOps.arraycopy(a);
        b = VectorOps.sort_inplace(b);
        return b[num_middle];
    }
    public static int median(int[] a){
        int num_middle=a.length/2;
        // below hugely inefficient. Solve when you get time.
        int[] b = VectorOps.arraycopy(a);
        b = VectorOps.sort_inplace(b);
        return b[num_middle];
    }
    public static void plotPoints(double[] a){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+0.5,a[i]);
        }
    }
    public static void plotPoints(int[] a){
        int y_max = max(a);
        int y_min = min(a);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+0.5,a[i]);
        }
    }
    public static void plotPoints(double[] a,double offsetx){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+offsetx,a[i]);
        }
    }
    public static void plotPoints(int[] a,double offsetx){
        int y_max = max(a);
        int y_min = min(a);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+offsetx,a[i]);
        }
    }
    public static void plotPoints(double[] a,double offsetx,double penradius){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setPenRadius(penradius);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+offsetx,a[i]);
        }
    }
    public static void plotPoints(int[] a,double offsetx,double penradius){
        int y_max = max(a);
        int y_min = min(a);
        StdDraw.setPenRadius(penradius);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+offsetx,a[i]);
        }
    }
    public static void plotPoints(double penradius,double[] a){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setPenRadius(penradius);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+0.5,a[i]);
        }
    }
    public static void plotPoints(double penradius,int[] a){
        int y_max = max(a);
        int y_min = min(a);
        StdDraw.setPenRadius(penradius);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.point(i+0.5,a[i]);
        }
    }

    public static void plotLines(double[] a){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =1; i<a.length;i++){
            StdDraw.line(i+0.5,a[i],i-1+0.5,a[i-1]);
        }
    }
    public static void plotLines(int[] a){
        int y_max = max(a);
        double y_min = min(a);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =1; i<a.length;i++){
            StdDraw.line(i+0.5,a[i],i-1+0.5,a[i-1]);
        }
    }
    public static void plotLines(double[] a,double offsetx){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =1; i<a.length;i++){
            StdDraw.line(i+offsetx,a[i],i-1+offsetx,a[i-1]);
        }
    }
    public static void plotLines(int[] a,double offsetx){
        int y_max = max(a);
        double y_min = min(a);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =1; i<a.length;i++){
            StdDraw.line(i+offsetx,a[i],i-1+offsetx,a[i-1]);
        }
    }
    public static void plotBars(double[] a){
        double y_max = max(a);
        double y_min = min(a);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.filledRectangle(i+0.5,a[i]/2,0.25,Math.abs(a[i]/2));
        }
    }
    public static void plotBars(int[] a){
        int  y_max = max(a);
        int y_min = min(a);
        StdDraw.setXscale(0,a.length);
        StdDraw.setYscale(y_min,y_max);
        for(int i =0; i<a.length;i++){
            StdDraw.filledRectangle(i+0.5,a[i]/2,0.25,Math.abs(a[i]/2));
        }
    }
    public static double[] scale(double[] a,double y_min,double y_max){
        double miny = min(a);
        double maxy = max(a);
        double[] b = new double[a.length];
        for (int i =0;i<a.length;i++) {
            b[i] = y_min+(y_max-y_min)/(maxy-miny)*(a[i]-miny);
        }
        return(b);
    }

    public static void main(String[] args){
        double[] a = {1,-1,3.5,10,2,3};
        StdOut.printf("The average is %f\n",average(a));
        StdOut.printf("The max is %f\n",max(a));
        StdOut.printf("The min is %f\n",min(a));
        StdOut.printf("The var is %f\n",variance(a));
        StdOut.printf("The stdev is %f\n",stdev(a));
        StdOut.printf("The median is %f\n",median(a));
        plotBars(a);
        //plotLines(a);
    }
}
