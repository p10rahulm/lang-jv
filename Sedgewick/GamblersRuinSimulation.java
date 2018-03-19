public class GamblersRuinSimulation {
    public static void main(String[] args){
        int stake = Integer.parseInt(args[0]); //We assume a stake normalized such that for each victory or loss, there is a Rs 1 gain or loss respectively
        int goal = Integer.parseInt(args[1]); //Note that goal is over and above stake. So if goal is Rs 100 and I start with Rs 1000, the gambler wants to walk out with Rs 1100.
        int trials = Integer.parseInt(args[2]); // This is the number of trials to simulate for probability
        double prob_victory = Double.parseDouble(args[3]); //This is the probability of each win
        double win = 0;
        for(int numt = 1;numt<=trials;numt++){
            double holding = stake;
            while (holding>0 && holding<(stake+goal)){
                double roll = Math.random();
                if(roll<=prob_victory) holding +=1;
                else holding -=1;
                //System.out.println(holding);
            }
            if(holding>=(stake+goal)) {
                win +=1;
            }

        }
        System.out.println("Number of trials = " + trials);
        System.out.println("Number of victories = " + (win));
        System.out.println("Probability of victory = " + (win/trials));
    }
}
/* Results are crazy as explained in the book on computer science for Math by Tom Lehman.
If the probabilities go slightly below 0.5, the probability of ruin goes up drastically.
Further, it doesn't matter how much is bet, but the ruin is almost always certain.
For example, here are some sample outputs of the program:
java GamblersRuinSimulation 100 100 500 0.49
Prob victory = 0.036
java GamblersRuinSimulation 1000 100 500 0.49
Prob victory = 0.026
java GamblersRuinSimulation 10000 100 500 0.49
Prob victory = 0.02


 */