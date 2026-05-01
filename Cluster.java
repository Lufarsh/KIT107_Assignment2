/**
 * Cluster.java
 * 
 * KIT107 Assignment 2 -- Cluster Implementation
 * 
 * @author <<Mohammad Arshath Kalilur Rahuman>>
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
        if (isEmpty())
        {
            return null;
        }

        Node current = firstPlayer;
        Player best = null;
        int max = Integer.MIN_VALUE;

        while (current != null)
        {
            Player p = (Player) current.getData();
            int value = 0;

            switch (x)
            {
                case 'g': value = p.getGoals(); break;
                case 'd': value = p.getDisposals(); break;
                case 'c': value = p.getClangers(); break;
                case 'a': value = p.getFreesAgainst(); break;
                case 'm': value = p.getGames(); break;
            }

            if (value >= max)
            {
                max = value;
                best = p;
            }

            current = current.getNext();
        }

        return best;
    }

    public String summary()
    {
        if (isEmpty())
        {
            return "";
        }

        Node current = firstPlayer;

        int disposals = 0, marks = 0, kicks = 0, handballs = 0, hitouts = 0;
        int tackles = 0, clangers = 0, freesFor = 0, freesAgainst = 0;
        int goals = 0, behinds = 0;

        while (current != null)
        {
            Player p = (Player) current.getData();

            disposals += p.getDisposals();
            marks += p.getMarks();
            kicks += p.getKicks();
            handballs += p.getHandballs();
            hitouts += p.getHitouts();
            tackles += p.getTackles();
            clangers += p.getClangers();
            freesFor += p.getFreesFor();
            freesAgainst += p.getFreesAgainst();
            goals += p.getGoals();
            behinds += p.getBehinds();

            current = current.getNext();
        }

        int totalPoints = goals * 6 + behinds;

        return "There were: " + disposals + " disposals (Marks: " + marks +
                "; kicks: " + kicks + "; handballs: " + handballs +
                "; hitouts: " + hitouts + ")\n" +
                "Tackles: " + tackles + " Clangers: " + clangers + "\n" +
                "Free kicks: " + freesFor + " for and " + freesAgainst + " against\n" +
                "Scoring: " + goals + "." + behinds +
                " for a total of " + totalPoints + " points.";
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