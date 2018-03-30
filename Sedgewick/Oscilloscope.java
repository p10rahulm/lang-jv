import java.text.DecimalFormat;

public class Oscilloscope {
    public static void main(String[] args){
        double A1 = Double.parseDouble(args[0]);
        double freq1 = Double.parseDouble(args[1]);
        double theta1 = Double.parseDouble(args[2]);
        double A2 = Double.parseDouble(args[3]);
        double freq2 = Double.parseDouble(args[4]);
        double theta2 = Double.parseDouble(args[5]);
        int max = 2500;
        double coeff = 2*Math.PI/100;
        double[] x = new double[max];
        double[] y = new double[max];
        double min_x = Double.MAX_VALUE,max_x = Double.MIN_VALUE,min_y = Double.MAX_VALUE,max_y = Double.MIN_VALUE;
        for(int i = 0; i< max; i++){
            double t = coeff*i;
            x[i] = A1*Math.sin(freq1*t+theta1);
            y[i] = A2*Math.sin(freq2*t+theta2);
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

        DecimalFormat df = new DecimalFormat("#.#");
        String filename = "Oscilloscope/lissajous_"+ df.format(A1)+"_"+ df.format(freq1)+"_"+ df.format(theta1)+"-"+ df.format(A2)+"_"+ df.format(freq2)+"_"+ df.format(theta2)+".png";
        StdOut.println(filename);
        StdDraw.save(filename);
    }
}
