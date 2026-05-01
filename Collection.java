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
    if (isEmpty())
    {
        Cluster newCluster = new Cluster();
        newCluster.addPlayerToCluster(p);
        firstTeam = new Node(newCluster);
        return;
    }

    Node current = firstTeam;
    Node previous = null;

    while (current != null)
    {
        Cluster c = (Cluster) current.getData();
        Player first = c.getFirstPlayer();

        int cmp = p.getTeam().compareTo(first.getTeam());

        if (cmp == 0)
        {
            c.addPlayerToCluster(p);
            return;
        }

        if (cmp < 0)
        {
            break;
        }

        previous = current;
        current = current.getNext();
    }

    Cluster newCluster = new Cluster();
    newCluster.addPlayerToCluster(p);
    Node newNode = new Node(newCluster);

    if (previous == null)
    {
        newNode.setNext(firstTeam);
        firstTeam = newNode;
    }
    else
    {
        newNode.setNext(current);
        previous.setNext(newNode);
    }
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