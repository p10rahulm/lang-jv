public class Charges_in_Plane {
    public static void main(String[] args){
        double w = Double.parseDouble(args[0]); //distance from (0.5,0.5) at which the charges are.
        Charge[] charges = new Charge[4];
        charges[0] = new Charge(0.5,0.5+w,1);
        charges[1] = new Charge(0.5+w,0.5,1);
        charges[2] = new Charge(0.5,0.5-w,1);
        charges[3] = new Charge(0.5-w,0.5,1);
        double potential_at_25_5 = 0;
        for (int i = 0; i < 4; i++) {
            potential_at_25_5 += charges[i].potentialAt(0.25,0.5);
        }
        StdOut.printf("The potential at (0.25,0.5) = %.3e",potential_at_25_5);

    }
}
