public class Random {
    public static int randbetween(int lo, int hi){
        if(hi<lo){int temp = lo;lo=hi;hi=temp;}
        return(lo+(int)(Math.random()*(hi-lo)));
    }
    //below tells you given a z score what is the probability. Z score is (x-mu)/sigma
    public static double phi(double z){
        return (Math.exp(-z*z/2)/Math.sqrt(2*Math.PI));
    }
    public static double phi(double z,double sigma){
        return (Math.exp(-z*z/2)/Math.sqrt(2*Math.PI*sigma*sigma));
    }
    public static double phi(double x,double mu,double sigma){
        return (Math.exp(-(x-mu)*(x-mu)/2/sigma/sigma)/Math.sqrt(2*Math.PI*sigma*sigma));
    }
    // below implements the cumulative Probability Distribution Function (or CDF)
    // The way this is done is to implement a series sum and works in the case of a standard normal distribution
    public static double Phi(double z){
        if(z<-8){return 0;}
        if(z>8){return 1;}
        double sum=0, term = z;
        int i = 3;
        while(sum!=sum+term){
            sum+=term;
            term*=z*z/i;
            i+=2;
        }
        return(0.5 + phi(z)*sum);
    }
    public static double normdist(double mean, double sigma){
        double randn = Math.random();
        //System.out.print("Random - "+randn+"\n");
        double hi = 8,lo = -8;
        double epsilon = 1e-5;
        double z_guess,probn;
        do {
            z_guess = (lo+hi)/2;
            probn = Phi(z_guess);
            //System.out.print("probn - "+probn+", hi - "+hi+",lo-"+lo+",z-"+z_guess+"\n");
            if(probn>randn){hi=z_guess;}else{lo=z_guess;}
        } while(MMath.abs(randn-probn)>epsilon);
        return sigma*z_guess+mean;
    }

    public static void main(String[] args){
        System.out.println(randbetween(1,30));
        System.out.println(randbetween(2,1));
        System.out.println(randbetween(2,2));
        System.out.println(normdist(100,10));
    }

}
