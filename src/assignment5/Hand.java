package assignment5;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * one object of this class represents the cards one user has at the moment
 *
 * @author Nikolai Vinogradov
 * @version 1.0
 */
public class Hand
{
    public static final int MAX_CARDS = 50;
    private Card[] myCards;
    private int numCards;


    public Hand()
    {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    public boolean takeCard(Card card)
    {
        if (numCards >= MAX_CARDS) return false;
        if (!card.isErrorFlag())
        {
            myCards[numCards] = new Card(card);
            numCards += 1;
        }

        return true;
    }

    public Card playCard()
    {
        if (numCards == 0) return new Card('Z', null);
        return myCards[--numCards];
    }

    public void resetHand()
    {
        numCards = 0;
    }

    public int getNumCards()
    {
        return numCards;
    }

    @Override
    public String toString()
    {
        return "Hand =  ( " + Arrays
                .stream(myCards)
                .limit(numCards)
                .map(Card::toString)
                .collect(Collectors.joining(", ")) + " )";
    }

    public Card inspectCard(int k)
    {
        if (k < 0 || k >= numCards)
            return new Card('Z', null);

        return myCards[k];
    }
}
