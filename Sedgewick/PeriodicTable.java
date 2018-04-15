import java.io.IOException;
import java.util.ArrayList;

public class PeriodicTable {
    public final ChemicalElement[] periodic_table;
    public PeriodicTable(String filename) throws IOException {
        int num_elements = FileMethods.countLines(filename)-1;
        this.periodic_table = new ChemicalElement[num_elements];

        In file = new In(filename);
        // ignore first line
        String s = file.readLine();

        // read data
        for (int i = 0; i < num_elements; i++) {
            s = file.readLine();
            String[] fields = s.split(",");
            String name   = fields[0];
            int number    = Integer.parseInt(fields[1]);
            String symbol = fields[2];
            double weight = Double.parseDouble(fields[3]);
            periodic_table[i] = new ChemicalElement(name, symbol,number, weight);
        }
    }
    public double get_molecular_weight(String molecular_formula){
        ArrayList<String> elements = get_elements(molecular_formula);
        //ArrayListOperations.print_ArrayListString(elements);
        double molecular_weight =0;
        boolean element_found = false;
        for(String element:elements){
            element_found = false;
            for(int i=0;i<periodic_table.length&&!element_found;i++){
                //StdOut.printf("i = %d,symbol =%s,current elem = %s\n",i,periodic_table[i].symbol,element);
                if(periodic_table[i].symbol.equals(element)){
                    molecular_weight+=periodic_table[i].atomic_weight;
                    element_found=true;
                }
            }
        }
        return molecular_weight;
    }
    public ArrayList<String> get_elements(String molecular_formula){
        ArrayList<String> elems = new ArrayList<String>();
        String nump ="[0-9]";
        String LP ="[A-Z]";
        String lp ="[a-z]";
        String[] s = molecular_formula.split("");
        int i = 0, t =1,n =1;
        while(i < s.length) {
            t =0;
            n =0;
            //StdOut.printf("i=%d,t=%d,n=%d\n",i,t,n);
            if(s[i].matches(LP)){
                while(i+t+1<s.length&& s[i+t+1].matches(lp)){
                    t+=1;
                }
                String elem = molecular_formula.substring(i,i+t+1);
                //StdOut.printf("elem = %s",elem);
                while(i+t+n+1<s.length&& s[i+t+n+1].matches(nump)){
                    n++;
                }
                if(n>0){
                    String numstring = molecular_formula.substring(i+t+1,i+t+n+1);
                    int num = Integer.parseInt(numstring);
                    //StdOut.printf(" and num elements = %s\n",numstring);
                    for (int j = 0; j < num; j++) {
                        elems.add(elem);
                    }
                } else{
                    elems.add(elem);
                    //StdOut.printf(" and num elements = 1\n");
                }
            }
            i+=(t+n+1);
        }
        //VectorOps.printvector(s);
        return elems;
    }

    public static void main(String[] args) throws IOException{
        String filename = "data/elements.csv";
        PeriodicTable pt = new PeriodicTable(filename);
        ArrayListOperations.print_ArrayListString(pt.get_elements("H2O"));
        StdOut.println(pt.get_molecular_weight("H2O"));



    }
}
