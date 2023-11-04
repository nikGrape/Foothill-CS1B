package assignment5;

import stack.StackNode;

public class Node
{
    protected Node next;

    public Node()
    {
        next = null;
    }

    @Override public String toString()
    {
        return "(generic node)";
    }
}
