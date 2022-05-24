/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.application;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/** CatNGTest - Uses testNG to set parameters and test for validity
 *
 * @author Anthony Kritikos
 * @version 1 Programming Assignment 2
 */

public class CatNGTest {
    
    /** Empty default CatNGTest class 
    *
    */
    public CatNGTest() {
    }

    /** testValidate - Uses validate method from Animal class & sets parameters,
    * along with assert statements to check for validity of class fields
    *
    */
    @Test
    public void testValidate() {
        Cat testCat = new Cat();
        Boolean result = testCat.validate(); 
        assertFalse(result);
        
        // Tests for proper handling of null name value
        testCat.setName("");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of correct name value
        testCat.setName("Mr.Meow");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of null breed value
        testCat.setBreed("");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of correct breed value
        testCat.setBreed("Persian");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of null date value
        testCat.setDateArrived("");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of incorrect month value
        testCat.setDateArrived("2020-74-31");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of incorrect day value
        testCat.setDateArrived("2020-05-32");
        result = testCat.validate();
        assertFalse(result);
        
        // Tests for proper handling of correct date value
        testCat.setDateArrived("2020-05-31");
        result = testCat.validate();
        assertTrue(result);
        
    }
    
}
