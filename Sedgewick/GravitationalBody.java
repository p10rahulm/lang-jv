public class GravitationalBody {
    private Vector position,velocity;
    private final double mass;

    public GravitationalBody(Vector position, Vector velocity, double mass) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
    }
    public void move(Vector force, double dt){
        Vector acceleration = force.times(1/mass);
        velocity = velocity.plus(acceleration.times(dt));
        position = position.plus(velocity.times(dt));
    }
    public Vector forceFrom(GravitationalBody b){
        GravitationalBody a = this;
        double G = 6.61e-11;
        Vector distance_vector = a.position.minus(b.position);
        double distance = distance_vector.magnitude();
        double Force = (G*a.mass*b.mass)/(distance*distance);
        return distance_vector.direction().times(Force);
    }
    public void draw(){
        StdDraw.setPenRadius(0.025);
        StdDraw.point(position.cartesian(0),position.cartesian(1));
    }
}
