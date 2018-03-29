public class DrawCheckerBoard {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        StdOut.println(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i+j)%2==0){StdDraw.setPenColor(StdDraw.RED);} else{StdDraw.setPenColor(StdDraw.BLACK);}
                StdDraw.filledSquare((double)(2*i+1)/(2*n),(double)(2*j+1)/(2*n),(double)1/(n*2));
            }
        }
    }
}

