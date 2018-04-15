/*
        There seem to be 3 parts to the hilbert curve, left, right and middle.
        So we should traverse them as such and treat them separately.
        Lets call these parts 0,1 and 2 for left middle and right.
        Above comments deprecated!
*/

/*
1.
FRFRF - this is basic structure

2.
FLFLF - this is reverse structure
RF
FRFRF
LFL
FRFRF
FR
FLFLF

3.
FRFRF
LF
FLFLF
RFR
FLFLF
FL
FRFRF

FR

FLFLF
RF
FRFRF
LFL
FRFRF
FR
FLFLF
...
 */

public class HilbertCurves {
    public static void main(String[] args){
        //int i = Integer.parseInt(args[0]);
        //draw_hilbert(i,0.9);
        for (int i = 1; i < 15; i++) {
            draw_hilbert(i,(int)Math.pow(3,i-1));
        }
    }
    public static void draw_hilbert(int level, double step){

        double initial_angle = (level%2==0?0:Math.PI/2);
        Turtle hilbert = new Turtle(0.05,0.05,initial_angle);
        StdDraw.clear();
        int twopow = MMath.twopower(level)-1;
        StdDraw.setXscale(0-0.05*twopow,twopow*1.05);
        StdDraw.setYscale(0-0.05*twopow,twopow*1.05);
        recurse_hilbert(hilbert, step, level,true);
        StdDraw.save("hilbertcurve/hilbert_"+level+".jpg");
    }

    public static void recurse_hilbert(Turtle hilbert,double step,int level,boolean RightTriangle){
        if(level==1){
            double angle;
            if(RightTriangle){
                angle = Math.PI*3/2;
            }else {
                angle = Math.PI*1/2;
            }
            hilbert.forward(step);
            hilbert.turn_left(angle);
            hilbert.forward(step);
            hilbert.turn_left(angle);
            hilbert.forward(step);
            return;
        }
        //Initialize to RightTriangle
        double r_angle = Math.PI*3/2;
        double l_angle = Math.PI*1/2;
        if(!RightTriangle){
            /*
            FLFLF
                    RF
            FRFRF
                    LFL
            FRFRF
                    FR
            FLFLF
            */
            r_angle = Math.PI*1/2;
            l_angle = Math.PI*3/2;
        }
        recurse_hilbert(hilbert,step/3,level-1,!RightTriangle);
        if(level%2==0){
            hilbert.turn_left(r_angle);
            hilbert.forward(step/Math.pow(3,level-1));
        } else {
            hilbert.forward(step/Math.pow(3,level-1));
            hilbert.turn_left(r_angle);
        }

        recurse_hilbert(hilbert,step/3,level-1,RightTriangle);
        if(level%2==0){
            hilbert.turn_left(l_angle);
            hilbert.forward(step/Math.pow(3,level-1));
            hilbert.turn_left(l_angle);
        } else {
            hilbert.forward(step/Math.pow(3,level-1));
        }
        recurse_hilbert(hilbert,step/3,level-1,RightTriangle);
        if(level%2==0){
            hilbert.forward(step/Math.pow(3,level-1));
            hilbert.turn_left(r_angle);

        } else {
            hilbert.turn_left(r_angle);
            hilbert.forward(step/Math.pow(3,level-1));
        }
        recurse_hilbert(hilbert,step/3,level-1,!RightTriangle);
    }
}
