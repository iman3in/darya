/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.common.service;

import ir.j.soltani.iman.common.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public abstract class BaseEntityServiceJpaCrudImpl<EntityGeneric extends BaseEntity, T extends JpaRepository>
                implements BaseEntityService<EntityGeneric> {
    protected T repository;

    public BaseEntityServiceJpaCrudImpl(T repository) {
        this.repository = repository;
    }

    @Override
    public EntityGeneric create(@Valid EntityGeneric entity) {
        EntityGeneric entityGeneric = (EntityGeneric) repository.save(entity);
        return entityGeneric;
    }

    @Override
    public EntityGeneric update(@Valid EntityGeneric entity) {
        if (!repository.existsById(entity.getId()))
            throw new IllegalArgumentException("Entity Not Exist");
        return (EntityGeneric) repository.save(entity);
    }

    @Override
    public void delete(@NotNull Long id) {
        repository.deleteById(id);
    }

    @Override
    public EntityGeneric readById(@NotNull Long id) {
        Optional<EntityGeneric> result = repository.findById(id);
        if (!result.isPresent())
            throw new IllegalArgumentException("Entity Not Exist!");
        return result.get();
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<EntityGeneric> readAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void archive(@NotNull Long id) {
        EntityGeneric entity = readById(id);
        entity.setActiveEnumId(2);
        repository.save(entity);
    }

    @Override
    public List<EntityGeneric> readByProperty(String propertyName, Object searchParam) {
        //TODO
        return null;
    }
}
