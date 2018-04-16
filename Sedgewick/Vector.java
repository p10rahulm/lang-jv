public class Vector {
    private final double[] coordinates;
    public Vector(double[] input){
        coordinates = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            coordinates[i] = input[i];
        }
    }

    public Vector plus(Vector b){
        if(b.coordinates.length!=coordinates.length){
            throw new RuntimeException("Vector lengths are not the same");
        }
        double[] aplusb =   new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            aplusb[i] = coordinates[i]+b.coordinates[i];
        }
        return new Vector(aplusb);
    }
    public Vector times(double constant){
        double[] aplusb =   new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            aplusb[i] = coordinates[i]*constant;
        }
        return new Vector(aplusb);
    }
    public Vector minus(Vector b){
        if(b.coordinates.length!=coordinates.length){
            throw new RuntimeException("Vector lengths are not the same");
        }
        double[] aplusb =   new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            aplusb[i] = coordinates[i]-b.coordinates[i];
        }
        return new Vector(aplusb);
    }
    public Vector divides(double constant){
        double[] aplusb =   new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            aplusb[i] = coordinates[i]/constant;
        }
        return new Vector(aplusb);
    }
    public double dot(Vector b){
        if(b.coordinates.length!=coordinates.length){
            throw new RuntimeException("Vector lengths are not the same");
        }
        double sum =0;
        for (int i = 0; i < coordinates.length; i++) {
            sum+=coordinates[i]*b.coordinates[i];
        }
        return sum;
    }
    public double magnitude(){
        return Math.sqrt(this.dot(this));
    }
    public double cartesian(int dim){
        if(dim>coordinates.length||dim<0){
            throw new RuntimeException("check dimension required of vector");
        }
        return coordinates[dim];
    }
    public Vector direction(){
        return this.times(1/this.magnitude());
    }
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < coordinates.length; i++) {
            s.append(coordinates[i]+",");
        }
        s.replace(s.length()-1,s.length(),"]");
        return s.toString();
    }
}
