public class StatisticalPolling {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        double p = (double) m/n;
        while(!StdIn.isEmpty()){
            int a = StdIn.readInt();
            if(Math.random()<p){StdOut.print(a + " ");}
        }
    }
}
