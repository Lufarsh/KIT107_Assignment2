/**
 * Cluster.java
 * 
 * KIT107 Assignment 2 -- Cluster Implementation
 * 
 * @author <<Arshath>>
 * @version	<<date of completion>>
 */


public class Cluster implements ClusterInterface
{
    protected Node firstPlayer;

    public Cluster()
    {
        firstPlayer = null;
    }

    public boolean isEmpty()
    {
        return firstPlayer == null;
    }

    public void addPlayerToCluster(Player p)
    {
        Node newNode = new Node(p);

        if (isEmpty())
        {
            firstPlayer = newNode;
            return;
        }

        Node current = firstPlayer;
        Node previous = null;

        while (current != null)
        {
            Player currentPlayer = (Player) current.getData();

            int cmp = p.getName().compareTo(currentPlayer.getName());

            if (cmp == 0)
            {
                currentPlayer.update(p);
                return;
            }

            if (cmp < 0)
            {
                break;
            }

            previous = current;
            current = current.getNext();
        }

        if (previous == null)
        {
            newNode.setNext(firstPlayer);
            firstPlayer = newNode;
        }
        else
        {
            newNode.setNext(current);
            previous.setNext(newNode);
        }
    }

    public Player getFirstPlayer()
    {
        if (isEmpty())
        {
            return null;
        }
        return (Player) firstPlayer.getData();
    }

    public int countPlayers()
    {
        int count = 0;
        Node current = firstPlayer;

        while (current != null)
        {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public Player most(char x)
    {
        return null;
    }

    public String summary()
    {
        return "";
    }

    public String toString()
    {
        String result = "";
        Node current = firstPlayer;

        while (current != null)
        {
            result += current.getData().toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
}