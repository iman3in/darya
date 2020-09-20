/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.service.base;

import ir.tourism.tit.darya.model.base.BaseEntity;
import ir.tourism.tit.darya.model.entity.GenderType;

import javax.management.ReflectionException;
import java.sql.SQLException;

/**
 * Interface to indicate all available services for all of the entities.
 * @param <T> Type of Entity
 */

public interface BaseEntityService<T extends BaseEntity> {

    T createEntity(T entity) throws SQLException, ReflectionException;

    T updateEntity(T entity) throws SQLException, ReflectionException;

    Iterable<T> readAllEntities() throws SQLException, ReflectionException;

    T readById(Long id) throws SQLException, ReflectionException;

    void delete(T entity) throws SQLException, ReflectionException;
}
