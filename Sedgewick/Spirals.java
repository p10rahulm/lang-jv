public class Spirals {
    public static void main(String[] args){
        int angularity = Integer.parseInt(args[0]);
        int steps = Integer.parseInt(args[1]);
        double decay = Double.parseDouble(args[2]);
        draw_spiral_object(angularity,steps,decay);
    }
    public static void draw_spiral_object(int angularity,int steps,double decay){
        double angle = Math.PI*2/angularity;
        Turtle spira_mirablis = new Turtle(0.5,0,angle/2);
        double stepsize = Math.sin(angle/2);
        for (int i = 0; i < steps; i++) {
            spira_mirablis.forward(stepsize);
            stepsize/=decay;
            spira_mirablis.turn_left(angle);
        }
        spira_mirablis.save("spirals/spiral_angularity"+angularity+"_steps"+steps+"_decay"+decay+".jpg");
    }
}
