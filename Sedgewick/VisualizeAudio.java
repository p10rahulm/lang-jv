//java VisualizeAudio < data/elise.txt
import java.awt.*;
public class VisualizeAudio {
    public static int sampling_rate = 44100;

    public static void draw(double duration, double freq) {
        // Animation part
        StdDraw.clear();
        int plotted = (int) (0.005 * sampling_rate);
        double[] y = new double[plotted];
        double coeff = 2 * Math.PI / (sampling_rate / freq);
        for(int t = 0;t<plotted;t++){
            y[t] = Math.sin(coeff * t);
        }
        StdDraw.setYscale(-1,1);
        StdDraw.setXscale(0,plotted );
        for(int t = 1;t<plotted;t++){
            StdDraw.setPenRadius(0.01);
            StdDraw.point(t - 1, y[t - 1]);
            //StdDraw.setPenRadius(0.005);
            //StdDraw.line(t-1,y[t-1],t,y[t]);
        }
        StdDraw.pause((int)(duration*1000));
    }
    public static void sing(double duration, double freq) {
        int audio_length = (int)(duration*sampling_rate);
        double[] audio = new double [audio_length];

        double coeff =  2*Math.PI*freq/sampling_rate;
        for(int i =0;i<audio_length;i++){
            audio[i] = Math.sin(coeff * i); //sin(2*Math.PI*t/T); T = (sampling_rate/freq)
        }
        StdAudio.play(audio);
    }
    public static void paint_diamond(Picture paint, double freq) {
        for (int i = 0; i < paint.width(); i++) {
            for (int j = 0; j < paint.height(); j++) {
                if(Math.abs((double)(Math.abs(128-i)+Math.abs(128-j))/256-freq/1000)<0.025)paint.set(i,j,Color.BLACK);
            }
        }
    }
    public static void paint_circle(Picture paint, double freq) {
        for (int i = 0; i < paint.width(); i++) {
            for (int j = 0; j < paint.height(); j++) {
                if(Math.abs((double)((128-i)*(128-i)+(128-j)*(128-j))/128/128-freq/1000)<0.025)paint.set(i,j,Color.BLACK);
            }
        }
    }
    public static void paint_background(Picture paint, double freq) {
        Color col;
        col = Color.getHSBColor((float)(1-freq/1000),(float)(freq/1000),(float)(freq/1000));
        StdOut.println(freq);
        for (int i = 0; i < paint.width(); i++) {
            for (int j = 0; j < paint.height(); j++) {
                paint.set(i,j,col);
            }
        }
    }

    public static void main(String[] args){
        Picture painting = new Picture(256,256);

        while(!StdIn.isEmpty()){
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double freq = 440 * Math.pow(2, pitch / 12.0);
            //draw(duration, freq);
            sing(duration,freq);
            paint_background(painting, freq);
            paint_circle(painting,freq);
            paint_diamond(painting,freq);
            painting.show();
        }
        System.exit(0);
    }
}
