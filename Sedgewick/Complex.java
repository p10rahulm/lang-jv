public class Complex {
    private final double real,imag;
    private double r=0,theta=0;
    public Complex(double real_part,double imaginary_part){
        real = real_part;
        imag = imaginary_part;
    }
    //another constructor
    public Complex(double real_part){
        real = real_part;
        imag = 0.0;
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
    public Complex times(Complex a){
        return new Complex(real*a.real()-imag*a.imaginary(),real*a.imaginary()+imag*a.real());
    }
    public Complex divides(Complex a){
        double denom = a.times(a.conjugate()).real;
        Complex num = this.times(a.conjugate());
        return new Complex(num.real/denom,num.imag/denom);
    }
    public Complex power_recursive(int pow){
        return pow_recurse(this,this,pow);
    }
    public Complex pow_recurse(Complex orig, Complex curr, int pow){
        if(pow==1) return curr;
        return pow_recurse(orig,curr.times(orig),pow-1);
    }
    public double abs(){
        return Math.sqrt(real*real + imag*imag);
    }
    public String toString(){
        return (real+" + " +imag+"i");
    }


    public Complex[] nth_root(int n){
        //return new Complex(real*a.real()-imag*a.imaginary(),real*a.imaginary()+imag*a.real());
        generate_r_theta();
        Complex[] nthroots = new Complex[n];
        //StdOut.println("r="+r+", theta = "+theta);
        for (int i = 0; i < n; i++) {
            nthroots[i] = convert_to_real_imag(Math.pow(r,1.0/n),(theta+2*Math.PI*i)/n);
        }
        return nthroots;
    }

    public static Complex convert_to_real_imag(double r,double theta){
        return new Complex(r*Math.cos(theta),r*Math.sin(theta));
    }
    private void generate_r_theta(){
        this.r = this.abs();
        this.theta=Math.atan2(this.imag,this.real);
        return;
    }
    public Complex power(int n){
        generate_r_theta();
        return convert_to_real_imag(Math.pow(r,n),theta*n);
    }
    public Complex conjugate(){
        return new Complex(real,-imag);
    }
    public static void main(String[] args){
        Complex z0 = new Complex(1,1);
        Complex z = z0;
        z = z.times(z).plus(z0);
        z = z.times(z).plus(z0);
        StdOut.println(z);
        z0 = new Complex(1,1);
        StdOut.println("z: "+z0);
        int n =5;
        Complex[] nthrootz0 = z0.nth_root(n);
        for (Complex a:nthrootz0) {
            StdOut.println("nth roots: "+a);
            StdOut.println("nth power of root: "+a.power(n));
            StdOut.println("nth power of root_recursively: "+a.power_recursive(n));
        }
    }
}
