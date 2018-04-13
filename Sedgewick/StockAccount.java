//java StockAccount data/AmericanStocks.txt
public class StockAccount {
    private final String name;
    private double cash;
    private int numshares;
    private int[] shares;
    private String[] share_names;

    public StockAccount(String AccountHolderName,double cash_start,String[] share_names_initial,int[] shares_initial){
        name = AccountHolderName;
        cash = cash_start;
        share_names = share_names_initial;
        shares = shares_initial;
        numshares = share_names.length;
    }
    public static StockAccount readintializerfile(String filename){
        In sharefile = new In(filename);
        String name = sharefile.readLine();
        double cash = sharefile.readDouble();
        int numshares = sharefile.readInt();
        String[] sharenames = new String[numshares];
        int[] shares = new int[numshares];
        for (int i = 0; i < numshares; i++) {
            shares[i] = sharefile.readInt();
            sharenames[i] = sharefile.readString();
        }
        StockAccount acct = new StockAccount(name,cash,sharenames,shares);
        return acct;
    }
    public static void main(String[] args){
        String share_filename = args[0];
        StockAccount acct = readintializerfile(share_filename);
        acct.printReport();
    }
    public void printReport(){
        for (int i = 0; i < 39; i++) {StdOut.printf("%s","-");}
        StdOut.printf("\n%21s%6s%9s\n"," ","Name: ",name);
        StdOut.printf("%23s%6s$%9.2f\n\n"," ","Cash: ",cash);
        double total = cash;
        for (int i = 0; i < numshares; i++) {
            int amount = shares[i];
            double p = GetStockPrice.get_price(share_names[i]);
            StdOut.printf("%7d %7s $%9.2f $%11.2f\n",amount,share_names[i],p,p*amount);
            total+=amount*p;
        }
        StdOut.printf("\n%22s%7s$%9.2f\n"," ","Total: ",total);
        for (int i = 0; i < 39; i++) {StdOut.printf("%s","-");}
    }
    public double getCash() {
        return cash;
    }
}
