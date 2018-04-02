// finally getting down to the Black Scholes
public class BlackScholes {
    public static void main(String[] args){
        //current stock price
        double s = Double.parseDouble(args[0]);
        //exercise strike price
        double x = Double.parseDouble(args[1]);
        //rate of return
        double r = Double.parseDouble(args[2]);
        //volatility
        double sigma = Double.parseDouble(args[3]);
        //time to maturity
        double t = Double.parseDouble(args[4]);

        //Get Option Value
        double option_val = get_option_price(s,x,r,sigma,t);
        System.out.println("The option value is = " + option_val);

        double implied_vol = get_implied_vol(option_val,s,x,r,t);
        System.out.println("The implied volatility at this option value is = " + implied_vol);


    }
    public static double get_option_price(double spot, double strike, double rate_of_interest,double volatility, double time_to_maturity){
        //Some intermediate values
        double a = (Math.log(spot/strike)+time_to_maturity*(rate_of_interest+volatility*volatility/2))/(volatility*Math.sqrt(time_to_maturity));
        double b = a - volatility*Math.sqrt(time_to_maturity);
        double option_val;
        option_val = spot*Random.Phi(a)-strike*Math.exp(-rate_of_interest*time_to_maturity)*Random.Phi(b);
        return option_val;
    }

    public static double get_implied_vol(double price,double spot, double strike, double rate_of_interest,double time_to_maturity){
        double hi = 1000;double lo = 0;
        double epsilon = 1e-5;
        double guess = (hi+lo)/2;
        double price_guess = get_option_price(spot,strike,rate_of_interest,guess,time_to_maturity);
        while(Math.abs(price_guess-price)>epsilon){
            //StdOut.printf("lo = %f, hi = %f, guess = %f, price_guess = %f,price = %f\n",lo,hi,guess,price_guess,price);
            if(price_guess>price){hi = guess;} else{lo = guess;}
            guess = (hi+lo)/2;
            price_guess = get_option_price(spot,strike,rate_of_interest,guess,time_to_maturity);
        }
        return guess;
    }

}
