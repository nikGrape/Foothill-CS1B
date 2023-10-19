package assignment2;

import java.util.Random;

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
        init(numPacks);
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
        if (numPacks > MAX_PACKS || numPacks < 1) //TODO
            return false;

        this.numPacks = numPacks;//todo
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