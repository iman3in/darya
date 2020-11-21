/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.user;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.model.entity.company.Company;
import ir.j.soltani.iman.model.entity.user.UserRole;
import ir.j.soltani.iman.repository.user.UserRoleRepository;
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
