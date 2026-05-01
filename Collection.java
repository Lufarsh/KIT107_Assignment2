/**
 * Collection.java
 * 
 * KIT107 Assignment 2 -- Collection Implementation
 * 
 * @author <Mohammad Arshath Kalilur Rahuman 106207>
 * @version	<<date of completion>>
 */


public class Collection implements CollectionInterface
{
    protected Node firstTeam;

    public Collection()
    {
        firstTeam = null;
    }

    public boolean isEmpty()
    {
        return firstTeam == null;
    }

    public void addPlayerToCollection(Player p)
    {
        // later
    }

    public void showPlayerHistogram()
    {
        if (isEmpty())
        {
            System.out.println("Count of players per team:");
            System.out.println("No data!");
            return;
        }

        System.out.println("Count of players per team:");
    }

    public String most(char x)
    {
        return "No data!";
    }

    public void summarise(String t)
    {
        if (isEmpty())
        {
            System.out.println("No data!");
            return;
        }

        System.out.println(t + "'s performance in can be summarised as follows:");
        System.out.println("No data!");
    }

    public String toString()
    {
        String result = "";
        Node current = firstTeam;

        while (current != null)
        {
            result += current.getData().toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
}