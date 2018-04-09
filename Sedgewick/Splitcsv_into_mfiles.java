public class Splitcsv_into_mfiles {
    public static void main(String[]args){
        String name = args[0];
        int n = Integer.parseInt(args[1]);
        String delim = ",";
        Out[] out = new Out[n];
        //create output streams
        for (int i = 0; i < n; i++) {
            out[i] = new Out(name +i + ".txt");
        }
        In in = new In(name+".csv");

        while (!in.isEmpty()){
            String line = in.readLine();
            //StdOut.println(line);
            String[] columns = line.split(delim);
            //VectorOps.printvector(columns);
            for (int i = 0; i < n; i++) {
                out[i].println(columns[i]);
            }
        }
    }
}
