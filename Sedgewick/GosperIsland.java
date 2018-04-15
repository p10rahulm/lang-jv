/*
The pattern seems to be as follows:
1.
FLF*6
2.
FLF
FRF
FLF * 6
3.
FLFFRFFLF * 6

 */

public class GosperIsland {
    public static void main(String[] args){
        //int level = Integer.parseInt(args[0]);
        for (int level = 1; level < 7; level++) {
            draw_gosper(level,0.25/level);
        }
        StdOut.println("done");
    }

    public static void draw_gosper(int level, double step){
        StdDraw.clear();
        Turtle gogo = new Turtle(0.5,0.0,0);
        StdDraw.setXscale(-0.05,1.05);
        StdDraw.setYscale(-0.05,1.05);
        for (int i = 0; i < 6; i++) {
            recurse_gosper(gogo, step, level,true);
        }
        StdDraw.save("gosperisland/gosper_"+level+".jpg");
    }

    public static void recurse_gosper(Turtle gosh,double step,int level,boolean angling_in){
        //see comments at top of file
        if(level==1){
            double angle;
            if(angling_in){
                angle = Math.PI*1/3;
            }else {
                angle = Math.PI*-1/3;
            }
            gosh.forward(step);
            gosh.turn_left(angle);
            gosh.forward(step);
            return;
        }
        recurse_gosper(gosh,step/2,level-1,angling_in);
        recurse_gosper(gosh,step/2,level-1,!angling_in);
        recurse_gosper(gosh,step/2,level-1,angling_in);
    }
}
