import java.util.ArrayList;

public class SplitCSVtoMultipleFiles {
    public static void main(String[]args) {
        String name = args[0];
        int n = Integer.parseInt(args[1]);
        String delim = ",";
        create_split_files(name,n,delim);

        double[] close = double_from_file("data/stocks/djia_Close.txt");
        double[] volume = double_from_file("data/stocks/djia_Volume.txt");
        plot_from_array_with_sampling(close,100,true);
        plot_from_array_with_sampling(volume,100,true);
    }

    public static void plot_from_array_with_sampling(double[] plot,int sampling_rate, boolean reverse){
        int[] x = new int[plot.length];
        for (int i = 0; i < plot.length; i++) {
            x[i]=i;
        }
        double[] plot_x = new double[plot.length/sampling_rate+1];
        double[] plot_y = new double[plot.length/sampling_rate+1];
        for (int i = 0,j=0; i < plot.length&&j<plot_x.length; i+=sampling_rate,j++) {
            plot_y[j] = plot[i];
            plot_x[j] = x[i];
        }
        if(reverse){
            plot_y = VectorOps.reverse(plot_y);
        }
        PlotFunction.plot_function(plot_x,plot_y);
    }

    public static double[] double_from_file(String filename){
        In data = new In(filename);
        data.readLine();//the first line may be the name, so let it pass!
        ArrayList<Double> outdouble = new ArrayList<Double>();
        while(!data.isEmpty()){
            outdouble.add(Double.parseDouble(data.readLine()));
        }
        double[] newdouble = new double[outdouble.size()];
        for (int i = 0; i < outdouble.size(); i++) {
            newdouble[i]=outdouble.get(i);
        }
        //double[] newdouble = outdouble.stream().mapToDouble(Double::doubleValue).toArray();
        return newdouble;
    }

    public static void create_split_files(String name,int num_files,String delim){
        Out[] out = new Out[num_files];
        //create output streams

        In in = new In(name+".csv");
        String topline = in.readLine();
        String[] filenames = topline.split(",");
        VectorOps.printvector(filenames);
        for (int i = 0; i < num_files; i++) {
            out[i] = new Out(name+"_"+filenames[i].replaceAll("[^a-zA-Z0-9]","") + ".txt");
            out[i].println(filenames[i]);
        }

        while (!in.isEmpty()){
            String line = in.readLine();
            //StdOut.println(line);
            String[] columns = line.split(delim);
            //VectorOps.printvector(columns);
            for (int i = 0; i < num_files; i++) {
                out[i].println(columns[i]);
            }
        }
    }
}
