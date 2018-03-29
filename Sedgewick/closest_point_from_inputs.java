public class closest_point_from_inputs {
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);
        double min_x=x,min_y=y,min_z=z;
        double least_distance = Double.POSITIVE_INFINITY;
        while(!StdIn.isEmpty()){
            double x_current = StdIn.readDouble();
            double y_current = StdIn.readDouble();
            double z_current = StdIn.readDouble();
            double current_distance = (x_current-x)*(x_current-x) + (y_current-y)*(y_current-y) +(z_current-z)*(z_current-z);
            if(current_distance<least_distance){
                min_x = x_current;
                min_y = y_current;
                min_z = z_current;
            }
        }
        StdOut.printf("The closest point to (%4.2f,%4.2f,%4.2f) is (%4.2f,%4.2f,%4.2f)\n",x,y,z,min_x,min_y,min_z);

    }
}
