// java BinomialRecursivewithMemoization 25 12
// Naive starts to feel the heat above this. i couldn't get it to complete within 3 seconds at
// java BinomialRecursivewithMemoization 50 20

public class BinomialRecursivewithMemoization {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long starttime = System.nanoTime();
        int[][] holder = new int[n+1][k+1];
        holder = binomial(n,k,holder);
        StdOut.println(holder[n][k]);
        // For the heck of it, we shall save the number of calls saved at holder[0][1], which is never accessed (only 0,0 is accessed- see pascals binomial triangle)
        StdOut.println(holder[0][1]);
        StdOut.printf("time taken in ms is %d ms\n",(System.nanoTime()-starttime)/1000000);

        //Compare time with naive implementation
        starttime = System.nanoTime();
        StdOut.println(Binomial_Recursive_Naive.binomial3(n,k));
        StdOut.printf("time taken in ms is %d ms\n",(System.nanoTime()-starttime)/1000000);
    }
    public static int[][] binomial(int n, int k,int[][] holder){
        if(holder[n][k]!=0){
            holder[0][1]+=1;
            return holder;
        }
        if(n==0 || k==0|| k==n) {
            holder[n][k] =1;
            return holder;
        }
        binomial(n-1,k,holder);
        binomial(n-1,k-1,holder);
        holder[n][k] = holder[n-1][k] + holder[n-1][k-1];
        return(holder);
    }
}
