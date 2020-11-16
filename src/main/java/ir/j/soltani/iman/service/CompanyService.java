/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.repository.CompanyRepository;
import ir.j.soltani.iman.model.entity.User;
import ir.j.soltani.iman.model.entity.Company;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService extends BaseEntityServiceJpaCrudImpl<Company, CompanyRepository> {
    private final UserService userService;

    public CompanyService(CompanyRepository companyRepository, UserService userService) {
        super(companyRepository);
        this.userService = userService;
    }

    public Company createCompanyUser(Company company, User user){
        User outUser = userService.create(user);
        company.setUser(outUser);
        return create(company);
    }

    public Company readByUserId(Long userId){
        Optional<Company> companyOptional = repository.findByUser_Id(userId);
        if (!companyOptional.isPresent())
            throw new IllegalArgumentException("Company Not Found!");
        return companyOptional.get();
    }
}
