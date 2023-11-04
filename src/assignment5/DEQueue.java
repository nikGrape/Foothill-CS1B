package assignment5;

public class DEQueue
{
    private Node2 head; // first and oldest
    private Node2 tail; // last and most resent

    public DEQueue()
    {
        head = null;
        tail = null;
    }

    /**
     * similar to add() of Queue
     * @param newNode Node2 with next and prev
     */
    public void addToBack(Node2 newNode)
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
            newNode.prev = tail;
        }
        tail = newNode;
    }

    /**
     * similar to remove() of Queue; Removes the oldest element of the Queue
     * @return Node2 with next and prev
     * @throws QueueEmptyException
     */
    public Node2 removeFromFront() throws QueueEmptyException
    {
        if (head == null) {
            throw new QueueEmptyException();
        }
        Node2 temp = head;
        head = (Node2) head.next;
        temp.next = null;
        temp.prev = null;

        return temp;
    }

    /**
     * similar to push() of Stack
     * @param newNode Node2 with next and prev
     */
    public void addToFront(Node2 newNode)
    {
        if (newNode == null)
        {
            return;
        }
        if (head != null)
        {
            head.prev = newNode;
            newNode.next = head;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    /**
     * Removes the youngest element of the Queue
     * @return Node2 with next and prev
     * @throws QueueEmptyException
     */
    public Node2 removeFromBack() throws QueueEmptyException
    {
        if (tail == null || head == null) {
            throw new QueueEmptyException();
        }
        Node2 temp = tail;
        tail = (Node2)temp.prev;

        if (tail != null)
        {
            tail.next = null;
        } else {
            head = null;
        }

        temp.next = null;
        temp.prev = null;

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
