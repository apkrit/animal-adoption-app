/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.application;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/** DogNGTest - Uses testNG to set parameters and test for validity
 *
 * @author Anthony Kritikos
 * @version 1 Programming Assignment 2
 */

public class DogNGTest {
    
    /** Empty default DogNGTest class 
    *
    */
    public DogNGTest() {
    }

    /** testValidate - Uses validate method from Animal class & sets parameters,
    * along with assert statements to check for validity of class fields
    *
    */
    @Test
    public void testValidate() {
        Dog testDog = new Dog();
        Boolean result = testDog.validate(); 
        assertFalse(result);
        
        // Tests for proper handling of null name value
        testDog.setName("");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of correct name value
        testDog.setName("Balto");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of null breed value
        testDog.setBreed("");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of correct breed value
        testDog.setBreed("Husky");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of null date value
        testDog.setDateArrived("");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of incorrect month value
        testDog.setDateArrived("2020-74-31");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of incorrect day value
        testDog.setDateArrived("2020-05-32");
        result = testDog.validate();
        assertFalse(result);
        
        // Tests for proper handling of correct date value
        testDog.setDateArrived("2020-05-31");
        result = testDog.validate();
        assertTrue(result);
           
    }
    
}
