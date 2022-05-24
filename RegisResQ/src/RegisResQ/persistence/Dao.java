/* Program will provide system for managing animals under care of an animal 
 * rescue shelter. Allows users to log new received animals and inspect records 
 * of existing animals already under care.
 *
 */
package RegisResQ.persistence;

import java.util.*;

/** Dao { Dao Class provides interface for CRUD operations w/ database.
 *
 * @author Anthony Kritikos
 * @version 1, Programming Assignment 3
 */

public interface Dao<T> {
    List<T> getAll();
    Boolean add(T item);
    Boolean update(T item);
    Boolean delete(T item);
}
