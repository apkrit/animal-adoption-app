/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.application;

/** Cat { Extends Animal class for use with cat species Class
 *
 * @author Anthony Kritikos
 */

public class Cat extends Animal {

    /** Default constructor
    *
    */
    public Cat() {
        this.species = "cat";
        this.breed = null;
        this.name = null;
        this.sterilized = false;
        this.dateArrived = null;
    }

    /** Parameterized constructor using super from Animal class + species
    * 
    * @param breed
    * @param name
    * @param sterilized
    * @param dateArrived
    */
    public Cat(String breed, String name, Boolean sterilized, 
            String dateArrived) {
        super(breed, name, sterilized, dateArrived);
        this.species = "cat";
    }
    
}
