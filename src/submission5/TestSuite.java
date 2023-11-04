package assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ 
    QueueTest.class, 
    CardQueueTest.class,
    CardTest.class, 
  DeckTest.class, // not needed
  HandTest.class, // not needed
    NodeTest.class,
    IntegrationTest.class
})
public class TestSuite
{ // nothing
}

