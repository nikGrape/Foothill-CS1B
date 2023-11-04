package assignment5;

public class CardQueue extends Queue
{
    public void addCard(Card x)
    {
        if (x == null)
            return;    // could throw an exception when we learn how

        CardNode fp = new CardNode(x);
        super.add(fp);
    }

    public Card removeCard() throws QueueEmptyException
    {
        CardNode fp = (CardNode)remove();
        if (fp == null)
            throw new QueueEmptyException();
        else
            return fp.getData();
    }
}
