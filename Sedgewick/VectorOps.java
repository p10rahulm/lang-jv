public class VectorOps {
    public static double euclidean_distance(double[] a,double[]b){
        if(a.length!=b.length){
            System.out.println("vectors re not of the same size");
            return 0;
        }
        double sum =0;
        for(int i =0;i<a.length;i++){
            sum+=Math.pow(a[i]-b[i],2);
        }
        sum = Math.sqrt(sum);
        return(sum);

    }
    public static String[] reverse_new(String[] a){
        String[] b = new String[a.length];
        for(int i =0;i<a.length;i++){
            b[a.length-i-1]=a[i];
        }
        return(b);
    }
    public static String[] reverse(String[] a){
        String t;
        for(int i =0;i<(a.length+1)/2;i++){
            t = a[i];
            a[i]=a[a.length-i-1];
            a[a.length-i-1] =t;
        }
        return(a);
    }
    public static void printvector(boolean[] a){
        System.out.print("[");
        for(int i =0;i<a.length;i++){
            if(i!=0)System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static void printvector(String[] a){
        System.out.print("[");
        for(int i =0;i<a.length;i++){
            if(i!=0)System.out.print(", ");
            System.out.print("\"");
            System.out.print(a[i]);
            System.out.print("\"");
        }
        System.out.print("]\n");
    }
    public static void printvector(double[] a){
        System.out.print("[");
        for(int i =0;i<a.length;i++){
            if(i!=0)System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static void printvector(int[] a){
        System.out.print("[");
        for(int i =0;i<a.length;i++){
            if(i!=0)System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.print("]\n");
    }
    public static void main(String[] args){
        double[] a  = {1,2,3,4};
        double[] b  = {4,3,2,1};
        System.out.println(euclidean_distance(a,b));
        String[] c = {"a","b","c"};
        c = reverse(c);
        for(int i =0;i<c.length;i++){System.out.print(c[i]);}
        reverse(c);
        for(int i =0;i<c.length;i++){System.out.print(c[i]);}
        String[] d = reverse_new(c);
        for(int i =0;i<c.length;i++){System.out.print(d[i]);}
        int[] e = {1,2,3,1,2,3,3,3,3};
        int f = longest_rising_subsequence(e);
        System.out.println(f);
        int[] g = {1,3,3,3,2,3,3,3,3};
        System.out.println("--------");
        int[] h = longestplateau(g);
        System.out.println(h[0]+" "+h[1]);

    }
    public static int longest_rising_subsequence(int[] a){
        int longest_now = 0,longest_so_far = 0;
        int prev = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>=prev){
                longest_now++;
            } else {
                if(longest_now>longest_so_far)longest_so_far=longest_now;
                longest_now=1;
            }
            prev=a[i];
        }
        return Math.max(longest_now,longest_so_far);
    }
    public static int longest_rising_subsequence(double[] a){
        int longest_now = 0,longest_so_far = 0;
        double prev = Double.NEGATIVE_INFINITY;
        for(int i=0;i<a.length;i++){
            if(a[i]>=prev){
                longest_now++;
            } else {
                if(longest_now>longest_so_far)longest_so_far=longest_now;
                longest_now=1;
            }
            prev=a[i];
        }
        return Math.max(longest_now,longest_so_far);
    }
    public static int longest_falling_subsequence(int[] a){
        int longest_now = 0,longest_so_far = 0;
        int prev = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]<=prev){
                longest_now++;
            } else {
                if(longest_now>longest_so_far)longest_so_far=longest_now;
                longest_now=1;
            }
            prev=a[i];
        }
        return Math.max(longest_now,longest_so_far);
    }
    public static int longest_falling_subsequence(double[] a){
        int longest_now = 0,longest_so_far = 0;
        double prev = Double.POSITIVE_INFINITY;
        for(int i=0;i<a.length;i++){
            if(a[i]<=prev){
                longest_now++;
            } else {
                if(longest_now>longest_so_far)longest_so_far=longest_now;
                longest_now=1;
            }
            prev=a[i];
        }
        return Math.max(longest_now,longest_so_far);
    }
    public static int[] longestplateau(int[] a){
        int longest_now = 0,longest_so_far = 0;
        int prev = a[0],start=0,longest_start=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==prev&&i!=(a.length-1)){
                System.out.println("inside1, a[i] = "+ a[i]);
                longest_now++;
            } else if(a[i]==prev&&i==(a.length-1)&&longest_now>longest_so_far&&(start==0||a[start-1]<a[start])){
                System.out.println("inside2, a[i] = "+ a[i]);
                longest_so_far = longest_now;
                longest_start =start;
            } else if(a[i]!=prev&&longest_now>longest_so_far&&(start==0||a[start-1]<a[start])&&a[i-1]>a[i]){
                System.out.println("inside3, a[i] = "+ a[i]);
                longest_so_far = longest_now;
                longest_start =start;
                longest_now=1;
                start=i;
            }
            prev=a[i];
        }
        return new int[] {longest_so_far,longest_start};
    }

}
