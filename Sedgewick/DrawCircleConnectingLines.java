public class DrawCircleConnectingLines {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double prob = Double.parseDouble(args[1]);
        double[] x = new double[n];
        double[] y = new double[n];
        double radius = 0.9;
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        StdDraw.setPenRadius(0.01);
        for(int i =0;i<n;i++){
            x[i] = radius*Math.cos(2*Math.PI/n*i);
            y[i] = radius*Math.sin(2*Math.PI/n*i);
            StdDraw.point(x[i],y[i]);
        }
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius();
        for(int i =0;i<n;i++){
            for(int j=i;j<n;j++){
                if(Math.random()<prob){
                    StdDraw.line(x[i],y[i],x[j],y[j]);
                }
            }
        }
    }
}
