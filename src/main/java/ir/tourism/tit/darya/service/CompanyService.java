/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.service;

import ir.tourism.tit.darya.repository.CompanyRepository;
import ir.tourism.tit.darya.service.base.BaseEntityService;
import ir.tourism.tit.darya.model.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ReflectionException;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class CompanyService implements BaseEntityService<Company> {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createEntity(Company entity) throws SQLException, ReflectionException {
        return companyRepository.create(entity);
    }

    @Override
    public Company updateEntity(Company entity) throws SQLException, ReflectionException {
        return companyRepository.update(entity);
    }

    @Override
    public Iterable<Company> readAllEntities() throws SQLException, ReflectionException {
        return companyRepository.readAll();
    }

    @Override
    public Company readById(Long id) throws SQLException, ReflectionException {
        Optional<Company> company = companyRepository.readById(id);
        if (!company.isPresent())
            throw new IllegalArgumentException();
        return company.get();
    }

    @Override
    public void delete(Company company) throws SQLException, ReflectionException {
        companyRepository.delete(company);
    }
}
