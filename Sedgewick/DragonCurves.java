/*
Going to use turtle for this one. Do go through Dragon Curves Basic module to see output before attempting this.
Sample output for different levels:
1. F
2. FLF
3. FLFLFRF
4. FLFLFRFLFLFRFRF
5. FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRF
 */
public class DragonCurves {
    public static void main(String[] args){
        //int n = Integer.parseInt(args[0]);
        for (int i = 1; i < 15; i++) {
            draw_dragon(i,0.05);
        }
    }
    public static void draw_dragon(int level, double step){
        StdDraw.clear();
        step = step/level;
        //StdDraw.setXscale(0.5-step*level*level*20,0.5+step*level*level*20);
        //StdDraw.setYscale(0.5-step*level*level*20,0.5+step*level*level*20);
        Turtle dragon = new Turtle(0.5,0.5,0);
        recurse_dragon(dragon, step, level,false);
        StdDraw.save("dragoncurve/dragon_"+level+".jpg");
    }
    public static void recurse_dragon(Turtle dragon,double step,int level,boolean reverse){
        if(level==1){
            dragon.forward(step);
            return;
        }
        if(reverse){
            recurse_dragon(dragon,step,level-1,!reverse);
            dragon.turn_left(3*Math.PI/2);
            recurse_dragon(dragon,step,level-1,reverse);
        } else{
            recurse_dragon(dragon,step,level-1,reverse);
            dragon.turn_left(Math.PI/2);
            recurse_dragon(dragon,step,level-1,!reverse);
        }

    }
}
