public class AnalyzeDigitalSignals {
    public static void main(String[] args){
        double power=0,magnitude=0,a=0,previous;
        int num_inputs=0,zerocrossings=0;
        while(!StdIn.isEmpty()){
            previous = a;
            a = StdIn.readDouble();
            num_inputs+=1;
            power+=a*a;
            magnitude+=Math.abs(a);
            if(previous!=0&&a!=0) {
                if (Math.abs(previous) / previous != Math.abs(a) / a) {
                    zerocrossings++;
                }
            }
        }
        double avg_power = power/num_inputs;
        double avg_magn = magnitude/num_inputs;
        StdOut.printf("The average power is %.2f. The average Magnitude is %.2f and the number of zero-crossings is %d\n",avg_power,avg_magn,zerocrossings);
    }
}
