public class KochCurves {
    public static void main(String[] args){
        int level = Integer.parseInt(args[0]);
        draw_koch(level);
    }
    public static void draw_koch(int n){
        Turtle koch = new Turtle(0,0.3,0);
        StdDraw.setXscale(-0.15,1.15);
        StdDraw.setYscale(-0.15,1.15);
        draw_recursively(koch,1,n);
    }

    public static void draw_recursively(Turtle koch_turtle,double step,int level){
        if(level==0){
            koch_turtle.forward(step);
            return;
        }
        draw_recursively(koch_turtle,step/3,level-1);
        koch_turtle.turn_left(Math.PI/3);
        draw_recursively(koch_turtle,step/3,level-1);
        koch_turtle.turn_left(-2*Math.PI/3);
        draw_recursively(koch_turtle,step/3,level-1);
        koch_turtle.turn_left(Math.PI/3);
        draw_recursively(koch_turtle,step/3,level-1);
    }
}
