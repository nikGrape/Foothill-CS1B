package assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ 
    DEQueueTest.class, 
    CardNode2Test.class, 
//    DeckTest.class,  // not needed
//    HandTest.class,  // not needed
    QueueTest.class, 
    CardQueueTest.class,
    CardTest.class, 
    NodeTest.class, 
    IntegrationTest.class 
})
public class OptionBTestSuite
{ // nothing
}