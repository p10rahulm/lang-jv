public class AnimateCharges {
    public static void main(String[] args){
        Charge[] charges = load_charges();
        for (int i = 0; i < 100; i++) {
            VisualizeCharges.draw_charges(charges,512,512,1,1);
            charges[1].increaseCharge(-2);
        }

    }
    private static Charge[] load_charges(){
        Charge[] a = new Charge[3];
        a[0] = new Charge(0.4,0.6,50);
        a[1] = new Charge(0.5,0.5,-5);
        a[2] = new Charge(0.6,0.6,50);
        return a;
    }

}

