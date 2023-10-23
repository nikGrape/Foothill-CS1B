package stack;

public class StackNode
{
    protected StackNode next;

    public StackNode()
    {
        next = null;
    }

    @Override public String toString()
    {
        return " (generic node) ";
    }
}
