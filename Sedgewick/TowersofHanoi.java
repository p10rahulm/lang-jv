// Three stacks: 1,2 and 3. Move all from stack 1 to stack 2. This is done by moving n-1 to stack 3, then moving nth object to stack 2, then moving n-1 to stack 2.
public class TowersofHanoi {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int[] move_positions = new int[n+1];
        // We will use this array for return values.
        // The first value movepositions[0] indicates number of moves so far.
        // Then for each disc from 1 to n, we note the positions.
        // Position of each disc at start is tower 0.
        // Each position can take values 0, 1 or 2
        for (int i = 1; i < n+1; i++) {move_positions[i]=0;}
        boolean animate = true;
        if(animate) {
            StdDraw.setXscale(-0.1, 1.1);
            StdDraw.setXscale(-0.5, 3.5); // three towers
            StdDraw.setYscale(-0.5, move_positions.length - 0.5); // movepositions is 1 over size required as it's first element is the moves so far, so we subtract 0.5
        }
        move(n,true,move_positions,animate);
        System.out.println("Done in "+move_positions[0]+" moves");
    }
    public static int[] move(int disc_number, boolean direction_right, int[] move_positions,boolean animate){
        if(animate){
            StdDraw.clear();
            draw_current_pos(move_positions);
            StdDraw.show(250);
        }
        if(disc_number==0){return move_positions;}
        move_positions = move(disc_number-1,!direction_right,move_positions,true);
        if(direction_right){
            int previous_pos = move_positions[disc_number];
            move_positions[disc_number]=(move_positions[disc_number]+1)%3;
            int current_pos = move_positions[disc_number];
            System.out.println("Disc " + disc_number + " moves from tower "+(previous_pos+1)+" to tower "+(current_pos+1));
        }
        else{
            int previous_pos = move_positions[disc_number];
            move_positions[disc_number]=(move_positions[disc_number]-1+3)%3;//adding three as java doesn't do modulo properly
            int current_pos = move_positions[disc_number];
            System.out.println("Disc " + disc_number + " moves from tower "+(previous_pos+1)+" to tower "+(current_pos+1));
        }
        move_positions[0] +=1;
        move_positions =move(disc_number-1,!direction_right,move_positions,true);
        return move_positions;
    }
    public static void draw_current_pos(int[] move_positions){

        // we set the initial center heights for each tower. For every disc that is filled, we will increase that tower height
        double[] tower_heights = {0.5,0.5,0.5};
        // we will iterate in reverse order
        for (int i = move_positions.length-1; i >0 ; i--) {
            // we will make the squares in increasing colours of gray from rgb all = 50 to 200.
            int color = 200-(i-1)*150/(move_positions.length-1);
            StdDraw.setPenColor(color,color,color);
            double halfwidth = 0.25+0.25*(i-1)/(move_positions.length-1);
            StdDraw.filledRectangle(0.5+move_positions[i],tower_heights[move_positions[i]],halfwidth,0.5);
            tower_heights[move_positions[i]]+=1;
        }

    }
}
