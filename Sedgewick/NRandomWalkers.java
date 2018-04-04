public class NRandomWalkers {
    public static void main(String[] args){
        int size = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int sizesq = size*size;
        int total_steps=0;
        for(int i = 0;i<trials;i++){
            boolean[][] visited = new boolean[size][size];
            int[] currentx = new int[size];
            for(int j=0;j<size;j++){currentx[j]=size/2;}
            int[] currenty = new int[size];
            for(int j=0;j<size;j++){currenty[j]=size/2;}
            int steps=0,numvisited=1,move;
            while(numvisited!=sizesq){
                for(int j =0;j<size;j++){
                    //System.out.println("currentx[j] = "+ currentx[j]+", currenty[j] = "+ currenty[j]);
                    move = (int)(Math.random()*4);
                    //i'm assuming if some zombie random walker is on one size of the grid, they emerge in the other side. JLT.
                    if(move==0)currentx[j]= ((size + currentx[j]-1)%size); // Damn java can't domodulo! so adding size
                    if(move==1)currentx[j]= ((size + currentx[j]+1)%size);
                    if(move==2)currenty[j]= ((size + currenty[j]-1)%size);
                    if(move==3)currenty[j]= ((size + currenty[j]+1)%size);
                    //System.out.println("currentx[j] = "+ currentx[j]+", currenty[j] = "+ currenty[j]+", move = " + move+", ((currentx[j]-1)%size) = "+ ((currentx[j]-1)%size));
                    if(!visited[currentx[j]][currenty[j]]){
                        visited[currentx[j]][currenty[j]] = true;
                        numvisited+=1;
                    }
                }
                steps++;
            }
            total_steps +=steps;
        }
        System.out.println("Average number of moves required to cover all = "+ (double)total_steps/trials);
    }
}
