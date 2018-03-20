import javax.rmi.ssl.SslRMIClientSocketFactory;

public class SamplingwithoutReplacement {
    public static void main(String[] args){
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[] perm = new int[n];
        for(int i=0;i<n;i++){perm[i] = i;}
        //for(int i=0;i<n;i++){System.out.println(perm[i]);}
        int temp;
        for(int i=0;i<m;i++){
            int rand = (int) (Math.random()*(n-i));
            temp = perm[i];
            perm[i] = perm[i+rand];
            perm[i+rand] = temp;
        }
        for(int i=0;i<m;i++){System.out.println(perm[i]);}


    }
}
