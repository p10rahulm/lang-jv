public class Collatz {
    public static void main(String[] args){
        StdOut.print(collatz(7));
        // function collatz returns the number of recursive calls to collatz.
        // The side effect of collatz is to print the values of collatz at which it is called

        int n = Integer.parseInt(args[0]);
        int collatzing[] = new int[n];
        for (int i = 1; i < n; i++) {
            collatzing[i] = collatz(i);
        }
        VectorOps.printvector(collatzing);
        //StdOut.println("Collatz is maximum at " + VectorOps.which_max(collatzing) + " with value " + VectorOps.array_max(collatzing));
        StdOut.println("Collatz is maximum at with value " + VectorOps.array_max(collatzing));


    }
    public static int collatz(int n){
        //StdOut.print(n + " ");
        if(n==1)return 1;
        if(n%2==0){
            return collatz(n/2) +1;
        }
        return collatz(3*n+1) +1;
    }
}
