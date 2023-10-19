package assignment2;

import java.util.logging.Logger;

//import javax.annotation.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import mockit.Deencapsulation;

//@Generated(value = "org.junit-tools-1.0.6")
public class DeckTest
{

//  @Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(DeckTest.class.toString());

    @Before
    public void setUp() throws Exception
    {

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    private Deck createTestSubject()
    {
        return new Deck(1);
    }

    @MethodRef(name = "allocateMasterPack", signature = "()V")
    @Test
    public void testAllocateMasterPack() throws Exception
    {

        // default test
        Deencapsulation.invoke(Deck.class, "allocateMasterPack");
    }

    @MethodRef(name = "init", signature = "(I)Z")
    @Test
    public void testInit() throws Exception
    {
        Deck testSubject;
        int numPacks = 0;
        boolean result;

        // test 1
        testSubject = createTestSubject();
        numPacks = 1;
        result = testSubject.init(numPacks);
        Assert.assertEquals(true, result);

        // test 2
        testSubject = createTestSubject();
        numPacks = 0;
        result = testSubject.init(numPacks);
        Assert.assertEquals(false, result); // TODO why result is true

        // test 3
        testSubject = createTestSubject();
        numPacks = 2;
        result = testSubject.init(numPacks);
        Assert.assertEquals(true, result);

        // test 4
        testSubject = createTestSubject();
        numPacks = -1;
        result = testSubject.init(numPacks);
        Assert.assertEquals(false, result);

        // test 5
        testSubject = createTestSubject();
        numPacks = 100;
        result = testSubject.init(numPacks);
        Assert.assertEquals(false, result);

        // test 6: Does MAX_PACKS == 6?
        testSubject = createTestSubject();
        numPacks = 7;
        result = testSubject.init(numPacks);
        Assert.assertFalse(result);
        numPacks = 6;
        result = testSubject.init(numPacks);
        Assert.assertTrue(result);

        // Is the numPacks instance variable set correctly inside of the init method?
        testSubject = createTestSubject();
        numPacks = Deencapsulation.getField(testSubject, "numPacks"); // numPacks instance variable should be 1
        int expected = numPacks + 2;
        result = testSubject.init(expected);
        Assert.assertEquals(true, result);
        numPacks = Deencapsulation.getField(testSubject, "numPacks"); // numPacks instance variable should be 3
        Assert.assertEquals(
                "Students are not setting the numPacks instance variable correctly inside of the init method. "
                        + "They are probably incorrectly setting the numPacks instance variable before init is called.",
                expected, numPacks);
        // The init method should eventually set topCard to numPacks *
        // NUM_CARDS_PER_PACK
        // which equals numPacks * CardInterface.NUM_VALUES * CardInterface.NUM_SUITS.
        int topCard = testSubject.getNumCards();
        expected = numPacks * CardInterface.NUM_VALUES * CardInterface.NUM_SUITS;
        Assert.assertEquals(
                "Students are not setting the topCard instance variable correctly inside of the init method. "
                        + "They are probably incorrectly setting the topCard instance variable before init is called.",
                expected, topCard);
    }

    @MethodRef(name = "init", signature = "()V")
    @Test
    public void testInit_1() throws Exception
    {
        Deck testSubject;
        int numPacks = 0;
        boolean result;

        // test 1
        testSubject = new Deck();
        numPacks = 1;
        result = testSubject.init(numPacks);
        Assert.assertEquals(true, result);

        // test 1 (without a parameter)
        testSubject = new Deck(0);
        // testSubject.init();
        numPacks = 1;
        testSubject.init(numPacks);
        Assert.assertEquals(Card.NUM_SUITS * Card.NUM_VALUES, testSubject.getNumCards());

        // test 2
        testSubject = new Deck();
        Assert.assertEquals(Card.NUM_SUITS * Card.NUM_VALUES, testSubject.getNumCards());

        // test 3
        testSubject = new Deck();
        numPacks = 2;
        result = testSubject.init(numPacks);
        Assert.assertEquals(2 * Card.NUM_SUITS * Card.NUM_VALUES, testSubject.getNumCards());

        // test 4
        testSubject = new Deck();
        testSubject.init(); // Should be equivalent to calling testSubject.init(1)
        Assert.assertEquals(Card.NUM_SUITS * Card.NUM_VALUES, testSubject.getNumCards());
    }

    @MethodRef(name = "getNumCards", signature = "()I")
    @Test
    public void testGetNumCards() throws Exception
    {
        Deck testSubject;
        int result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.getNumCards();
        Assert.assertEquals(Card.NUM_SUITS * Card.NUM_VALUES, result);
    }

    @MethodRef(name = "shuffle", signature = "()V")
    @Test
    public void testShuffle() throws Exception
    {
        Deck testSubject;

        testSubject = createTestSubject();
        int numCardsBefore = testSubject.getNumCards();
        testSubject.shuffle();
        int numCardsAfter = testSubject.getNumCards();
        Assert.assertEquals(
                "Before shuffling the number of cards in the Deck was " + numCardsBefore
                        + ", but after shuffling the number was incorrecly: " + numCardsAfter,
                numCardsBefore, numCardsAfter);
        Card card;
        for (int i = 0; i < numCardsAfter; ++i)
        {
            card = testSubject.inspectCard(i);
            Assert.assertNotNull("After shuffling, a null Card was incorrectly found inside the Deck at index: " + i,
                    card);
            Assert.assertFalse("After shuffling, an invalid Card:" + card
                    + ", was incorrectly found inside the Deck at index: " + i, card.isErrorFlag());
        }
    }

    @MethodRef(name = "dealCard", signature = "()QCard;")
    @Test
    public void testDealCard() throws Exception
    {
        Deck testSubject;
        Card result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.dealCard();
        boolean notEmpty = true;
        int tooManyIterations = 100000;
        int iterationCounter = 0;
        for (iterationCounter = 0; notEmpty && iterationCounter < tooManyIterations; iterationCounter++)
        {
            // Student must use "is" form of predicate method isErrorFlag
            Assert.assertFalse(result.isErrorFlag());
            result = testSubject.dealCard();
            notEmpty = testSubject.getNumCards() > 0;
        }
        if (iterationCounter == tooManyIterations)
        {
            Assert.fail("Students' getNumCards method never returns 0 even if dealCard() is called " + tooManyIterations
                    + " times.");
        }
        // Try to deal from empty deck
        // accessing elements causes java.lang.ArrayIndexOutOfBoundsException thrown if
        // code written incorrectly
        result = testSubject.dealCard(); // if false, ERROR: Student is not checking if it is safe
        // to deal a card from an empty Deck instance
        Assert.assertNotNull(result);
        Assert.assertTrue("Student is not checking if it is safe\n" + "to deal a card from an empty Deck instance",
                result.isErrorFlag());
    }

    @Test
    public void testCantMutateMasterPack() throws Exception
    {
        // Test if dealing can possibly change the masterPack
        Deck testSubject = createTestSubject();
        Card[] masterPack = Deencapsulation.getField(Deck.class, "masterPack");
        Card result = testSubject.dealCard();
        for (int index = 0; index < masterPack.length; ++index)
        {
            if (masterPack[index].equals(result))
            {
                if (masterPack[index] == result)
                {
                    Assert.fail("dealCard() should return copies of objects from the masterPack, not originals");
                }
            }
        }
    }

    @MethodRef(name = "inspectCard", signature = "(I)QCard;")
    @Test
    public void testInspectCard() throws Exception
    {
        Deck testSubject;
        int k = 0;
        Card result;

        // test 1
        testSubject = createTestSubject();
        k = 0;
        result = testSubject.inspectCard(k);
        Assert.assertEquals("2 of clubs", result.toString());
        // if not equal, ERROR Student is sorting out of the assigned order

        // test 2
        testSubject = createTestSubject();
        k = -1;
        result = testSubject.inspectCard(k);
        Assert.assertTrue(result.isErrorFlag()); // : Student uses "is" predicate version of isErrorFlag

        // test 3
        testSubject = createTestSubject();
        k = 1;
        result = testSubject.inspectCard(k);
        Assert.assertFalse(result.isErrorFlag()); // : Student uses "is" predicate version of isErrorFlag

        // test 4
        testSubject = createTestSubject();
        k = 1000;
        result = testSubject.inspectCard(k);
        Assert.assertTrue(result.isErrorFlag()); // : Student uses "is" predicate version of isErrorFlag
    }
}