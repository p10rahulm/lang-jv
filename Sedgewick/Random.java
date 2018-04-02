public class Random {
    public static int randbetween(int lo, int hi){
        if(hi<lo){int temp = lo;lo=hi;hi=temp;}
        return(lo+(int)(Math.random()*(hi-lo)));
    }
    public static double uniform(double lo, double hi){
        if(hi<lo){double temp = lo;lo=hi;hi=temp;}
        return(lo+Math.random()*(hi-lo));
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
    public static double Phi_inverse(double cumulative_prob, double mean, double sigma){
        double hi = 8,lo = -8;
        double epsilon = 1e-5;
        double z_guess=0,probn=0.5;
        while(MMath.abs(cumulative_prob-probn)>epsilon) {
            z_guess = (lo+hi)/2;
            probn = Phi(z_guess);
            if(probn>cumulative_prob){hi=z_guess;}else{lo=z_guess;}
        }
        //System.out.println("z_guess = "+z_guess+", sigma = "+sigma+", mean = "+mean+", sigma*z_guess+mean = "+(sigma*z_guess+mean));
        return (sigma*z_guess+mean);
    }
    public static double random_frm_normal(double mean, double sigma){
        double rand = Math.random();
        double randn = Phi_inverse(rand, mean, sigma);
        return randn;
    }
    public static double gaussian(double mean, double sigma){
        return(mean+sigma*std_gaussian());
    }
    public static double std_gaussian(){//Box-Muller method described by Knuth (or so i'm told). never have i read knuth :/
        double r,x,y;
        do {
            x = uniform(-1,1);
            y = uniform(-1,1);
            r= x*x+y*y;
        } while(r>=1 || r==0);
        return(x*Math.sqrt(-2*Math.log(r)/r));
    }


    public static void main(String[] args){
        System.out.println(randbetween(1,30));
        System.out.println(randbetween(2,1));
        System.out.println(randbetween(2,2));
        System.out.println(random_frm_normal(100,10));
        System.out.println(gaussian(100,10));

    }

}
