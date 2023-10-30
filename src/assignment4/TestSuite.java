package assignment4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(

{ Phase1AppTest.class, /*
                        * Tests the Phase1App your instructor gave you. This JavaFX Application's test
                        * MUST be ran FIRST so JavaFX is not initialized by another JavaFX Application
                        * before Phase1App.
                        */
        GUICardTest.class, CardTableTest.class, // Necessary tests for other JavaFX classes
        CardTest.class, // Necessary
//      HandTest.class, // Not necessary as the application we are testing doesn't use the Hand class
        DeckTest.class, // Necessary
})
public class TestSuite
{ // nothing
}