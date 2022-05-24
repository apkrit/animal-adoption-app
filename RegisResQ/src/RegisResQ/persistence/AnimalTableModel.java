/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.persistence;

import RegisResQ.application.Animal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/** AnimalTabelModel { Fills GUI table with animal records from Dao database
 *
 * @author Anthony Kritikos
 */

public class AnimalTableModel extends AbstractTableModel {
    // Private field values of AnimalTableModel
    private List<Animal> animals;
    private final String [] columnNames = {"Type", "Breed", "Name", 
        "Sterilized", "Arrived"};

    /**
     * Default constructor for AnimalTableModel initializes animal list to null.
     */
    public AnimalTableModel() {
        this.animals = null;
    }

    /** Animals list setter 
    * 
    *  @param animals
    */
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    
    /** Animals list size getter 
    * 
    *  @return number of rows (animals list size)
    */
    @Override
    public int getRowCount() {
        int animalsListSize;
        
        animalsListSize = animals.size();
        
        return animalsListSize;
    }

    /** Column count getter 
    * 
    *  @return number of columns (column names array length)
    */
    @Override
    public int getColumnCount() {
        int columnNamesLength;
        
        columnNamesLength = columnNames.length;
        
        return columnNamesLength;
    }

    /** Table value getter 
    * 
     * @param row
     * @param column
    *  @return table object (field in specific row and column)
    */
    @Override
    public Object getValueAt(int row, int column) {
        int targetRow = row;
        int targetColumn = column;
        Animal a = null;
        Object columnStringValue = null;
        
        // Define variable a of type Animal
        // Non-descriptive variable name 'a' is dictated by assignment reqs. 
        a = animals.get(targetRow);
        
        // Gets related field value from animals list depending on column
        switch(targetColumn){
            case 0:
                columnStringValue = a.getSpecies();
                break;
            case 1:
                columnStringValue = a.getBreed();
                break;
            case 2:
                columnStringValue = a.getName();
                break;
            case 3:
                columnStringValue = a.getSterilized();
                break;
            case 4:
                columnStringValue = a.getDateArrived();
                break;
            default:
                throw new IllegalStateException("Invalid column number input");
        }
        
        return columnStringValue;
    }
    
    /** Column name getter 
    * 
     * @param column
    *  @return value of column in column name String array
    */
    @Override
    public String getColumnName(int column) {
        int targetIndex = column;
        String targetColumnName = null;
        
        targetColumnName = columnNames[targetIndex];
        
        return targetColumnName;
    }
    
}
