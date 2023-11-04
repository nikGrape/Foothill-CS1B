package assignment5;

public class CardNode2 extends Node2
{
    private Card data;

    // constructor
    public CardNode2(Card x)
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
