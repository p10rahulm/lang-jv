public class IteratedFunctionSystems {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        StdOut.println("donez");
        double[] distribution = VectorOps.readDouble1d();
        //see below for explanation
        double[][] startx = MatrixOps.readDouble2D();
        StdOut.println("done1");

        double[][] starty = MatrixOps.readDouble2D();
        double x=0,y=0;
        for(int i =0;i<n;i++){
            int rand = Random.discrete(distribution);
            // These matrices have in each row, the coefficient of x, the coefficient of y and the constant;
            // so 3 per row and number of rows is the number of possible choices chosen from the Random.discrete(distribution)
            // we don't want the x changing while calculating y, so store the changed x in a temp variable.
            double temp = startx[rand][0]*x+startx[rand][1]*y + startx[rand][2];
            y = starty[rand][0]*x+starty[rand][1]*y + starty[rand][2];
            x = temp;
            StdDraw.point(x,y);
        }

    }
}
