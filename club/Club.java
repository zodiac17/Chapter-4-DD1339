import java.util.ArrayList;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    private ArrayList<Membership> members;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        members = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
           members.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        if(members.size() > 0) {
            return members.size();
        }
        else {
            return 0;
        }
    }
    
    /**
     * Determine the number of members who joined in the
     * given month.
     * @param month The month we are interested in.
     * @return The number of members who joined in that month.
    */
    public int joinedInMonth(int month)
    {
        
        int count = 0;
        
        if(month > 0  && month < 13 && members.size() > 0){
            
            for(int i = 0; i < members.size(); i++ ){
                if(members.get(i).getMonth() == month){
                    count++;
                }
            }
            
            return count;
        }
        else {
            
            System.out.println("Make sure month is between 1 and 12 and members are available.");
            
            return 0;
        }
        
    }
    /**
     * Remove from the club's collection all members who
     * joined in the given month, and return them stored
     * in a separate collection object.
     * @param month The month of the membership.
     * @param year The year of the membership.
     * @return The members who joined in the given month and year.
    */
    public ArrayList<Membership> purge(int month, int year){
        if(month > 0  && month < 13 && members.size() > 0){
            
            for(int i = 0; i < members.size(); i++ ){
                if(members.get(i).getMonth() == month && members.get(i).getYear() == year){
                    members.remove(i);
                }
            }
            
            return members;
            
        }
        else {
            
            System.out.println("Make sure month is between 1 and 12 and members are available.");
            
            return members;

        }
    }
    
}
