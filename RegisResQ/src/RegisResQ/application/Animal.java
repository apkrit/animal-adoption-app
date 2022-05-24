/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.application;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/** Animal { Animal Class is extended by specific species Classes  
 *
 * @author Anthony Kritikos
 */

abstract public class Animal {
    // Protected attribute fields of Animal class
    protected String species;
    protected String breed;
    protected String name;
    protected Boolean sterilized;
    protected String dateArrived;
    
    /** Default no-parameter constructor  
    *
    */
    public Animal() {       
    }

    /** Parameterized constructor initializing all fields except for species   
    * 
    * @param breed
    * @param name
    * @param sterilized
    * @param dateArrived
    */
    public Animal(String breed, String name, Boolean sterilized, 
            String dateArrived) {
        this.breed = breed;
        this.name = name;
        this.sterilized = sterilized;
        this.dateArrived = dateArrived;
    }
    
    /** species setter 
    * 
    * @param species
    */
    public void setSpecies(String species) {
        this.species = species;
    }

    /** breed setter 
    * 
    * @param breed
    */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /** name setter 
    * 
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /** sterilized setter 
    * 
    * @param sterilized
    */
    public void setSterilized(Boolean sterilized) {
        this.sterilized = sterilized;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    /** species getter 
    * 
    * @return species
    */
    public String getSpecies() {
        return species;
    }

    /** breed getter 
    * 
    * @return breed
    */
    public String getBreed() {
        return breed;
    }

    /** name getter 
    * 
    * @return name
    */
    public String getName() {
        return name;
    }

    /** sterilized getter 
    * 
    * @return sterilized
    */
    public Boolean getSterilized() {
        return sterilized;
    }

    /** dateArrived getter 
    * 
    * @return dateArrived
    */
    public String getDateArrived() {
        return dateArrived;
    }
    
    /** toString - Displays string description of Animal class 
    * 
    * @return String listing field variables and their values
    */
    @Override
    public String toString() {
        return "Animal{" + "species=" + species + ", breed=" + breed + ","
                + " name=" + name + ", sterilized=" + sterilized + ","
                + " dateArrived=" + dateArrived + '}';
    }

    
    /** validate - Uses testNG to set variable fields, and checks validity
    * 
    * @return isValid - Returns whether the class has valid field values
    */
    public Boolean validate(){
        // Local variables for return statement and holding date values
        Boolean isValid = true; // Returns true if valid, false otherwise
        LocalDate date;         // Used for checking if date has proper format
        int yearInteger = -1;  
        int monthInteger = -1;
        int dayInteger = -1;
        
        // Sets isValid to false if breed is null or empty
        if((breed == null) || (breed.isEmpty())){
            isValid = false;
        }
               
        // Sets isValid to false if name is null or empty
        if((name == null) || (name.isEmpty())){
            isValid = false;
        }
              
        // Sets isValid to false if dateArrived is null or empty
        if((dateArrived == null) || (dateArrived.isEmpty())){
            isValid = false;
        }
        
        // Validate date format is YYYY-MM-DD and splits into year, month, day              
        if(isValid){
            
            try{
                date = LocalDate.parse(dateArrived); // Check and parse date
                yearInteger = date.getYear();
                monthInteger = date.getMonthValue();
                dayInteger = date.getDayOfMonth();  
            }catch(DateTimeParseException e){ // Throws exception if wrong form,
                isValid = false;              // or if invalid content
            }
             
        }
        
        // Checks whether the months & amount of days in the month are correct
        if(isValid){                     
      
            switch(monthInteger){
                case 1:
                case 3: 
                case 5:
                case 7: 
                case 8: 
                case 10:
                case 12:
                    if(dayInteger <= 31){
                        isValid = true;
                    }
                    break;
                case 2:
                    if(dayInteger <= 29){
                        isValid = true;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(dayInteger <= 30){
                        isValid = true;
                    }
                    break;
                default: 
                    isValid = false;
                    break;
            }
            
        }
                
        return isValid;
    }
    
}
