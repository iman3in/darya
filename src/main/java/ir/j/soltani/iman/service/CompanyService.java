/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.model.entity.UserRole;
import ir.j.soltani.iman.repository.CompanyRepository;
import ir.j.soltani.iman.model.entity.User;
import ir.j.soltani.iman.model.entity.Company;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends BaseEntityServiceJpaCrudImpl<Company, CompanyRepository> {
    private final UserService userService;
    private final UserRoleService userRoleService;


    public CompanyService(CompanyRepository companyRepository, UserService userService, UserRoleService userRoleService) {
        super(companyRepository);
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    public Company createCompanyUser(Company company, User user){
        UserRole userRole = new UserRole();
        userRole.setCompany(create(company));
        userRole.setUser(userService.create(user));
        return userRoleService.create(userRole).getCompany();
    }

    public Company readByUserId(Long userId){
        return userRoleService.findCompanyByUserId(userId);
    }
}
