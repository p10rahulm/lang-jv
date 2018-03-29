public class Geometric_Harmonic_Mean {
    public static void main(String[] args){
        double sum_logs=0,sum_harmonics=0;
        int n =0;
        while(!StdIn.isEmpty()){
            double a = StdIn.readDouble();
            sum_logs+=Math.log(a);
            sum_harmonics+=1/a;
            n+=1;
        }
        double Geometric_Mean = epowerx.epowerx(sum_logs/n);
        double Harmonic_Mean = n/sum_harmonics;
        StdOut.printf("The geometric mean is %7.4f and the harmonic mean is %7.4f.\n",Geometric_Mean,Harmonic_Mean);
    }
}
