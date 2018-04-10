public class VectorOps {
    public static double euclidean_distance(double[] a, double[] b) {
        if (a.length != b.length) {
            System.out.println("vectors re not of the same size");
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(a[i] - b[i], 2);
        }
        sum = Math.sqrt(sum);
        return (sum);

    }
    public static String[] reverse_new(String[] a) {
        String[] b = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - i - 1] = a[i];
        }
        return (b);
    }
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - i - 1] = a[i];
        }
        return (b);
    }
    public static String[] reverse(String[] a) {
        String t;
        for (int i = 0; i < (a.length + 1) / 2; i++) {
            t = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = t;
        }
        return (a);
    }
    public static void printvector(boolean[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static void printvector(String[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print("\"");
            System.out.print(a[i]);
            System.out.print("\"");
        }
        System.out.print("]\n");
    }
    public static void printvector(double[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static void printvector(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static int longest_rising_subsequence(int[] a) {
        int longest_now = 0, longest_so_far = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= prev) {
                longest_now++;
            } else {
                if (longest_now > longest_so_far) longest_so_far = longest_now;
                longest_now = 1;
            }
            prev = a[i];
        }
        return Math.max(longest_now, longest_so_far);
    }
    public static int longest_rising_subsequence(double[] a) {
        int longest_now = 0, longest_so_far = 0;
        double prev = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= prev) {
                longest_now++;
            } else {
                if (longest_now > longest_so_far) longest_so_far = longest_now;
                longest_now = 1;
            }
            prev = a[i];
        }
        return Math.max(longest_now, longest_so_far);
    }
    public static int longest_falling_subsequence(int[] a) {
        int longest_now = 0, longest_so_far = 0;
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= prev) {
                longest_now++;
            } else {
                if (longest_now > longest_so_far) longest_so_far = longest_now;
                longest_now = 1;
            }
            prev = a[i];
        }
        return Math.max(longest_now, longest_so_far);
    }
    public static int longest_falling_subsequence(double[] a) {
        int longest_now = 0, longest_so_far = 0;
        double prev = Double.POSITIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= prev) {
                longest_now++;
            } else {
                if (longest_now > longest_so_far) longest_so_far = longest_now;
                longest_now = 1;
            }
            prev = a[i];
        }
        return Math.max(longest_now, longest_so_far);
    }
    public static int[] longestplateau(int[] a) {
        //int[] g = {1,5,3,3,2,4,4,4,4};
        int longest_now = 0, longest_start_now = 0, longest_so_far = 0, longest_start_sofar = 0;
        int prev = a[0];
        boolean start_check = true;
        for (int i = 0; i < a.length; i++) {
            //System.out.println("outside, a[i] = " + a[i] + ", longest_now = " + longest_now + ", longest_so_far = " + longest_so_far + ", longest_start_now = " + longest_start_now + ", longest_start_sofar = " + longest_start_sofar);
            if (a[i] == prev && start_check) {
                longest_now++;
                if ((i == a.length - 1) && (longest_now > longest_so_far)) {
                    longest_so_far = longest_now;
                    longest_start_sofar = longest_start_now;
                }
            } else {
                //set for all old
                if (longest_now > longest_so_far) {
                    longest_so_far = longest_now;
                    longest_start_sofar = longest_start_now;
                }
                if (a[i] > prev) {
                    //set for new
                    start_check = true;
                    longest_now = 1;
                    longest_start_now = i;
                }
                if (a[i] < prev) {
                    start_check = false;
                }
            }
            prev = a[i];
        }
        return new int[]{longest_so_far, longest_start_sofar};
    }
    public static int[] permuted(int permute_size){
        //shuffles an array of size n, filled with numbers from 1 to n
        int[] out = new int[permute_size];
        for(int i =0;i<permute_size;i++){
            out[i]=i;
        }
        for(int i =0;i<permute_size;i++){
            int pick_random = (int)(Math.random()*(permute_size-i));
            exchange(out,i, i+pick_random);
        }
        return out;
    }
    public static void shuffle(int[] permute_array){
        int n = permute_array.length;
        for(int i =0;i<n;i++){
            exchange(permute_array,i, i+Random.randbetween(0,n-i));
        }
    }
    public static void shuffle(boolean[] permute_array){
        int n = permute_array.length;
        for(int i =0;i<n;i++){
            exchange(permute_array,i, i+Random.randbetween(0,n-i));
        }
    }
    public static void shuffle(double[] permute_array){
        int n = permute_array.length;
        for(int i =0;i<n;i++){
            exchange(permute_array,i, i+Random.randbetween(0,n-i));
        }
    }


    public static void exchange(double[] input_array,int x, int y){
        double temp = input_array[x];
        input_array[x] = input_array[y];
        input_array[y] = temp;
        return;
    }
    public static void exchange(int[] input_array,int x, int y){
        int temp = input_array[x];
        input_array[x] = input_array[y];
        input_array[y] = temp;
        return;
    }
    public static void exchange(boolean[] input_array,int x, int y){
        boolean temp = input_array[x];
        input_array[x] = input_array[y];
        input_array[y] = temp;
        return;
    }

    public static int[] bad_permuted(int permute_size){ //checking how not to permute!
        int[] out = new int[permute_size];
        for(int i =0;i<permute_size;i++){
            out[i]=i;
        }
        int pickrandom,temp;
        for(int i =0;i<permute_size;i++){
            pickrandom = (int)(Math.random()*(permute_size));
            temp = out[i];
            out[i] = out[pickrandom];
            out[pickrandom] = temp;
        }
        return out;
    }
    public static int[][] checkpermute(int permute_size,int number_of_shuffles){
        int[][] check_matrix = new int[permute_size][permute_size];
        //output m by m table such that row i gives the number of times that i wound up in position j for all j
        for(int i=0;i<number_of_shuffles;i++){
            int[] a = permuted(permute_size);
            for(int j =0;j<permute_size;j++){
                check_matrix[a[j]][j] += 1;
            }
        }

        return check_matrix;
    }
    public static int[][] check_bad_permute(int permute_size,int number_of_shuffles){
        int[][] check_matrix = new int[permute_size][permute_size];
        //output m by m table such that row i gives the number of times that i wound up in position j for all j
        for(int i=0;i<number_of_shuffles;i++){
            int[] a = bad_permuted(permute_size);
            for(int j =0;j<permute_size;j++){
                check_matrix[a[j]][j] += 1;
            }
        }

        return check_matrix;
    }
    public static double prob_sequentials_in_shuffle(int permute_size,int number_of_shuffles){
        boolean sequential;
        int num_sequentials=0;
        for(int i =0;i<number_of_shuffles;i++){
            int[] a = permuted(permute_size);
            for(int j=1;j<permute_size;j++){
                if(((a[j]-a[j-1])==1)){
                    num_sequentials++;
                    break;
                }
            }

        }
        return (double) num_sequentials/number_of_shuffles;

    }
    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4};
        double[] b = {4, 3, 2, 1};
        System.out.println(euclidean_distance(a, b));
        String[] c = {"a", "b", "c"};
        c = reverse(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        reverse(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        String[] d = reverse_new(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(d[i]);
        }
        int[] e = {1, 2, 3, 1, 2, 3, 3, 3, 3};
        int f = longest_rising_subsequence(e);
        System.out.println(f);
        int[] g = {1, 1, 5, 3, 3, 5, 4, 4, 4};
        System.out.println("--------");
        int[] h = longestplateau(g);
        System.out.println(h[0] + " " + h[1]);
        System.out.println("--------");
        int[]a1 = permuted(5);
        VectorOps.printvector(a1);
        int[][]b1 = checkpermute(5,5000);
        MatrixOps.print_matrix(b1);
        System.out.println("-------");
        b1 =check_bad_permute(5,5000);
        MatrixOps.print_matrix(b1);
        System.out.println("Probability of sequentials in shuffled permutation = "+
                prob_sequentials_in_shuffle(5,500));
        //Above doesn't seem to be affected by number of shuffles
        int[] num_times = new int[] {10,100,1000,10000,10000};
        check_num_minimums(num_times,1000);
        System.out.println("-----");
        printvector(a1);
        printvector(inverse_permutation(a1));
        int[] abc = new int[]{1,2,4,5,7,2,4,2,5,6,9};
        System.out.println("The statement abc contains duplicates is " + duplicate_finder(abc));
    }
    public static int num_minima(int[] input){
        int num_minimums =0,minsofar= Integer.MAX_VALUE;
        for(int i=0;i<input.length;i++){
            if(input[i]<minsofar){
                minsofar=input[i];
                num_minimums++;
            }
        }
        return num_minimums;
    }
    public static void check_num_minimums(int[] input_sizes,int num_tries){
        int num_minimas=0;
        double avg_num_minimas;
        for(int i =0;i<input_sizes.length;i++){
            for(int j =0;j<num_tries;j++){
                int[] a = permuted(input_sizes[i]);
                num_minimas += num_minima(a);
            }
            avg_num_minimas = (double) num_minimas/num_tries;
            System.out.println("Average number of minima at size: "+input_sizes[i]+" = "+avg_num_minimas);
        }
        //I get that the average number of minimas rises with the log size. To be precise, the log based on size 100000 = 1.36
        // This is calculated as e^(ln(100000)/37.448)
    }
    public static int[] inverse_permutation(int[] input_permutation){
        //This program outputs b given a permutation array a, such that a[b[i]] = b[a[i]] = i
        // Ex: for [4,1,0,3,2] the output should be a[b[0]] = 0 => b[0] = 2
        int[] output = new int[input_permutation.length];
        for(int i =0;i<input_permutation.length;i++){
            output[input_permutation[i]] = i;
        }
        return output;
    }
    public static boolean duplicate_finder(int[] input_array){
        printvector(input_array);
        input_array = sort_inplace(input_array);
        System.out.println("after sort");
        printvector(input_array);
        for(int i =0;i<input_array.length-1;i++){
            if(input_array[i]==input_array[i+1])return true;
        }
        return false;
    }

    public static int[] sort_inplace(int[] input_array){
        input_array = quicksort(input_array,0,input_array.length-1);
        return input_array;
    }
    public static int[] quicksort(int[] A, int lo, int hi){
        if(lo<hi){
            int p = partition(A,lo,hi);
            quicksort(A,lo,p-1);
            quicksort(A,p+1,hi);
        }
        return A;
    }
    public static int partition(int[] A, int lo, int hi){
        int pivot = A[hi];
        int i = lo-1,temp;
        for(int j = lo;j<hi;j++){
            if(A[j]<pivot){
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i+1];
        A[i+1] = A[hi];
        A[hi] = temp;
        return i+1;
    }

    public static double[] sort_inplace(double[] input_array){
        input_array = quicksort(input_array,0,input_array.length-1);
        return input_array;
    }
    public static double[] quicksort(double[] A, int lo, int hi){
        if(lo<hi){
            int p = partition(A,lo,hi);
            quicksort(A,lo,p-1);
            quicksort(A,p+1,hi);
        }
        return A;
    }
    public static int partition(double[] A, int lo, int hi){
        double pivot = A[hi];
        int i = lo-1; double temp;
        for(int j = lo;j<hi;j++){
            if(A[j]<pivot){
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i+1];
        A[i+1] = A[hi];
        A[hi] = temp;
        return i+1;
    }


    public static int dot_product(int[] a,int[] b){
        if(a.length!=b.length){
            throw new ArithmeticException("Array lengths are not equal");
        }
        int sum =0;
        for(int i=0;i<a.length;i++){
            sum+=a[i]*b[i];
        }
        return sum;
    }
    public static double dot_product(double[] a,double[] b){
        if(a.length!=b.length){
            throw new ArithmeticException("Array lengths are not equal");
        }
        double sum =0;
        for(int i=0;i<a.length;i++){
            sum+=a[i]*b[i];
        }
        return sum;
    }

    public static double array_max(double[] input_array){
        double max=Double.NEGATIVE_INFINITY;
        for(int i =0;i<input_array.length;i++){
            if(input_array[i]>max){max=input_array[i];}
        }
        return max;
    }
    public static double array_min(double [] input_array){
        double min=Double.POSITIVE_INFINITY;
        for(int i =0;i<input_array.length;i++){
            if(input_array[i]<min){min=input_array[i];}
        }
        return min;
    }
    public static int array_max(int[] input_array){
        int max= Integer.MIN_VALUE;
        for(int i =0;i<input_array.length;i++){
            if(input_array[i]>max){max=input_array[i];}
        }
        return max;
    }
    public static int array_min(int[] input_array){
        int min= Integer.MAX_VALUE;
        for(int i =0;i<input_array.length;i++){
            if(input_array[i]<min){min=input_array[i];}
        }
        return min;
    }
    public static int[] arraycopy(int[] input){
        int[] out = new int[input.length];
        for(int i =0;i<input.length;i++){
            out[i] = input[i];
        }
        return(out);
    }
    public static double[] arraycopy(double[] input){
        double[] out = new double[input.length];
        for(int i =0;i<input.length;i++){
            out[i] = input[i];
        }
        return(out);
    }
    public static boolean[] arraycopy(boolean[] input){
        boolean[] out = new boolean[input.length];
        for(int i =0;i<input.length;i++){
            out[i] = input[i];
        }
        return(out);
    }
    public static String[] arraycopy(String[] input){
        String[] out = new String[input.length];
        for(int i =0;i<input.length;i++){
            out[i] = input[i];
        }
        return(out);
    }
    public static double[] scale_tozero_one(double[] input_array){
        double[] copy = arraycopy(input_array);
        double min = array_min(input_array);
        double max = array_max(input_array);
        double diff = (max-min);
        for(int i =0;i<input_array.length;i++){
            copy[i]-=min;
            copy[i]/=diff;
        }
        return(copy);
    }
    public static double[] normalize(int[] input){
        double sum = 0;
        double[] out = new double[input.length];
        for(int i =0;i<input.length;i++){sum+=input[i];}
        for(int i =0;i<input.length;i++){out[i] = (double) input[i]/sum;}
        return out;
    }
    public static double[] normalize(double[] input){
        double sum = 0;
        double[] out = new double[input.length];
        for(int i =0;i<input.length;i++){sum+=input[i];}
        for(int i =0;i<input.length;i++){out[i] = input[i]/sum;}
        return out;
    }
    public static double[] cumulative_sum(double[] input){
        double[] output = arraycopy(input);
        for(int i = 1;i<output.length;i++){
                output[i]+=output[i-1];
        }
        return output;
    }
    public static int[] cumulative_sum(int[] input){
        int[] output = arraycopy(input);
        for(int i = 1;i<output.length;i++){
            output[i]+=output[i-1];
        }
        return output;
    }
    public static int[] readInt1d(){
        int n = StdIn.readInt();
        int[] out = new int[n];
        for(int i =0;i<n;i++){
            out[i] = StdIn.readInt();
        }
        return out;
    }
    public static double[] readDouble1d(){
        int n = StdIn.readInt();
        double[] out = new double[n];
        for(int i =0;i<n;i++){
            out[i] = StdIn.readDouble();
        }
        return out;
    }

}

