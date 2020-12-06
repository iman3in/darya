/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.entity.UserRole;
import ir.j.soltani.iman.repository.CompanyRepository;
import ir.j.soltani.iman.entity.User;
import ir.j.soltani.iman.entity.Company;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class CompanyService extends BaseEntityServiceJpaCrudImpl<Company, CompanyRepository> {
    private final UserService userService;
    private final UserRoleService userRoleService;


    public CompanyService(CompanyRepository companyRepository, UserService userService, UserRoleService userRoleService) {
        super(companyRepository);
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    public Company createCompanyUser(@Valid Company company, @Valid User user){
        UserRole userRole = new UserRole();
        userRole.setCompany(create(company));
        userRole.setUser(userService.create(user));
        return userRoleService.create(userRole).getCompany();
    }

    public Company readByUserId(@NotNull Long userId){
        return userRoleService.findCompanyByUserId(userId);
    }
}
