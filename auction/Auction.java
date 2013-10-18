import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;
    private Lot selectedLot;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        int i = 0;
        int count = lots.size() - 1;
        
        while(i == 0 && count >= 0){
            if(lots.get(count).getNumber() == lotNumber){
                i = 1;
                selectedLot = lots.get(count);
                System.out.println("Lot " + lotNumber +
                           " found.");
            }
            else {
                selectedLot = null;
            }
            
            count--;
        }
        
        if(selectedLot == null) {
            System.out.println("Lot number: " + lotNumber +
                           " does not exist.");
        }
        
        return selectedLot;
    }
    
    /**
     * Close auction
     */
    public void close(){
        System.out.println("Auction is now closed. Below, the lots sold are shown. Lots with no bids are also shown.");
        for(Lot endedlot : lots){
            if(endedlot.getHighestBid() != null ){
                System.out.println(endedlot.toString());
            } else {
                System.out.println(endedlot.toString() + ", Unsold");
            }
        }
        
        lots.clear();
        nextLotNumber = 1;
    }
    
    /**
     * Get unsold items
     */
    public ArrayList<Lot> getUnsold(){
        System.out.println("Listing unsold lots:");
        
        ArrayList<Lot> unsoldlots = new ArrayList<Lot>();
        
        for(Lot unsoldlot : lots){
            if(unsoldlot.getHighestBid() == null ){
                System.out.println(unsoldlot.toString());
            }
        }
        
        return unsoldlots;
    }
    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
    */
    public Lot removeLot(int number){
        
        
        int i = 0;
        int count = lots.size() - 1;
        
        while(i == 0 && count >= 0){
            if(lots.get(count).getNumber() == number){
                i = 1;
                selectedLot = lots.get(count);
                System.out.println("Lot " + number +
                           " removed.");
            }
            else {
                selectedLot = null;
            }
            
            count--;
        }
        
        if(selectedLot == null) {
            System.out.println("Lot number: " + number +
                           " does not exist.");
        }
        
        lots.remove(lots.indexOf(selectedLot));
        
        return selectedLot;
    }
}
