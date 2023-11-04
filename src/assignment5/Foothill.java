package assignment5;

import org.junit.Assert;

public class Foothill
{
    static void verifyEmptyDEQueueWithRemoveFromBack(DEQueue testSubject)
    {
        Node2 result = null;
        try
        {
            result = testSubject.removeFromBack();
        } catch (QueueEmptyException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("null: " + result);
    }

    public static void main(String[] args) throws Exception
    {
        DEQueue testSubject;
        Node2 result;

        // default empty test
        testSubject = new DEQueue();
        verifyEmptyDEQueueWithRemoveFromBack(testSubject);

        Card crd1 = new Card('2', Card.Suit.spades);
        String crd1string = crd1.toString();
        testSubject.addToBack(new CardNode2(crd1));
        Card crd2 = new Card('A', Card.Suit.spades);
        String crd2string = crd2.toString();
        testSubject.addToBack(new CardNode2(crd2));
        String testSubjectString = testSubject.toString();
        System.out.println("queue contains: " + crd1string +" : "+ testSubjectString.contains(crd1string));
        System.out.println("queue contains: " + crd2string +" : "+ testSubjectString.contains(crd2string));

        int crd1start = testSubjectString.indexOf(crd1string);
        int crd2start = testSubjectString.indexOf(crd2string);
        System.out.println(crd2start + " > " + crd1start);

        result = testSubject.removeFromBack();
        Assert.assertNotNull(result);
        System.out.println(crd2string + " = " + result.toString());
        testSubjectString = testSubject.toString();
        System.out.println("queue contains: " + crd1string +" : "+ testSubjectString.contains(crd1string));
        System.out.println("queue DOESN'T contain: " + crd2string +" : "+ !testSubjectString.contains(crd2string));
//        Assert.assertTrue(testSubjectString.contains(crd1string));
//        Assert.assertFalse(testSubjectString.contains(crd2string));

        result = testSubject.removeFromBack();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd1string, result.toString());
        testSubjectString = testSubject.toString();

        System.out.println("queue DOESN'T contain: " + crd1string +" : "+ !testSubjectString.contains(crd1string));
//        Assert.assertFalse(testSubjectString.contains(crd1string));
        result = null;
        verifyEmptyDEQueueWithRemoveFromBack(testSubject);

        Card crd3 = new Card('3', Card.Suit.spades);
        String crd3string = crd3.toString();
        testSubject.addToFront(new CardNode2(crd3));
        Card crd4 = new Card('4', Card.Suit.spades);
        String crd4string = crd4.toString();
        testSubject.addToFront(new CardNode2(crd4));
        testSubjectString = testSubject.toString();
        //		Assert.assertEquals("4 of spades   3 of spades   ", testSubjectString);
        System.out.println(testSubject);
        result = testSubject.removeFromBack();

        System.out.println("NOT null " + result);
        System.out.println(crd3string+ " = " + result);
        testSubjectString = testSubject.toString();
        System.out.println("queue contains: " + crd4string +" : "+ testSubjectString.contains(crd4string));
        System.out.println("queue DOESN'T contain: " + crd3string +" : "+ !testSubjectString.contains(crd3string));
//        Assert.assertEquals(true, testSubjectString.contains(crd4string));
//        Assert.assertEquals(false, testSubjectString.contains(crd3string));
    }
}

class FoothillPhase1 {
    public static void main(String[] args) throws Exception
    {

        DEQueue queue = new DEQueue();
        Card crd3 = new Card('3', Card.Suit.spades);
        String crd3string = crd3.toString();
        queue.addToFront(new CardNode2(crd3));
        Card crd4 = new Card('4', Card.Suit.spades);
        String crd4string = crd4.toString();
        queue.addToFront(new CardNode2(crd4));

        System.out.println(queue);
        System.out.println(queue.removeFromBack());
    }

    public static Card createRandomCard() {
        char value = CardInterface.CARD_VALUES[(int)(Math.random() * CardInterface.CARD_VALUES.length)];
        CardInterface.Suit suit = CardInterface.Suit.values()[(int)(Math.random() * 4)];
        return new Card(value, suit);

    }

}
