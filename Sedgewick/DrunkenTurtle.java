public class DrunkenTurtle {
    public static void main(String[] args){
        int trials = Integer.parseInt(args[0]);
        double step_size = Double.parseDouble(args[1]);
        go_the_drunked_turtle(trials,step_size);
    }

    public static void go_the_drunked_turtle(int trials,double step_size){
        Turtle drunkard = new Turtle(0.5,0.5,0);
        for (int i = 0; i < trials; i++) {
            drunkard.turn_left(Math.random()*2*Math.PI);
            drunkard.forward(step_size);
        }
    }
}
