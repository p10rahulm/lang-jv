// A possible use case: java GeneratenRandom 100000 | java Get_Average
public class Get_Average {
    public static void main(String[] args){
        double sum =0;
        int count = 0;
        while(!StdIn.isEmpty()){
            // Press Ctrl+Z on windows or Ctrl + D on unix based systems to end the stdin stream
            double value = StdIn.readDouble();
            sum+=value;
            count++;
        }
        System.out.println("The average is "+sum/count);
    }

}
