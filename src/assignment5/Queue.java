package assignment5;

public class Queue
{
    private Node head; // first and oldest
    private Node tail; // last and most resent

    public Queue()
    {
        head = null;
        tail = null;
    }

    public void add(Node newNode)
    {
        if (newNode == null)
        {
            return;
        }
        if (head == null)
        {
            head = newNode;
        }
        else if (tail != null)
        {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public Node remove() throws QueueEmptyException
    {
        if (head == null) {
            throw new QueueEmptyException();
        }
        Node temp = head;
        head = head.next;
        temp.next = null;

        return temp;
    }

    @Override public String toString()
    {
        StringBuilder output = new StringBuilder();
        Node p;

        for( p = head; p != null; p = p.next )
        {
            output.append(p);
            output.append("   ");
        }


        return output.toString();
    }
}