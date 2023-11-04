package assignment5;

public class CardNode extends Node
{
    private Card data;

    // constructor
    public CardNode(Card x)
    {
        super();  // constructor call to base class
        data = x;
    }

    // accessor
    public Card getData()
    {
        return data;
    }

    // overriding show()

    @Override public String toString()
    {
        return data.toString();
    }
}
