public class Chaos {
    public static void main(String[] args){
        double r = Double.parseDouble(args[0]);
        double start_population = Double.parseDouble(args[1]);
        int timesteps = Integer.parseInt(args[2]);
        double pop = start_population;
        for(int i=0;i<timesteps;i++){
            pop = r*pop*(1-pop);
            System.out.print("t = " + i + ", population="+pop);
            System.out.println();
        }

    }
}
