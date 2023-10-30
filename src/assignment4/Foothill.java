package assignment4;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// Imports for the CardTable class
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
// Imports for the GUICard class
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import java.util.Random;

/**
 * @author Micheal Loceff
 * @author Baba Kofi Weusijana
 */
public class Foothill extends Application
{
    private static final boolean DEBUG = false;
    static final double APP_WIDTH = 1024;
    static final double APP_HEIGHT = 768;
    static final int NUM_CARDS_PER_HAND = 7;
    static final int NUM_PLAYERS = 2;
    GUICard[] computerGUICards = new GUICard[NUM_CARDS_PER_HAND];
    GUICard[] humanGUICards = new GUICard[NUM_CARDS_PER_HAND];
    GUICard[] playedCards = new GUICard[NUM_PLAYERS];

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        int k;

        // Establish the root pane for the application
        CardTable myCardTable = new CardTable();

        // EventHandler inner class for human GUICard buttons that react to ActionEvent
        // events
        EventHandler<ActionEvent> humanGUICardEventHandler = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (DEBUG)
                {
                    System.out.println("humanGUICardEventHandler.handle called with ActionEvent:" + actionEvent);
                }
                GUICard button = (GUICard) actionEvent.getSource();
                Parent parent = button.getParent();
                if (DEBUG)
                {
                    System.out.println(button + " is inside " + parent);
                }
                if (parent == myCardTable.getHumanHand())
                {
                    myCardTable.getHumanHand().getChildren().remove(button);
                    myCardTable.getHumanArea().getChildren().add(button);//todo changed to playArea
                }
            }
        };
        // Prepare the deck of 1 pack of cards and shuffle it
        Deck deck = new Deck(1);
        deck.shuffle();

        // Prepare the human player's array of GUICards (bottom region)
        for (k = 0; k < NUM_CARDS_PER_HAND; ++k)
        {
            humanGUICards[k] = new GUICard(deck.dealCard());
            humanGUICards[k].setOnAction(humanGUICardEventHandler);
        }

        // Prepare the computer player's array of GUICards (all card backs, top region)
        for (k = 0; k < NUM_CARDS_PER_HAND; ++k)
        {
            computerGUICards[k] = new GUICard(deck.dealCard());
            computerGUICards[k].setFaceup(false);
        }

        // Prepare the playedCards GUICard array
        for (k = 0; k < NUM_PLAYERS; ++k)
        {
            playedCards[k] = new GUICard(deck.dealCard());
        }

        // Add GUICards to Computer and Human hand areas
        myCardTable.getComputerHand().getChildren().addAll(computerGUICards);
        myCardTable.getHumanHand().getChildren().addAll(humanGUICards);

        // Add playedCards to the play region for the computer and human players
        for (k = 0; k < NUM_PLAYERS; ++k)
        {
            myCardTable.getComputerArea().getChildren().add(playedCards[k]);
            ++k;
            myCardTable.getHumanArea().getChildren().add(playedCards[k]);
        }

        Scene scene = new Scene(myCardTable, APP_WIDTH, APP_HEIGHT);
        stage.setTitle("CS 1B CardTable");
        stage.setWidth(APP_WIDTH);
        stage.setHeight(APP_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        // Show everything to the user
        stage.getScene().getRoot().setStyle("-fx-font-family: serif;");
        stage.show();
    }
}

/**
 * One object of this class represents one playing card
 *
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
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
        set(card.getValue(), card.getSuit());
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
        return value == card.getValue() && errorFlag == card.isErrorFlag() && suit == card.getSuit();
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
 * This class will control the positioning of the panes, layouts, and GUICards
 * of the Foothill application.
 * 
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 */
class CardTable extends VBox
{
    private static final int SCROLLPANES_HEIGHT = 280;
    private static final int SCROLLPANES_WIDTH = 768;
    static final int MAX_CARDS_PER_HAND = 57;
    static final int MAX_PLAYERS = 2; // for now, we only allow 2 person games

    private StackPane computerArea;
    private HBox computerHand;
    private StackPane humanArea;
    private HBox humanHand;
    private HBox playArea;

    // TODO: Your team must write the accessor (getter) and mutator (setter) methods

    public CardTable() {
        computerArea = new StackPane();
        computerHand = new HBox();
        humanArea = new StackPane();
        humanHand = new HBox();
        playArea = new HBox();

        computerArea.getChildren().add(computerHand);
        humanArea.getChildren().add(humanHand);


        TitledPane playingArea = new TitledPane("Playing Area", playArea);
        playingArea.setCollapsible(true);

        getChildren().add(new TitledPane("Computer's Hand", new ScrollPane(computerArea)));
        getChildren().add(playingArea);
        getChildren().add(new TitledPane("Your Hand", new ScrollPane(humanArea)));

        ((TitledPane)getChildren().get(1)).setCollapsible(false);
    }

    public StackPane getComputerArea()
    {
        return computerArea;
    }

    public void setComputerArea(StackPane computerArea)
    {
        this.computerArea = computerArea;
    }

    public HBox getComputerHand()
    {
        return computerHand;
    }

    public void setComputerHand(HBox computerHand)
    {
        this.computerHand = computerHand;
    }

    public StackPane getHumanArea()
    {
        return humanArea;
    }

    public void setHumanArea(StackPane humanArea)
    {
        this.humanArea = humanArea;
    }

    public HBox getHumanHand()
    {
        return humanHand;
    }

    public void setHumanHand(HBox humanHand)
    {
        this.humanHand = humanHand;
    }

    public HBox getPlayArea()
    {
        return playArea;
    }

    public void setPlayArea(HBox playArea)
    {
        this.playArea = playArea;
    }
}

/**
 * one object of this class represents one deck of cards
 *
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 * @version 1.0
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

/**
 *
 * @author Micheal Loceff
 * @author Baba Kofi Weusijana
 * @author Nikolai Vinogradov
 * @author Anurag Sanadi
 */
class GUICard extends Button implements CardInterface
{
    public static final boolean DEBUG = true;
    private static Image[][] cardImages = new Image[Card.NUM_VALUES][Card.NUM_SUITS];
    private static Image backImage;
    private static boolean imagesLoaded = false;

    private boolean faceup = true;
    private Card card;

    /**
     * @param card
     * @return Returns the correct front Image for a valid card. If
     *         card.isErrorFlag() is true then null is returned.
     */
    static public Image getImage(Card card)
    {
        loadCardImages(); // will not load twice, so no worries.
        if (!card.isErrorFlag())
        {
            try
            {
                return cardImages[valueAsInt(card)][suitAsInt(card)];
            } catch (Exception e)
            {
                if (DEBUG)
                {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    static public Image getBackCardImage() {
        return backImage;
    }

    static void loadCardImages() {
        if (imagesLoaded) return;
        String pathToImageFolder = "file:" + System.getProperty("user.dir") + "/images/";
        String imageFileName = "";
        try
        {
            int intSuit, intVal;

            for (intVal = 0; intVal < CardInterface.NUM_VALUES; intVal++)
            {
                for (intSuit = 0; intSuit < CardInterface.NUM_SUITS; intSuit++)
                {
                    // card image files stored in images folder with names like
                    // "AC.gif", "3H.gif","XD.gif", etc.
                    imageFileName = pathToImageFolder + turnIntIntoCardValueChar(intVal)
                            + turnIntIntoCardSuitChar(intSuit) + ".gif";
//                    Image image = new Image(imageFileName);
//                    ImageView imageView = new ImageView();
//                    imageView.setImage(image);
                    cardImages[intVal][intSuit] = new Image(imageFileName);;
                }
            }
            imageFileName = pathToImageFolder + "BK.gif";
            //            ImageView bkImageView = new ImageView();
//            bkImageView.setImage(bkImage);
            backImage = new Image(imageFileName);
            imagesLoaded = true;
        } catch (java.lang.IllegalArgumentException e)
        {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
            System.out.println("imageFileName:" + imageFileName);
            imagesLoaded = false;
        }

    }

    // turns 0 - 13 into 'A', '2', '3', ... 'Q', 'K', 'X'
    static char turnIntIntoCardValueChar(int k)
    {
        if (k < 0 || k > (CardInterface.NUM_VALUES - 1))
            return '?';
        return CardInterface.CARD_VALUES[k];
    }

    // turns 0 - 3 into 'C', 'D', 'H', 'S'
    static char turnIntIntoCardSuitChar(int k)
    {
        if (k < 0 || k > (CardInterface.NUM_SUITS - 1))
            return '?';
        return CardInterface.Suit.values()[k].name().toUpperCase().charAt(0);
    }

    static int valueAsInt(Card card)
    {
        char k = card.getValue();
        for (int i = 0; i < CARD_VALUES.length; i++)
        {
            if (CARD_VALUES[i] == k) return i;
        }
        return 0;
    }

    static int suitAsInt(Card card)
    {
        return card.getSuit().ordinal();
    }

    // TODO: Your team must write all the missing instance variables and methods

    public GUICard(){
        card = new Card();
        setFaceup(!card.isErrorFlag());
    }

    public GUICard(char value, Suit suit)
    {
        card = new Card(value, suit);
        setFaceup(!isErrorFlag());
    }

    public GUICard(Card card)
    {
        this.card = new Card(card);
        setFaceup(!isErrorFlag());
    }

    /**
     * Calls this.setGraphic passing it the correct ImageView depending if faceup is
     * true (using the correct front Image)or false (using the back card Image).
     * 
     * @param faceup is the state of the card being displayed faceup or not
     */
    public void setFaceup(boolean faceup)
    {
        this.faceup = faceup;
        if (this.faceup)
        {
            this.setGraphic(new ImageView(this.getImage()));

        } else
        {
            this.setGraphic(new ImageView(getBackCardImage()));
        }
    }

    public Image getImage() {
        return isFaceup() ? GUICard.getImage(card) : getBackCardImage();
    }

    public boolean isFaceup()
    {
        return faceup;
    }

    @Override public boolean equals(Card card)
    {
        return this.card.equals(card);
    }

    @Override public Suit getSuit()
    {
        return card.getSuit();
    }

    @Override public char getValue()
    {
        return card.getValue();
    }

    @Override public boolean isErrorFlag()
    {
        return card.isErrorFlag();
    }

    @Override public boolean set(char value, Suit suit)
    {
        return card.set(value, suit);
    }
}