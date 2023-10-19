package assignment1;

public class FoothillPhase1
{
    public static void main(String[] args)
    {
        Card card1 = new Card();
        Card card2 = new Card('J', CardInterface.Suit.diamonds);
        Card card3 = new Card('Z', CardInterface.Suit.spades);

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);

        System.out.println();

        card2.set('P', CardInterface.Suit.hearts);
        card3.set('X', CardInterface.Suit.clubs);

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
    }
}


/* ------------------- Paste of run from console window --------

FoothillPhase1:
A of spades
J of diamonds
** invalid **

A of spades
** invalid **
X of clubs

-------------------------------------------------------------- */
