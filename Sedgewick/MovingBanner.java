public class MovingBanner {
    public static void main(String[] args){
        String[] s = args;
        int charl =0;
        for(int i = 0;i<s.length;i++){
            charl +=s[i].length();
        }
        charl +=s.length-1; //For all the spaces between the words
        charl++;            // Let's keep one space at the end
        System.out.println(charl);
        char[] banner = new char[charl];
        int current=0;
        for(int i = 0;i<s.length;i++){
            for(int j =0;j<s[i].length();j++){
                banner[current]=s[i].charAt(j);
                current++;
            }
            banner[current] = ' ';
            current++;
        }
        String banned = new String(banner);
        /* the reason for the char array was that i could do the entire wraparound with partial parts of
           the array. ie half the word on one side and half on the other. Didn't bother, but below works
            without partial wraparounds*/
        int dt = 50; // 50 milliseconds
        for(int i = 0;i<1000;i++) {
            StdDraw.clear();
            StdDraw.text(-0.15+(double)(i%115)/100, 0.5, banned);
            StdDraw.show(dt);
        }
    }
}
