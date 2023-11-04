package assignment5;

/**
 * one object of this class represents one playing card
 *
 * @author Nikolai Vinogradov
 * @version 1.0
 */
public class Card implements CardInterface
{
    private static final char defaultValue = 'A';
    private static final Suit defaultSuit = Suit.spades;
    private char value;
    private Suit suit;
    private boolean errorFlag;

    public Card()
    {
        this.value = defaultValue;
        this.suit = defaultSuit;
        this.errorFlag = false;
    }

    public Card(char value, Suit suit)
    {
        set(value, suit);
    }

    public Card(Card card)
    {
        set(card.value, card.suit);
        this.errorFlag = card.isErrorFlag();
    }

    public Card(char value)
    {
        set(value, defaultSuit);
    }

    public char getValue()
    {
        return value;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public boolean isErrorFlag()
    {
        return errorFlag;
    }

    @Override
    public boolean set(char value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
        return !(errorFlag = !isValid(value, suit));

    }

    @Override
    public boolean equals(Card card)
    {
        if (this == card) return true;
        if (card == null) return false;
        return value == card.value && errorFlag == card.errorFlag && suit == card.suit;
    }

    @Override
    public String toString()
    {
        if (errorFlag) return "-Invalid Card-";
        return value + " of " + suit;
    }

    static boolean isValid(char value, Suit suit)
    {
        for (char cardValue : CARD_VALUES)
        {
            if (cardValue == value)
            {
                return suit != null;
            }
        }
        return false;
    }
}
