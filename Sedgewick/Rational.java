public class Rational {
    public final int numerator, denominator;

    public Rational(int numerator, int denominator) {
        int gcd = GCD_Euclid.gcd_iter(numerator,denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }
    public Rational plus(Rational A){
        return new Rational(this.numerator*A.denominator+this.denominator*A.numerator,this.denominator*A.denominator);
    }
    public Rational minus(Rational A){
        return new Rational(this.numerator*A.denominator-this.denominator*A.numerator,this.denominator*A.denominator);
    }
    public Rational times(Rational A){
        return new Rational(this.numerator*A.numerator,this.denominator*A.denominator);
    }
    public Rational over(Rational A){
        return new Rational(this.numerator*A.denominator,this.denominator*A.numerator);
    }
    public String toString(){
        return(this.numerator+"/"+this.denominator);
    }
    public static void main(String[] args){
        Rational A = new Rational(5,3);
        Rational B = new Rational(5,6);
        StdOut.println(A.plus(B));
        StdOut.println(A.minus(B));
        StdOut.println(A.times(B));
        StdOut.println(A.over(B));

    }


}
