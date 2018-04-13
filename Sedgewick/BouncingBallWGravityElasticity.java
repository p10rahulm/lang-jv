public class BouncingBallWGravityElasticity {
    public static void main(String[] args){
        double point_x = Math.random();
        double point_y = Math.random();
        double elasticity = (3+Math.random())/4; //only between 0.75 and 1
        double v_x = (Math.random()+1)/2/50; //some velocity of the order 50 times smaller than screen
        double v_y = (Math.random()+1)/2/50;
        double a_y = -0.001;
        double radius = 0.05;
        int stop_time = 20;
        for(int i =0;i<2000;i++){

            if((point_x + v_x + radius)>1){v_x=v_x*-1*elasticity;}
            if((point_x + v_x - radius)<0){v_x=v_x*-1*elasticity;}
            if((point_y + v_y + radius)>1){v_y=v_y*-1*elasticity;}
            if((point_y + v_y - radius)<0){
                v_y=v_y*-1*elasticity;
            } else{
                v_y +=a_y;
            }
            point_x+=v_x;
            point_y+=v_y;
            StdDraw.clear();
            StdDraw.filledCircle(point_x,point_y,radius);
            StdDraw.pause(stop_time);
        }

    }

}
