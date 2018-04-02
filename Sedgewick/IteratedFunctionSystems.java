import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IteratedFunctionSystems {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        String filename = args[1];
        DrawIFS(n,filename, true);


    }
    public static void DrawIFS(int n, String filename,boolean save){
        // Change the StdIn scanner to read from above filename.txt. I'm doing this by changing setscanner to public method in StdIn.
        // change        // inputScan = new Scanner(System.in);        // to        // inputScan = new Scanner(new File(filePath));
        // The try catch was suggested by intellij and it worked!
        try {
            StdIn.setScanner(new Scanner(new File(filename+".txt")));
        } catch (FileNotFoundException e) {e.printStackTrace();}
        double[] distribution = VectorOps.readDouble1d();
        //see below for explanation
        double[][] startx = MatrixOps.readDouble2D();
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
        if(save){StdDraw.save(filename+".png");}
        StdIn.setScanner(new Scanner(System.in));
        StdOut.println(filename+".png saved");
    }
}
