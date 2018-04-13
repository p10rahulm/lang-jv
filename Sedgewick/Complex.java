public class Complex {
    private final double real,imag;
    public Complex(double real_part,double imaginary_part){
        real = real_part;
        imag = imaginary_part;
    }
    public double real(){
        return real;
    }
    public double imaginary(){
        return imag;
    }

    public Complex plus(Complex a){
        return new Complex(real+a.real(),imag+a.imaginary());
    }
    public Complex minus(Complex a){
        return new Complex(real-a.real(),imag-a.imaginary());
    }
    public double abs(){
        return Math.sqrt(real*real - imag*imag);
    }
    public String toString(){
        return (real+" + " +imag+"i");
    }
    public Complex times(Complex a){
        return new Complex(real*a.real()-imag*a.imaginary(),real*a.imaginary()+imag*a.real());
    }
    public static void main(String[] args){
        Complex z0 = new Complex(1,1);
        Complex z = z0;
        z = z.times(z).plus(z0);
        z = z.times(z).plus(z0);
        StdOut.println(z);
    }
}
