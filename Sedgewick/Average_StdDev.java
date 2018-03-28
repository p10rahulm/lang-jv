public class Average_StdDev {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        double[] a = new double[size];
        for(int i=0;i<size;i++){
            a[i] = StdIn.readDouble();
        }
        double average = 0;
        for(int i=0;i<size;i++){
            average +=a[i];
        }
        average/=size;
        double stdev = 0;
        for(int i=0;i<size;i++){
            stdev+=Math.pow(a[i]-average,2);
        }
        stdev/=(size-1);
        stdev= Math.sqrt(stdev);
        StdOut.printf("The average is %7.2f and the std. deviation is %7.4f",average,stdev);


    }
}