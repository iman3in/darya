/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository.base;

/**
 * Operations on the database.
 */
public enum  DBOperation {
    /**
     * Create operation
     */
    CREATE("CREATE"),
    /**
     * Update operation
     */
    UPDATE("UPDATE"),
    /**
     * Delete operation
     */
    DELETE("DELETE"),
    /**
     * Search operation
     */
    FIND("FIND");

    private String name;

    DBOperation(String name) {
        this.name = name;
    }

    /**
     * Get the name.
     * @return name of this operation
     */
    public String getName() {
        return name;
    }
}
