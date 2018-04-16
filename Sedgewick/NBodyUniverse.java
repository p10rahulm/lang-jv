/*
 java NBodyUniverse 25000 < data/4body.txt
 java NBodyUniverse 20000 < data/3body.txt
 java NBodyUniverse 2000 < data/2body.txt
 java NBodyUniverse 25000 < data/2bodytiny.txt


*/


public class NBodyUniverse {
        private final int n;                            // number of bodies
        private final GravitationalBody[] bodies;       // array of n bodies

        // read universe from standard input
        public NBodyUniverse() {

            // number of bodies
            n = StdIn.readInt();

            // the set scale for drawing on screen
            double radius = StdIn.readDouble();
            StdDraw.setXscale(-radius, +radius);
            StdDraw.setYscale(-radius, +radius);

            // read in the n bodies
            bodies = new GravitationalBody[n];
            for (int i = 0; i < n; i++) {
                double rx   = StdIn.readDouble();
                double ry   = StdIn.readDouble();
                double vx   = StdIn.readDouble();
                double vy   = StdIn.readDouble();
                double mass = StdIn.readDouble();
                double[] position = { rx, ry };
                double[] velocity = { vx, vy };
                Vector r = new Vector(position);
                Vector v = new Vector(velocity);
                bodies[i] = new GravitationalBody(r, v, mass);
            }
        }

        // increment time by dt units, assume forces are constant in given interval
        public void increaseTime(double dt) {

            // initialize the forces to zero
            Vector[] f = new Vector[n];
            for (int i = 0; i < n; i++) {
                f[i] = new Vector(new double[2]);
            }

            // compute the forces
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
                    }
                }
            }

            // move the bodies
            for (int i = 0; i < n; i++) {
                bodies[i].move(f[i], dt);
            }
        }

        // draw the n bodies
        public void draw() {
            for (int i = 0; i < n; i++) {
                bodies[i].draw();
            }
        }


        // client to simulate a universe
        public static void main(String[] args) {
            NBodyUniverse newton = new NBodyUniverse();
            double dt = Double.parseDouble(args[0]);
            StdDraw.enableDoubleBuffering();
            while (true) {
                StdDraw.clear();
                newton.increaseTime(dt);
                newton.draw();
                StdDraw.show();
                StdDraw.pause(10);
            }
        }

}
