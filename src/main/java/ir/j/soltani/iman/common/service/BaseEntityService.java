/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.common.service;

import ir.tourism.tit.darya.common.BaseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface BaseEntityService<T extends BaseEntity> {

    T create(@Valid T entity);

    T update(@Valid T entity);

    void delete(@NotNull Long id);

    T readById(@Valid Long id);

    boolean existsById(@Valid Long id);

    Iterable<T> readAll();

    void archive(T entity);

    Iterable<T> readByProperty(String propertyName, Object searchParam);

    long count();
}
