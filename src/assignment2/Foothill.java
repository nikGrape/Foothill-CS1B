package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <h1>Assignment 1</h1>
 * The Card Game program implements a simple version card game application.
 *
 * @author Nikolai Vinogradov
 */
public class Foothill
{
    public static void main(String[] args)
    {
        System.out.println("--------* PHASE 2 *---------\n");

        Deck deck = new Deck();
        Hand[] hands;
        int input = readUserInput();

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

/* ------------------- Paste of run from console window --------------------
--------* PHASE 2 *---------

How many hands? (1 - 10, please): 6
Here are our hands, from UNSHUFFLED deck:
Hand =  ( X of spades, 9 of spades, 3 of spades, J of hearts, 5 of hearts, K of diamonds, 7 of diamonds, X of clubs, 9 of clubs, 3 of clubs )
Hand =  ( A of spades, 8 of spades, 2 of spades, T of hearts, 4 of hearts, Q of diamonds, 6 of diamonds, A of clubs, 8 of clubs, 2 of clubs )
Hand =  ( K of spades, 7 of spades, X of hearts, 9 of hearts, 3 of hearts, J of diamonds, 5 of diamonds, K of clubs, 7 of clubs )
Hand =  ( Q of spades, 6 of spades, A of hearts, 8 of hearts, 2 of hearts, T of diamonds, 4 of diamonds, Q of clubs, 6 of clubs )
Hand =  ( J of spades, 5 of spades, K of hearts, 7 of hearts, X of diamonds, 9 of diamonds, 3 of diamonds, J of clubs, 5 of clubs )
Hand =  ( T of spades, 4 of spades, Q of hearts, 6 of hearts, A of diamonds, 8 of diamonds, 2 of diamonds, T of clubs, 4 of clubs )

Here are our hands, from SHUFFLED deck:
Hand =  ( 9 of diamonds, K of spades, 7 of spades, A of hearts, A of diamonds, 4 of diamonds, 6 of hearts, K of diamonds, 3 of hearts, 7 of clubs )
Hand =  ( 8 of diamonds, K of hearts, Q of spades, A of clubs, X of diamonds, Q of clubs, 8 of hearts, T of diamonds, X of hearts, 5 of spades )
Hand =  ( J of clubs, J of diamonds, 6 of diamonds, 8 of spades, 3 of clubs, 3 of diamonds, 8 of clubs, 2 of spades, X of clubs )
Hand =  ( 5 of clubs, A of spades, 4 of hearts, T of hearts, 2 of clubs, J of spades, 7 of hearts, 5 of diamonds, 4 of clubs )
Hand =  ( T of clubs, 9 of clubs, Q of diamonds, 6 of clubs, 7 of diamonds, X of spades, K of clubs, Q of hearts, T of spades )
Hand =  ( 4 of spades, 3 of spades, 2 of diamonds, 5 of hearts, 6 of spades, 9 of hearts, 9 of spades, J of hearts, 2 of hearts )

Process finished with exit code 0

-------------------------------------------------------------- */