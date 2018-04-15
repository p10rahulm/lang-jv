public class ChemicalElement {
    public final String name, symbol;
    public final int atomic_number;
    public final double atomic_weight;

    public ChemicalElement(String name, String symbol, int atomic_number, double atomic_weight) {
        this.name = name;
        this.symbol = symbol;
        this.atomic_number = atomic_number;
        this.atomic_weight = atomic_weight;
    }

    public String getSymbol() {
        return symbol;
    }
    public double getAtomic_weight() {
        return atomic_weight;
    }
    public int getAtomic_number() {
        return atomic_number;
    }
    public String toString() {
        String s = "";
        s = s +  name   + " (" + symbol + ")\n";
        s = s + "Atomic number: " + atomic_number + "\n";
        s = s + "Atomic weight: " + atomic_weight + "\n";
        return s;
    }

    public static void main(String[] args) {
        int num_elements = 103;
        ChemicalElement[] elements = new ChemicalElement[num_elements];

        // ignore first line
        String s = StdIn.readLine();

        // read data
        for (int i = 0; i < num_elements; i++) {
            s = StdIn.readLine();
            String[] fields = s.split(",");
            String name   = fields[0];
            int number    = Integer.parseInt(fields[1]);
            String symbol = fields[2];
            double weight = Double.parseDouble(fields[3]);
            elements[i] = new ChemicalElement(name, symbol,number, weight);
            StdOut.println(elements[i]);
        }
    }
}
