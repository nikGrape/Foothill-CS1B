package stack;

public class Stack
{
    private StackNode top;

    public Stack()
    {
        top = null;
    }

    public void push(StackNode newNode)
    {
        if (newNode == null)
            return;
        newNode.next = top;
        top = newNode;
    }

    public StackNode pop()
    {
        StackNode temp;

        temp = top;
        if (top != null)
        {
            top = top.next;
            temp.next = null;
        }
        return temp;
    }

    @Override public String toString()
    {
        StringBuilder output = new StringBuilder();
        StackNode p;

        for( p = top; p != null; p = p.next )
            output.append(p);

        return output.toString();
    }
}