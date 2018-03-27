public class Draw_Scale_Maker {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        StdDraw.setYscale(0,n);
        StdDraw.setXscale(0,n);
        for(int i =0; i<n;i++){
            StdDraw.line(0,i,(n-i),0);
        }
    }
}
