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
    public static void main(String[] args){
        double[] a  = {1,2,3,4};
        double[] b  = {4,3,2,1};
        System.out.println(euclidean_distance(a,b));
        String[] c = {"a","b","c"};
        c = reverse(c);
        for(int i =0;i<c.length;i++){System.out.println(c[i]);}
        reverse(c);
        for(int i =0;i<c.length;i++){System.out.println(c[i]);}
        String[] d = reverse_new(c);
        for(int i =0;i<c.length;i++){System.out.println(d[i]);}


    }

}
