/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ;

import RegisResQ.presentation.MainUI;

/** RegisResQ { RegisResQ Class is the driver class containing main(). 
 *
 * @author Anthony Kritikos
 * @version 1, Programming Assignment 3
 */

public class RegisResQ {

    /** Main class, currently used for testing Dao interface and implementation.
     * 
     * Running getAll() creates duplicates (but all of the methods can still be 
     * tested and confirmed as functional.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new MainUI().setVisible(true);
        
    }
    
}

