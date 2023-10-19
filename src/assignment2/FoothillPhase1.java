package assignment2;

public class FoothillPhase1 {
    public static void main(String[] args) {
        Deck deck = new Deck(2);

        System.out.println("--------* PHASE 1 *---------\n");
        System.out.println("------------------ *in order* -------------------\n");
        System.out.println("Deck length: " + deck.getNumCards());
        Foothill.printAndDealDeck(deck);

        System.out.println("\n\n------------------ *shuffled* -------------------\n");

        deck.init(2);
        deck.shuffle();
        System.out.println("Deck length: " + deck.getNumCards());
        Foothill.printAndDealDeck(deck);
    }
}


/* ------------------- Paste of run from console window --------
--------* PHASE 1 *---------

------------------ *in order* -------------------

Deck length: 112
X of spades  /  A of spades  /  K of spades  /  Q of spades  /  J of spades  /  T of spades  /
9 of spades  /  8 of spades  /  7 of spades  /  6 of spades  /  5 of spades  /  4 of spades  /
3 of spades  /  2 of spades  /  X of hearts  /  A of hearts  /  K of hearts  /  Q of hearts  /
J of hearts  /  T of hearts  /  9 of hearts  /  8 of hearts  /  7 of hearts  /  6 of hearts  /
5 of hearts  /  4 of hearts  /  3 of hearts  /  2 of hearts  /  X of diamonds  /
A of diamonds  /  K of diamonds  /  Q of diamonds  /  J of diamonds  /  T of diamonds  /
9 of diamonds  /  8 of diamonds  /  7 of diamonds  /  6 of diamonds  /  5 of diamonds  /
4 of diamonds  /  3 of diamonds  /  2 of diamonds  /  X of clubs  /  A of clubs  /  K of clubs  /
Q of clubs  /  J of clubs  /  T of clubs  /  9 of clubs  /  8 of clubs  /  7 of clubs  /
6 of clubs  /  5 of clubs  /  4 of clubs  /  3 of clubs  /  2 of clubs  /  X of spades  /
A of spades  /  K of spades  /  Q of spades  /  J of spades  /  T of spades  /  9 of spades  /
8 of spades  /  7 of spades  /  6 of spades  /  5 of spades  /  4 of spades  /  3 of spades  /
2 of spades  /  X of hearts  /  A of hearts  /  K of hearts  /  Q of hearts  /  J of hearts  /
T of hearts  /  9 of hearts  /  8 of hearts  /  7 of hearts  /  6 of hearts  /  5 of hearts  /
4 of hearts  /  3 of hearts  /  2 of hearts  /  X of diamonds  /  A of diamonds  /
K of diamonds  /  Q of diamonds  /  J of diamonds  /  T of diamonds  /  9 of diamonds  /
8 of diamonds  /  7 of diamonds  /  6 of diamonds  /  5 of diamonds  /  4 of diamonds  /
3 of diamonds  /  2 of diamonds  /  X of clubs  /  A of clubs  /  K of clubs  /  Q of clubs  /
J of clubs  /  T of clubs  /  9 of clubs  /  8 of clubs  /  7 of clubs  /  6 of clubs  /
5 of clubs  /  4 of clubs  /  3 of clubs  /  2 of clubs  /

------------------ *shuffled* -------------------

Deck length: 112
2 of clubs  /  K of clubs  /  8 of clubs  /  5 of hearts  /  X of diamonds  /  J of hearts  /
K of spades  /  5 of hearts  /  A of hearts  /  T of hearts  /  T of clubs  /  3 of spades  /
Q of hearts  /  7 of clubs  /  9 of hearts  /  8 of hearts  /  6 of spades  /  Q of diamonds  /
6 of diamonds  /  T of clubs  /  2 of hearts  /  J of hearts  /  6 of diamonds  /  X of hearts  /
5 of spades  /  A of spades  /  9 of hearts  /  J of spades  /  X of spades  /  3 of clubs  /
8 of spades  /  Q of clubs  /  8 of spades  /  T of spades  /  X of clubs  /  7 of spades  /
6 of spades  /  7 of clubs  /  T of hearts  /  8 of hearts  /  5 of diamonds  /  4 of spades  /
4 of spades  /  3 of hearts  /  J of diamonds  /  K of diamonds  /  5 of diamonds  /
9 of spades  /  9 of clubs  /  Q of spades  /  X of spades  /  Q of clubs  /  A of hearts  /
2 of clubs  /  5 of clubs  /  5 of spades  /  3 of clubs  /  4 of diamonds  /  4 of hearts  /
K of spades  /  9 of diamonds  /  7 of diamonds  /  A of diamonds  /  7 of spades  /
9 of diamonds  /  J of clubs  /  8 of clubs  /  4 of diamonds  /  T of diamonds  /  X of hearts  /
A of diamonds  /  2 of spades  /  T of spades  /  X of diamonds  /  2 of hearts  /  X of clubs  /
K of hearts  /  6 of clubs  /  9 of spades  /  7 of diamonds  /  7 of hearts  /  8 of diamonds  /
J of clubs  /  K of diamonds  /  J of spades  /  3 of diamonds  /  K of clubs  /  Q of hearts  /
3 of hearts  /  6 of hearts  /  A of clubs  /  K of hearts  /  J of diamonds  /  6 of clubs  /
A of clubs  /  2 of diamonds  /  6 of hearts  /  9 of clubs  /  4 of clubs  /  3 of spades  /
Q of spades  /  Q of diamonds  /  A of spades  /  2 of diamonds  /  4 of clubs  /  8 of diamonds  /
T of diamonds  /  3 of diamonds  /  7 of hearts  /  4 of hearts  /  2 of spades  /  5 of clubs  /

-------------------------------------------------------------- */
