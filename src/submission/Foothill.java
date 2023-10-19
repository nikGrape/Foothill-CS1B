package submission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>Assignment 2</h1>
 * The Card Game program implements a simple version of a card game application.
 *
 * @author Nikolai Vinogradov
 * @version 2.0
 */
public class Foothill
{
    public static void main(String[] args)
    {
        Deck deck = new Deck(2);

        System.out.println("********PHASE 1**********\n\n");
        System.out.println("------------------ *in order* -------------------\n");
        System.out.println("Deck length: " + deck.getNumCards());
        printAndDealDeck(deck);

        System.out.println("\n\n------------------ *shuffled* -------------------\n");

        deck.init(2);
        deck.shuffle();
        System.out.println("Deck length: " + deck.getNumCards());
        printAndDealDeck(deck);

        System.out.println("\n\n********PHASE 2**********\n\n");
        Hand[] hands;
        int input = readUserInput();
        deck = new Deck();

        if (input <= 0 || input > 10)
        {
            System.out.println("Invalid Input!");
            return;
        }
        hands = Stream.generate(Hand::new).limit(input).toArray(Hand[]::new);
        dealCardsAmongHands(hands, deck);

        System.out.println("Here are our hands, from UNSHUFFLED deck:");
        printAllHands(hands);

        System.out.println("\nHere are our hands, from SHUFFLED deck:");
        Arrays.stream(hands).forEach(Hand::resetHand);
        deck.init(1);
        deck.shuffle();
        dealCardsAmongHands(hands, deck);
        printAllHands(hands);
    }

    public static void printAndDealDeck(Deck deck)
    {
        Card card;
        while (!(card = deck.dealCard()).isErrorFlag())
        {
            System.out.printf("%s  /  ", card);
        }
    }

    public static void dealCardsAmongHands(Hand[] hands, Deck deck)
    {
        Card card;
        int n = 0;
        while (!(card = deck.dealCard()).isErrorFlag())
        {
            hands[n % hands.length].takeCard(card);
            n++;
        }
    }

    public static void printAllHands(Hand[] hands)
    {
        for (Hand hand : hands)
        {
            System.out.println(hand);
        }
    }

    public static int readUserInput()
    {
        System.out.print("How many hands? (1 - 10, please): ");

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in)))
        {
            return Integer.parseInt(console.readLine());
        } catch (IOException | NumberFormatException exception)
        {
            return -1;
        }
    }
}

/* ------------------- Paste of run from console window --------
********PHASE 1**********

------------------ *in order* -------------------

Deck length: 112
X of spades  /  A of spades  /  K of spades  /  Q of spades  /  J of spades  /  T of spades  /  9 of spades  /
8 of spades  /  7 of spades  /  6 of spades  /  5 of spades  /  4 of spades  /  3 of spades  /  2 of spades  /
X of hearts  /  A of hearts  /  K of hearts  /  Q of hearts  /  J of hearts  /  T of hearts  /  9 of hearts  /
8 of hearts  /  7 of hearts  /  6 of hearts  /  5 of hearts  /  4 of hearts  /  3 of hearts  /  2 of hearts  /
X of diamonds  /  A of diamonds  /  K of diamonds  /  Q of diamonds  /  J of diamonds  /  T of diamonds  /
9 of diamonds  /  8 of diamonds  /  7 of diamonds  /  6 of diamonds  /  5 of diamonds  /  4 of diamonds  /
3 of diamonds  /  2 of diamonds  /  X of clubs  /  A of clubs  /  K of clubs  /  Q of clubs  /  J of clubs  /
T of clubs  /  9 of clubs  /  8 of clubs  /  7 of clubs  /  6 of clubs  /  5 of clubs  /  4 of clubs  /
3 of clubs  /  2 of clubs  /  X of spades  /  A of spades  /  K of spades  /  Q of spades  /  J of spades  /
T of spades  /  9 of spades  /  8 of spades  /  7 of spades  /  6 of spades  /  5 of spades  /  4 of spades  /
3 of spades  /  2 of spades  /  X of hearts  /  A of hearts  /  K of hearts  /  Q of hearts  /  J of hearts  /
T of hearts  /  9 of hearts  /  8 of hearts  /  7 of hearts  /  6 of hearts  /  5 of hearts  /  4 of hearts  /
3 of hearts  /  2 of hearts  /  X of diamonds  /  A of diamonds  /  K of diamonds  /  Q of diamonds  /
J of diamonds  /  T of diamonds  /  9 of diamonds  /  8 of diamonds  /  7 of diamonds  /  6 of diamonds  /
5 of diamonds  /  4 of diamonds  /  3 of diamonds  /  2 of diamonds  /  X of clubs  /  A of clubs  /
K of clubs  /  Q of clubs  /  J of clubs  /  T of clubs  /  9 of clubs  /  8 of clubs  /  7 of clubs  /
6 of clubs  /  5 of clubs  /  4 of clubs  /  3 of clubs  /  2 of clubs  /

------------------ *shuffled* -------------------

Deck length: 112
K of hearts  /  A of spades  /  J of spades  /  X of clubs  /  2 of diamonds  /  X of diamonds  /  8 of spades  /
8 of clubs  /  9 of spades  /  K of spades  /  5 of spades  /  T of clubs  /  2 of hearts  /  9 of hearts  /
4 of clubs  /  2 of hearts  /  X of spades  /  T of spades  /  X of hearts  /  2 of spades  /  A of diamonds  /
2 of clubs  /  8 of hearts  /  7 of clubs  /  3 of diamonds  /  A of clubs  /  7 of hearts  /  5 of hearts  /
K of hearts  /  8 of diamonds  /  7 of spades  /  Q of hearts  /  6 of clubs  /  T of spades  /  Q of diamonds  /
3 of clubs  /  J of diamonds  /  A of hearts  /  9 of clubs  /  5 of clubs  /  K of clubs  /  2 of diamonds  /
J of hearts  /  T of diamonds  /  3 of diamonds  /  6 of hearts  /  Q of hearts  /  4 of hearts  /  4 of spades  /
6 of spades  /  Q of diamonds  /  9 of diamonds  /  4 of diamonds  /  A of hearts  /  X of spades  /  Q of clubs  /
4 of clubs  /  5 of diamonds  /  6 of diamonds  /  9 of diamonds  /  A of spades  /  Q of spades  /  5 of hearts  /
5 of spades  /  3 of clubs  /  8 of spades  /  J of clubs  /  4 of spades  /  3 of spades  /  7 of spades  /
K of spades  /  5 of diamonds  /  2 of clubs  /  8 of hearts  /  J of diamonds  /  9 of clubs  /  6 of spades  /
9 of hearts  /  8 of diamonds  /  9 of spades  /  J of spades  /  3 of hearts  /  J of clubs  /  2 of spades  /
5 of clubs  /  3 of hearts  /  T of clubs  /  6 of hearts  /  8 of clubs  /  7 of diamonds  /  T of hearts  /
X of clubs  /  7 of clubs  /  7 of diamonds  /  6 of diamonds  /  K of clubs  /  3 of spades  /  4 of hearts  /
A of diamonds  /  4 of diamonds  /  X of diamonds  /  T of hearts  /  T of diamonds  /  Q of clubs  /  X of hearts  /
Q of spades  /  6 of clubs  /  K of diamonds  /  7 of hearts  /  J of hearts  /  K of diamonds  /  A of clubs  /

********PHASE 2**********

How many hands? (1 - 10, please): 7
Here are our hands, from UNSHUFFLED deck:
Hand{X of spades, 8 of spades, X of hearts, 8 of hearts, X of diamonds, 8 of diamonds, X of clubs, 8 of clubs}
Hand{A of spades, 7 of spades, A of hearts, 7 of hearts, A of diamonds, 7 of diamonds, A of clubs, 7 of clubs}
Hand{K of spades, 6 of spades, K of hearts, 6 of hearts, K of diamonds, 6 of diamonds, K of clubs, 6 of clubs}
Hand{Q of spades, 5 of spades, Q of hearts, 5 of hearts, Q of diamonds, 5 of diamonds, Q of clubs, 5 of clubs}
Hand{J of spades, 4 of spades, J of hearts, 4 of hearts, J of diamonds, 4 of diamonds, J of clubs, 4 of clubs}
Hand{T of spades, 3 of spades, T of hearts, 3 of hearts, T of diamonds, 3 of diamonds, T of clubs, 3 of clubs}
Hand{9 of spades, 2 of spades, 9 of hearts, 2 of hearts, 9 of diamonds, 2 of diamonds, 9 of clubs, 2 of clubs}

Here are our hands, from SHUFFLED deck:
Hand{7 of diamonds, X of clubs, Q of diamonds, T of diamonds, 3 of spades, K of hearts, 6 of clubs, Q of spades}
Hand{6 of hearts, 5 of spades, K of spades, 8 of hearts, 2 of hearts, 9 of clubs, 8 of spades, 4 of clubs}
Hand{4 of spades, 8 of diamonds, T of hearts, 2 of clubs, 8 of clubs, 5 of clubs, 2 of diamonds, X of spades}
Hand{3 of hearts, 6 of spades, Q of clubs, 9 of spades, T of clubs, 7 of clubs, 4 of hearts, Q of hearts}
Hand{9 of hearts, 2 of spades, 3 of diamonds, A of hearts, 7 of spades, 9 of diamonds, 6 of diamonds, K of clubs}
Hand{J of clubs, J of spades, 5 of hearts, K of diamonds, 4 of diamonds, J of hearts, A of spades, J of diamonds}
Hand{X of diamonds, 5 of diamonds, 3 of clubs, X of hearts, A of clubs, 7 of hearts, A of diamonds, T of spades}

Process finished with exit code 0

 */

class Deck
{
    private static final int MAX_PACKS = 6, NUM_CARDS_PER_PACK = Card.NUM_VALUES * Card.NUM_SUITS, MAX_CARDS_PER_DECK = MAX_PACKS * NUM_CARDS_PER_PACK;
    private static Card[] masterPack;
    private static final Card INVALID_CARD = new Card('Z', null);

    private Card[] cards;
    private int topCard;
    private int numPacks;

    public Deck(int numPacks)
    {
        allocateMasterPack();
        if (init(numPacks))
            this.numPacks = numPacks;
    }

    /**
     * create a Deck with 1 pack
     */
    public Deck()
    {
        this(1);
    }

    private static void allocateMasterPack()
    {
        if (masterPack != null)
            return;

        masterPack = new Card[NUM_CARDS_PER_PACK];

        int i = 0;
        for (CardInterface.Suit suit : CardInterface.Suit.values())
        {
            for (char card : CardInterface.CARD_VALUES)
            {
                masterPack[i++] = new Card(card, suit);
            }
        }
    }

    /**
     * restock the deck to the original full
     * condition in preparation for a fresh deal
     */
    public boolean init(int numPacks)
    {
        if (numPacks > MAX_PACKS)
            return false;

        cards = new Card[numPacks * NUM_CARDS_PER_PACK];
        topCard = 0;

        for (int pack = 0; pack < numPacks; pack++)
        {
            for (Card card : masterPack)
            {
                cards[topCard++] = card;
            }
        }

        return true;
    }

    public boolean init()
    {
        return init(1);
    }

    /**
     * removes the card from the top of the deck ond returns it
     *
     * @return Card
     */
    public Card dealCard()
    {
        if (topCard <= 0)
        {
            return INVALID_CARD;
        }
        return new Card(cards[--topCard]);
    }

    /**
     * re-order the cards in a random fashion
     */
    public void shuffle()
    {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++)
        {
            swap(i, random.nextInt(cards.length));
        }
    }

    private void swap(int i, int j)
    {
        Card tmp = cards[i];
        cards[i] = cards[j];
        cards[j] = tmp;
    }

    public int getNumCards()
    {
        return topCard;
    }

    /**
     * @param k is the index of the card to inspect
     * @return the copy of k-th card
     */
    public Card inspectCard(int k)
    {
        if (k < 0 || k > topCard)
            return INVALID_CARD;

        return new Card(cards[k]);
    }
}

/**
 * @author Baba Kofi Weusijana
 */
interface CardInterface
{
    public enum Suit
    {
        clubs, diamonds, hearts, spades
    }

    public static final char[] CARD_VALUES = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A', 'X' };
    public static final int NUM_VALUES = CARD_VALUES.length;
    public static final int NUM_SUITS = Suit.values().length;
    ;

    public boolean equals(Card card);

    public Suit getSuit();

    public char getValue();

    public boolean isErrorFlag();

    public boolean set(char value, Suit suit);

    public String toString();
}

/**
 * one object of this class represents one playing card
 *
 * @author Nikolai Vinogradov
 * @version 1.0
 */
class Card implements CardInterface
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

    @Override public boolean set(char value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
        return !(errorFlag = !isValid(value, suit));

    }

    @Override public boolean equals(Card card)
    {
        if (this == card)
            return true;
        if (card == null)
            return false;
        return value == card.value && errorFlag == card.errorFlag && suit == card.suit;
    }

    @Override public String toString()
    {
        if (errorFlag)
            return "-Invalid Card-";
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

/**
 * one object of this class represents the cards one user has at the moment
 *
 * @author Nikolai Vinogradov
 * @version 1.0
 */
class Hand
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
        if (numCards >= MAX_CARDS)
            return false;
        if (!card.isErrorFlag())
        {
            myCards[numCards] = new Card(card);
            numCards += 1;
        }

        return true;
    }

    public Card playCard()
    {
        if (numCards == 0)
            return new Card('Z', null);
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

    @Override public String toString()
    {
        return "Hand =  ( " + Arrays.stream(myCards).limit(numCards).map(Card::toString)
                .collect(Collectors.joining(", ")) + " )";
    }

    public Card inspectCard(int k)
    {
        if (k < 0 || k >= numCards)
            return new Card('Z', null);

        return myCards[k];
    }
}


