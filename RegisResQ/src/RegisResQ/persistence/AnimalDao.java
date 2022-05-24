/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.persistence;

import RegisResQ.application.*;  // Needed for domain classes
import java.sql.Connection;      // Needed to establish database connection
import java.sql.DriverManager;   // Needed ti connect to database server
import java.sql.ResultSet;       // Needed to store result of SQL queries
import java.sql.Statement;       // Needed to create SQL query
import java.sql.SQLException;    // All database ops must be in try-catch blocks
import java.util.*;              // Needed for ArrayList ADT


/** AnimalDao { AnimalDao Class implements Dao interface for CRUD w/ database.
 *
 * @author Anthony Kritikos
 */

public class AnimalDao implements Dao<Animal>{
    private List<Animal> animals;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /** Default constructor initializes database connection.
    *
    */
    public AnimalDao() {
        animals = new ArrayList<Animal>(); 
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:"
                    + "3306/animals", "cs444", "p@sswordCS444");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    /** Returns all of the animals stored in database.
    * 
    * Not intended to be called more than once in the final version of the 
    * Regis ResQ program, calling more than once may result in duplicates.
    * 
    * @return List<Animal> the animals in database
    */
    @Override
    public List<Animal> getAll() {
        Animal a = null;
        Boolean isSterilized = false;
        
        try{
            statement = connection.createStatement();
            // Executes SQL statement to get all animals from database.
            resultSet = statement.executeQuery("select * from adoptable_pets;");
            
            while(resultSet.next()){
                
                if(resultSet.getString("sterilized").equals("1")){
                    isSterilized = true; 
                }
                
                if(resultSet.getString("type").equals("cat")){
                    
                    a = new Cat(resultSet.getString("breed"), 
                            resultSet.getString("name"), isSterilized, 
                            resultSet.getString("arrived"));
                    
                }else{
                    
                    if(resultSet.getString("type").equals("dog")){
                        
                        a = new Dog(resultSet.getString("breed"), 
                                resultSet.getString("name"), isSterilized, 
                                resultSet.getString("arrived"));
                    
                    }
                
                }
                
                animals.add(a);
                
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return animals;
    }

    /** Adds input animal to the database.
    * 
    * @param a the input Animal (dog, cat, etc.)
    * @return addResult True if added False if not
    */
    @Override
    public Boolean add(Animal a) {
        String type = null;
        Boolean addResult = false;
        
        try{
            statement = connection.createStatement();
            
            if(a.getSpecies().equals("dog")){
                
                type = "dog";
                
            }else{
                
                if(a.getSpecies().equals("cat")){
                    
                    type = "cat";
                    
                }
            
            }
            
            // Creates and exectues SQL statement for adding to database.
            statement.execute("insert into adoptable_pets (type, breed, name, "
                    + "sterilized, arrived) values ('" + type + "', '"
                    + a.getBreed() + "', '" + a.getName() + "', "
                    + String.valueOf(a.getSterilized()) + ", '"
                    + a.getDateArrived() + "');");
            
            addResult = true;
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            addResult = false;
            
        }
        
        return addResult;
    }

    /** Updates information for input animal.
    * 
    * @param a the input Animal (dog, cat, etc.)
    * @return updateResult True if updated False if not
    */
    @Override
    public Boolean update(Animal a) {
        Boolean updateResult = false;
        
        try{
            
            statement = connection.createStatement();
            // Creates and executes SQL statement to udpate an animal entry. 
            statement.executeUpdate("update adoptable_pets set type = '" +
                    a.getSpecies() + "', breed = '" + a.getBreed() + "',"
                    + "sterilized = " + String.valueOf(a.getSterilized()) +
                    ", arrived = '" + a.getDateArrived() + "' where name = '" +
                    a.getName() + "';");
            updateResult = true;
            
        
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            updateResult = false;
        
        }
        
        return updateResult;
    }

    /** Deletes input animal from the database.
    * 
    * @param a the input Animal (dog, cat, etc.)
    * @return deleteResult True if deleted, False if not
    */
    @Override
    public Boolean delete(Animal a) {
        Boolean deleteResult;
        
        try{
            
            statement = connection.createStatement();
            //Creates and executes SQL statement to delete an animal entry.
            statement.execute("delete from adoptable_pets where name = '" +
                    a.getName() + "';");
            deleteResult = true;
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            deleteResult = false;           
            
        }
        
        return deleteResult;
    }
        
}
