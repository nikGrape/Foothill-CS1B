package assignment4;

/**
 * @author Baba Kofi Weusijana
 */
public interface CardInterface
{
    /**
     *
     */
    public enum Suit
    {
        clubs, diamonds, hearts, spades
    }

    /**
     *
     */
    public static final char[] CARD_VALUES =
            { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A', 'X' };
    /**
     *
     */
    public static final int NUM_VALUES = CARD_VALUES.length;
    /**
     *
     */
    public static final int NUM_SUITS = Suit.values().length;;

    /**
     * @param card
     * @return true if the card is internally equal to this card
     */
    public boolean equals(Card card);

    /**
     * @return This card's Suit.
     */
    public Suit getSuit();

    /**
     * @return This card's value as a char.
     */
    public char getValue();

    /**
     * @return true if this card's error flag is true because something is wrong
     *         with its internal state.
     */
    public boolean isErrorFlag();

    /**
     * @param value
     * @param suit
     * @return true if setting the char value and Suit were successful.
     */
    public boolean set(char value, Suit suit);

    public String toString();
}

