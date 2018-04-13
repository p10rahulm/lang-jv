public class Quaternion {
    public final double a0,a1,a2,a3;
    public Quaternion(double a0, double a1, double a2, double a3) {
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }
    public double magnitude(){
        return Math.sqrt(a0*a0+a1*a1+a2*a2+a3*a3);
    }
    public Quaternion conjugate(){
        return new Quaternion(a0,-a1,-a2,-a3);
    }
    public Quaternion inverse(){
        double magn = this.magnitude();
        return new Quaternion(this.a0/magn,this.a1/magn,this.a2/magn,this.a3/magn);
    }
    public Quaternion sum(Quaternion  quat){
        return new Quaternion(this.a0+quat.a0,this.a1+quat.a1,this.a2+quat.a2,this.a3+quat.a3);
    }
    public Quaternion minus(Quaternion  quat){
        return new Quaternion(this.a0-quat.a0,this.a1-quat.a1,this.a2-quat.a2,this.a3-quat.a3);
    }
    public Quaternion product(Quaternion  quat){
        // given wrongly in text. Note line 2
        //https://stackoverflow.com/questions/19956555/how-to-multiply-two-quaternions

        return new Quaternion(a0*quat.a0-a1*quat.a1-a2*quat.a2-a3*quat.a3,
                a0*quat.a1+a1*quat.a0+a2*quat.a3-a3*quat.a2,
                a0*quat.a2-a1*quat.a3+a2*quat.a0+a3*quat.a2,
                a0*quat.a3+a1*quat.a2-a2*quat.a1+a3*quat.a0);
    }
    public Quaternion divide(Quaternion  quat){
        return this.product(quat.inverse());
    }
    public String toString(){
        return("(a0,a1,a2,a3) = ("+a0+","+a1+","+a2+","+a3+")\n");
    }
    public static void main(String[] args){
        Quaternion a  = new Quaternion(1,2,3,4);
        Quaternion b  = new Quaternion(1,-1,2,-2);
        StdOut.println(a);
        StdOut.println(a.magnitude());
        StdOut.println(a.conjugate());
        StdOut.println(a.sum(b));
        StdOut.println(a.minus(b));
        StdOut.println(a.product(b));
        StdOut.println(a.divide(b));
    }


}
