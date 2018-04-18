//java CentralLimitTheorem data/CLT.txt 5 1000
import java.util.ArrayList;

public class CentralLimitTheorem {
    public static void main(String[] args){
        String filename = args[0];
        int number_to_sample = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        check_central_limit_theorem(filename,number_to_sample,trials);
    }
    public static void check_central_limit_theorem(String filename, int sample_size, int trials){
        double[] numbers = read_file_to_numlist(filename);
        double[] average = new double[trials];
        Histogram averages = new Histogram(VectorOps.array_min(numbers),VectorOps.array_max(numbers),10);
        for (int i = 0; i < trials; i++) {
            double[] sample = Random.sample(numbers,sample_size);
            for (int j = 0; j < sample.length; j++) {
                average[i]+=sample[j];
            }
            average[i]/=sample_size;
            averages.add(average[i]);
        }
        averages.draw(true,true);
    }
    private static double[] read_file_to_numlist(String filename){
        In file = new In(filename);
        ArrayList<Double> arrlist = new ArrayList<Double>();
        int n = Integer.parseInt(file.readLine());
        //let one line go
        file.readLine();
        for(int i=0;i<n;i++){
            String[] a = file.readLine().split("\\s+");
            //VectorOps.printvector(a);
            int freq = Integer.parseInt(a[0]);
            double num = Double.parseDouble(a[1]);
            for (int j = 0; j < freq; j++) {
                arrlist.add(num);
            }
        }

        double[] array = new double[arrlist.size()];
        for (int i = 0; i < arrlist.size(); i++) {
            array[i] = arrlist.get(i);
        }
        return array;
    }

}
