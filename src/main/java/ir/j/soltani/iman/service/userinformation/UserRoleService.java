/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.userinformation;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.Company;
import ir.j.soltani.iman.entity.userinformation.UserRole;
import ir.j.soltani.iman.repository.userinformation.UserRoleRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class UserRoleService extends BaseEntityServiceJpaCrudImpl<UserRole, UserRoleRepository> {
    private final UserService userService;

    public UserRoleService(UserRoleRepository repository, UserService userService) {
        super(repository);
        this.userService = userService;
    }

    public Company findCompanyByUserId(@NotNull Long userId) {
        Optional<UserRole> userRole = repository.findByUser_Id(userId);
        if (!userRole.isPresent())
            throw new IllegalArgumentException("User Id Not Found!");
        return userRole.get().getCompany();
    }
}
