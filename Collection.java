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

    Node current = firstTeam;

    while (current != null)
    {
        Cluster c = (Cluster) current.getData();
        Player p = c.getFirstPlayer();

        String team = p.getTeam();
        int count = c.countPlayers();

        System.out.print(" " + team + " | ");

        for (int i = 0; i < count; i++)
        {
            System.out.print("*");
        }

        System.out.println(" " + count);

        current = current.getNext();
    }
}
public String most(char x)
{
    if (isEmpty())
    {
        return "No data!";
    }

    Node current = firstTeam;
    Player best = null;

    while (current != null)
    {
        Cluster c = (Cluster) current.getData();
        Player p = c.most(x);

        if (p != null)
        {
            if (best == null)
            {
                best = p;
            }
            else
            {
                int val1 = 0;
                int val2 = 0;

                switch (x)
                {
                    case 'g': val1 = p.getGoals(); val2 = best.getGoals(); break;
                    case 'd': val1 = p.getDisposals(); val2 = best.getDisposals(); break;
                    case 'c': val1 = p.getClangers(); val2 = best.getClangers(); break;
                    case 'a': val1 = p.getFreesAgainst(); val2 = best.getFreesAgainst(); break;
                    case 'm': val1 = p.getGames(); val2 = best.getGames(); break;
                }

                if (val1 >= val2)
                {
                    best = p;
                }
            }
        }

        current = current.getNext();
    }

    if (best == null)
    {
        return "No data!";
    }

    return best.toString();
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