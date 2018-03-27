public class twenty_questions {
    public static void main(String[] args){
        System.out.println("So here's a game, " +
                "i'll try to guess a number between 0 and 1,000,000 that you think of. " +
                "I'll do this by making some guesses.\nAll you need to do is to answer whether my guess is too high, too low, or exactly right.");

        boolean playagain = true;
        while(playagain){
            int guess;
            int sumsofar =0;
            char passchar;
            for(int i=19;i>=0;i--){
                guess = sumsofar + (int)Math.pow(2,i) ;
                StdOut.printf("(Guess %d) My guess is %d. " +
                        "Please tell me whether it's too high or too low or exact by typing 'h', 'l' or 'e'",(20-i),guess);
                char input = StdIn.readChar();
                passchar =StdIn.readChar();
                while(passchar!='\n'){
                    passchar =StdIn.readChar();
                }
                while(input!='h'&&input!='l'&&input!='e'&&input!='H'&&input!='L'&&input!='E'){
                    StdOut.printf("Please try again.\n");
                    StdOut.printf("My guess is %d. " +
                            "Please tell me whether it's too high or too low or exact by typing 'h', 'l' or 'e'",guess);
                    input = StdIn.readChar();
                    passchar =StdIn.readChar();
                    while(passchar!='\n'){
                        passchar =StdIn.readChar();
                    }
                }


                if(input=='e'||input=='E'){
                    StdOut.println("We won, we won! Your guess was "+guess);
                    break;
                }
                if(input=='l'||input=='L'){
                    sumsofar = guess;
                }
                if(i==0){
                    StdOut.printf("Your guess is %d.\n",sumsofar);
                }

            }
            StdOut.println("We had a terrific time playing. If you did too, would you like to play again?");
            StdOut.println("Press 'y' to play again or 'q' to quit");
            char ch_pa;
            ch_pa = StdIn.readChar();
            passchar =StdIn.readChar();
            while(passchar!='\n'){
                passchar =StdIn.readChar();
            }
            while(ch_pa!='q'&&ch_pa!='Q'&&ch_pa!='y'&&ch_pa!='Y'){
                StdOut.println("Sorry we didnt catch that. Press 'q' to quit or 'y' to play again");
                ch_pa = StdIn.readChar();
                passchar =StdIn.readChar();
                while(passchar!='\n'){
                    passchar =StdIn.readChar();
                }
            }
            if(ch_pa=='q'||ch_pa=='Q'){playagain=false;}
        }

    }

}
