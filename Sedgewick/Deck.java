public class Deck {
    public static void main(String[] args){
        System.out.println(RandomCard());
        System.out.println(selectrandom());
        String[] deck = shuffledDeck();
        for (String aDeck : deck) {
            System.out.println(aDeck);
        }
        String[][] dealt_hands = deal(10);
        MatrixOps.print_string_matrix(dealt_hands);
    }
    public static String[][] deal(int number_of_hands){
        if(number_of_hands>10){
            System.out.println("Too many hands");
            String[][] a = new String[][] {{}};
            return a;
        }
        String[] deck = shuffledDeck();
        String[][] output = new String[number_of_hands][5];
        for(int i =0;i<number_of_hands*5;i++){
            output[i/5][i%5] = deck[i];
        }
        return output;
    }
    public static String selectrandom(){
        String[] suit = {"Clubs","Diamonds","Hearts","Spades"};
        String[] rank = {"1","2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};
        int i = (int) (Math.random()*suit.length);
        int j = (int) (Math.random()*rank.length);
        String out = "";
        out += rank[j] + " of " + suit[i];
        return out;
    }
    public static String RandomCard(){
        String[] suit = {"Clubs","Diamonds","Hearts","Spades"};
        String[] rank = {"1","2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};
        String[] deck = new String[suit.length*rank.length];
        for(int i =0;i<suit.length;i++){
            for(int j =0;j<rank.length;j++){
                deck[i*rank.length+j] = rank[j] + " of " + suit[i];
            }
        }
        int i = (int) (Math.random()*suit.length*rank.length);

        return deck[i];
    }
    public static String[] shuffledDeck(){
        String[] suit = {"Clubs","Diamonds","Hearts","Spades"};
        String[] rank = {"1","2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"};
        String[] deck = new String[suit.length*rank.length];
        for(int i =0;i<suit.length;i++){
            for(int j =0;j<rank.length;j++){
                deck[i*rank.length+j] = rank[j] + " of " + suit[i];
            }
        }
        int pickrandom;
        String temp;
        for(int i =0;i<deck.length;i++){
            pickrandom = (int)(Math.random()*(deck.length-i));
            temp = deck[i];
            deck[i] = deck[i+pickrandom];
            deck[i+pickrandom] = temp;
        }
        return deck;
    }
}
