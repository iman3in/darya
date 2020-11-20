/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.common.service;

import ir.j.soltani.iman.common.BaseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface BaseEntityService<T extends BaseEntity> {

    T create(@Valid T entity);

    T update(@Valid T entity);

    void delete(@NotNull Long id);

    T readById(@Valid Long id);

    boolean existsById(@Valid Long id);

    Iterable<T> readAll();

    void archive(@NotNull Long id);

    Iterable<T> readByProperty(String propertyName, Object searchParam);

    long count();
}
