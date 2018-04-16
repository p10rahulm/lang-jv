
public class Particle {

    public double mass;
    public Vector position, momentum;

    public Particle(double[] position_vector, double[]velocities_vector, double mass){
        this.mass = mass;
        if(velocities_vector.length!=position_vector.length) throw new RuntimeException("The vector sizes of position and momentum do not match");
        this.position = new Vector(position_vector);
        Vector velocities = new Vector(velocities_vector);
        this.momentum = velocities.times(mass);
    }
    public double kinetic_energy(){
        return momentum.dot(momentum)/2/mass;
    }
    public String toString(){
        return "mass = " + mass;
    }
    public static void main(String[] args){
        Particle aa = new Particle(new double[]{0,0,0},new double[]{1,1,1},2);
        StdOut.println(aa.kinetic_energy());
    }

}
