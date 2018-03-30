import java.text.DecimalFormat;

public class Spirograph {
    public static void main(String[] args){
        double R = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        double a = Double.parseDouble(args[2]);
        int max = 20000;
        double coeff = 2*Math.PI/100;
        double[] x = new double[max];
        double[] y = new double[max];
        double min_x = Double.MAX_VALUE,max_x = Double.MIN_VALUE,min_y = Double.MAX_VALUE,max_y = Double.MIN_VALUE;
        for(int i = 0; i< max; i++){
            double t = coeff*i;
            x[i] = (R+r)*Math.cos(t) - (r+a)*Math.cos((R+r)*t/r);
            y[i] = (R+r)*Math.sin(t) - (r+a)*Math.sin((R+r)*t/r);
            if(x[i]<min_x){min_x = x[i];}
            if(x[i]>max_x){max_x = x[i];}
            if(y[i]<min_y){min_y = y[i];}
            if(y[i]>max_y){max_y = y[i];}
        }

        StdDraw.setYscale(min_y,max_y);
        StdDraw.setXscale(min_x,max_x);
        for(int i = 1; i< max; i++){
            StdDraw.line(x[i],y[i],x[i-1],y[i-1]);
        }
        DecimalFormat df = new DecimalFormat("#");
        String filename = "Spirographs/spiro_"+ df.format(R)+"_"+ df.format(r)+"_"+ df.format(a)+".png";
        StdOut.println(filename);
        StdDraw.save(filename);


    }
}
