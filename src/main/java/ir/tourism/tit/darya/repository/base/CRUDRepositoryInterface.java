/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository.base;

import ir.tourism.tit.darya.model.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.management.ReflectionException;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;


/**
 * Interface for generic CRUD operations on a repository for a specific type.
 * @param <T> the domain type the repository manages.
 */

@Repository
public interface CRUDRepositoryInterface<T extends BaseEntity> extends BaseRepository<T> {

    /**
     * Adds a given entity to the table. Use the returned instance for further operations.
     * @param entity must not be null.
     * @return the created entity; will never be null.
     * @throws IllegalArgumentException in case the given entity is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    T create(@NotNull T entity) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Adds all given entities.
     * @param entities must not be null nor must it contain null.
     * @return the created entities; will never be null. The returned Iterable will have the same size as the Iterable passed as an argument.
     * @throws IllegalArgumentException in case the given entities or one of its entities is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    Iterable<T> createAll(@NotNull Iterable<T> entities) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Updates a given entity in database. Use the returned instance for further operations as the save operation might have changed the entity instance completely.
     * @param entity must not be null.
     * @return the updated entity; will never be null.
     * @throws IllegalArgumentException in case the given entity is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    T update(@NotNull T entity) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Updates all given entities.
     * @param entities must not be null nor must it contain null.
     * @return the updated entities; will never be null. The returned Iterable will have the same size as the Iterable passed as an argument.
     * @throws IllegalArgumentException in case the given entities or one of its entities is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    Iterable<T> updateAll(@NotNull Iterable<T> entities) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Deletes a given entity from database.
     * @param entity must not be null.
     * @throws IllegalArgumentException in case the given entity is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    void delete(@NotNull T entity) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Updates all given entities.
     * @param entities must not be null nor must it contain null.
     * @return the updated entities; will never be null. The returned Iterable will have the same size as the Iterable passed as an argument.
     * @throws IllegalArgumentException in case the given entities or one of its entities is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    void deleteAll(@NotNull Iterable<T> entities) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Retrieves an entity by its id.
     * @param id must not be null.
     * @return the entity with the given id or Optional#empty() if none found.
     * @throws IllegalArgumentException - if id is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    Optional<T> readById(@NotNull Long id) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Returns whether an entity with the given id exists.
     * @param id must not be null.
     * @return true if an entity with the given id exists, false otherwise.
     * @throws IllegalArgumentException if id is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    boolean existsById(@NotNull Long id) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Returns all instances of the type.
     * @return all entities
     * @throws IllegalArgumentException if id is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    Iterable<T> readAll() throws SQLException, ReflectionException;

    /**
     * Returns all entities which their property specified by property name matches the searchParam criteria.
     * @return list of matching entities.
     * @throws IllegalArgumentException propertyName is empty or searchParam is null.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    Iterable<T> readByProperty(String propertyName, Object searchParam) throws IllegalArgumentException, SQLException, ReflectionException;

    /**
     * Returns the number of rows available.
     * @return the number of rows.
     * @throws SQLException in case the operation on database is not successful.
     */
    long count() throws SQLException;

    /**
     * Returns StoredProcedure output if hasOutParam be true else returns null.
     * @param spName StoredProcedure name must not be null.
     * @param inParams hashMap of in parameters of storedProcedure.
     * @param hasOutParam determine StoredProcedure has output or not, must not be null.
     * @return list of StoredProcedure output.
     * @throws SQLException in case the operation on database is not successful.
     * @throws ReflectionException in case any problem resulting from using the operations of java.lang.reflect package.
     */
    public Iterable<T> callStoredProcedure(@NotNull String spName, HashMap<String,Object> inParams,@NotNull boolean hasOutParam) throws SQLException, ReflectionException ;


}