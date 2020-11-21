/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.company;

import ir.j.soltani.iman.model.entity.user.UserRole;
import ir.j.soltani.iman.repository.company.CompanyRepository;
import ir.j.soltani.iman.model.entity.user.User;
import ir.j.soltani.iman.model.entity.company.Company;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.service.user.UserRoleService;
import ir.j.soltani.iman.service.user.UserService;
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
