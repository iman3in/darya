/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.repository.CompanyRepository;
import ir.j.soltani.iman.entity.userinformation.User;
import ir.j.soltani.iman.entity.Company;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.service.userinformation.UserService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class CompanyService extends BaseEntityServiceJpaCrudImpl<Company, CompanyRepository> {

    private UserService userService;

    public CompanyService(CompanyRepository companyRepository, UserService userService) {
        super(companyRepository);
        this.userService = userService;
    }

    public Company createCompanyUser(@Valid Company company, @Valid User user){
        user.setId(null);
        User createdUser = userService.create(user);
        company.setId(null);
        company.setUser(createdUser);
        return create(company);
    }

    public Company readByUserId(@NotNull Long userId){
        Optional<Company> company = repository.findByUser_Id(userId);
        if (!company.isPresent())
            throw new IllegalArgumentException("User Id Not Found!");
        return company.get();
    }
}
