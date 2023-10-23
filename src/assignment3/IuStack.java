package assignment3;

public class IuStack extends Stack
{
    public static final InternetUser BAD_USER = new InternetUser("", "");

    public void pushInternetUser(InternetUser x)
    {
        IuNode fp = new IuNode(x);
        super.push(fp);
    }

    public InternetUser popInternetUser()
    {
        IuNode fp = (IuNode) pop();
        if (fp == null)
            return BAD_USER;
        else
            return fp.getData();
    }
}

class IuNode extends StackNode
{
    private InternetUser data;

    public IuNode(InternetUser x)
    {
        super();
        if (x == null)
            data = new InternetUser("", "");
        else
            data = x;
    }

    public InternetUser getData()
    {
        return data;
    }

    @Override public String toString()
    {
        return (data == null) ? "[0.0.0.0]" : "[" + data + "]";
    }
}

class Stack
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

        for (p = top; p != null; p = p.next)
            output.append(p);

        return output.toString();
    }

    public void showStack()
    {
        System.out.println(this);
    }
}

class StackNode
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

    public void show()
    {
        System.out.println(this);
    }
}




