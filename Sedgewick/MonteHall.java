public class MonteHall {
    public static void main(String[] args){
        int numtrials = Integer.parseInt(args[0]);
        int numwins_noswitch=0;
        for(int i=0;i<numtrials;i++){
            if(montehallswitch((int)(Math.random()*3),'N'))numwins_noswitch++;
        }
        double p = (double)numwins_noswitch/numtrials;
        System.out.println("Probability of win with no switch = " + p);
        int numwins_switch=0;
        for(int i=0;i<numtrials;i++){
            if(montehallswitch((int)(Math.random()*3),'Y'))numwins_switch++;
        }
        p = (double)numwins_switch/numtrials;
        System.out.println("Probability of win with switch = " + p);


    }
    private static boolean montehallswitch(int choice, char switch_noswitch){ //takes choice as door 0,1 or 2 and switch as Y or N
        int winning_door = (int)(Math.random()*3);
        if(winning_door==choice && switch_noswitch=='N')return(true);
        return (winning_door != choice && switch_noswitch == 'Y');
    }
}
