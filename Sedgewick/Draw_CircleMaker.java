public class Draw_CircleMaker {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        StdDraw.setYscale(0,2*n);
        StdDraw.setXscale(0,2*n);
        for(int i =1; i<=n;i++){
            StdDraw.line(0,i,(n-i),0);
            StdDraw.line(2*n,i,(n+i),0);
            StdDraw.line(2*n,(n+i),(2*n-i),2*n);
            StdDraw.line(0,n+i,i,2*n);

        }
    }
}
