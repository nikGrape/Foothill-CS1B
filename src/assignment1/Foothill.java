package assignment1;

/**
 * <h1>Assignment 1</h1>
 * The Card Game program implements a simple version card game application.
 *
 * @author Nikolai Vinogradov
 */
public class Foothill {
    public static void main(String[] args) {
        Card card1 = new Card();
        Card card2 = new Card('X', CardInterface.Suit.clubs);
        Card card3 = new Card('J', CardInterface.Suit.diamonds);
        Card card4 = new Card('Q', CardInterface.Suit.hearts);
        Card card5 = new Card('K', CardInterface.Suit.spades);

        Hand hand = new Hand();
        int inspectedCardIndex = 5;

        while (hand.takeCard(card1) &&
                hand.takeCard(card2) &&
                hand.takeCard(card3) &&
                hand.takeCard(card4) &&
                hand.takeCard(card5)) ;

        System.out.println(hand);
        System.out.println();

        System.out.printf("Inspect Card Test (k=%d): %s%n", inspectedCardIndex, hand.inspectCard(inspectedCardIndex));
        System.out.println();

        while (hand.getNumCards() > 0) {
            System.out.println("Playing " + hand.playCard());
        }

        System.out.println();
        System.out.println(hand);

        System.out.println();
        System.out.printf("Inspect Card Test (k=%d): %s%n", inspectedCardIndex, hand.inspectCard(inspectedCardIndex));
    }
}

/* ------------------- Paste of run from console window --------

Hand{A of spades, X of clubs, J of diamonds, Q of hearts, K of spades, A of spades, X of clubs, J of diamonds,
Q of hearts, K of spades, A of spades, X of clubs, J of diamonds, Q of hearts, K of spades, A of spades, X of clubs,
J of diamonds, Q of hearts, K of spades, A of spades, X of clubs, J of diamonds, Q of hearts, K of spades, A of spades,
X of clubs, J of diamonds, Q of hearts, K of spades, A of spades, X of clubs, J of diamonds, Q of hearts, K of spades,
A of spades, X of clubs, J of diamonds, Q of hearts, K of spades, A of spades, X of clubs, J of diamonds, Q of hearts,
K of spades, A of spades, X of clubs, J of diamonds, Q of hearts, K of spades}

Inspect Card Test (k=5): A of spades

Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades
Playing K of spades
Playing Q of hearts
Playing J of diamonds
Playing X of clubs
Playing A of spades

Hand{}

Inspect Card Test (k=5): ** invalid **

-------------------------------------------------------------- */
