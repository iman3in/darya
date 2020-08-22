/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.service;

import ir.tourism.tit.darya.repository.GenderTypeRepository;
import ir.tourism.tit.darya.service.base.BaseEntityService;
import ir.tourism.tit.darya.model.entity.GenderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ReflectionException;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class GenderTypeService implements BaseEntityService<GenderType> {

    private final GenderTypeRepository genderTypeRepository;

    @Autowired
    public GenderTypeService(GenderTypeRepository genderTypeRepository) {
        this.genderTypeRepository = genderTypeRepository;
    }

    @Override
    public GenderType createEntity(GenderType entity) throws SQLException, ReflectionException {
        return genderTypeRepository.create(entity);
    }

    @Override
    public GenderType updateEntity(GenderType entity) throws SQLException, ReflectionException {
        return genderTypeRepository.update(entity);
    }

    @Override
    public Iterable<GenderType> readAllEntities() throws SQLException, ReflectionException {
        return genderTypeRepository.readAll();
    }

    @Override
    public GenderType readById(Long id) throws SQLException, ReflectionException {
        Optional<GenderType> genderType = genderTypeRepository.readById(id);
        if (!genderType.isPresent())
            throw new IllegalArgumentException();
        return genderType.get();
    }

    @Override
    public void delete(GenderType genderType) throws SQLException, ReflectionException {
        genderTypeRepository.delete(genderType);
    }
}
