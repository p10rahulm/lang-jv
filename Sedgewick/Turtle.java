public class Turtle {
    double current_x;
    double current_y;
    double current_angle;

    public Turtle(double start_x, double start_y, double start_theta) {
        this.current_x = start_x;
        this.current_y = start_y;
        this.current_angle = start_theta;
        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);
    }

    public void forward(double step){
        double new_x = current_x+step*Math.cos(current_angle);
        double new_y = current_y+step*Math.sin(current_angle);

        StdDraw.line(current_x,current_y,new_x,new_y);
        current_x = new_x;
        current_y = new_y;
    }
    public void turn_left(double angle){
        current_angle +=(angle+2*Math.PI);
        current_angle = current_angle%(2*Math.PI);
    }
    public void save(String filename){
        StdDraw.save(filename);
    }
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double angle = (double)2*Math.PI/n;
        double step = Math.sin(angle/2);
        Turtle polygon = new Turtle(0.5,0,angle/2);
        for (int i = 0; i < n; i++) {
            polygon.forward(step);
            polygon.turn_left(angle);
        }
    }



}
