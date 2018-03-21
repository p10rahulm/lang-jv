import java.security.cert.TrustAnchor;

public class SelfAvoidingWalk {
    public static void main(String[] args){
        //We assume it's a square of odd integer side-length (2*distancetoside+1)
        int distancetoedge = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int deadends=0,outsides=0;
        for(int i =0;i<trials;i++) {
            boolean[][] walked = new boolean[2 * distancetoedge + 1][2 * distancetoedge + 1];
            int currentx = distancetoedge, currenty = distancetoedge;walked[currentx][currenty] = true;
            boolean atdeadend = false, outside = false, atedge;
            int move_rand;
            while (!atdeadend && !outside) {

                move_rand = (int) (Math.random() * 4);
                if (move_rand == 0 && currentx == 0 || move_rand == 1 && currenty == 0 || move_rand == 2 && currentx == 2 * distancetoedge || move_rand == 3 && currenty == 2 * distancetoedge) {
                    outside = true;
                    break;
                }
                if (move_rand == 0 && walked[currentx - 1][currenty] || move_rand == 1 && walked[currentx][currenty - 1] ||
                        move_rand == 2 && walked[currentx + 1][currenty] || move_rand == 3 && walked[currentx][currenty + 1]) {
                    //invalidmove;
                    continue;
                }
                if (move_rand == 0) currentx -= 1;
                if (move_rand == 1) currenty -= 1;
                if (move_rand == 2) currentx += 1;
                if (move_rand == 3) currenty += 1;
                walked[currentx][currenty] = true;
                atedge = ((currentx == 0) || (currentx == 2 * distancetoedge) || (currenty == 0) || (currenty == 2 * distancetoedge));
                if (!atedge) {
                    if (walked[currentx - 1][currenty] && walked[currentx][currenty - 1] && walked[currentx + 1][currenty] && walked[currentx][currenty + 1]){
                        atdeadend = true;
                        break;
                    }
                }
                //System.out.println("move_rand "+move_rand+" atedge "+atedge+" atdeadend "+atdeadend+" currentx "+currentx+" currenty "+currenty);
            }
            if (atdeadend) deadends++;
            if (outside) outsides++;
        }
        System.out.println("Got out in "+outsides+" of "+trials+" trials.");


    }
}
