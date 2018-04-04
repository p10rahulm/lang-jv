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
        System.out.println(move(n,true,move_positions)[0]);
    }
    public static int[] move(int disc_number, boolean direction_right, int[] move_positions){

        if(disc_number==0){return move_positions;}
        move_positions = move(disc_number-1,!direction_right,move_positions);
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
        move_positions =move(disc_number-1,!direction_right,move_positions);
        return move_positions;
    }
    public static void draw_current_pos(int[] move_positions){

    }
}
