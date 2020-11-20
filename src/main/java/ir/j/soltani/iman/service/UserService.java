/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.model.entity.Company;
import ir.j.soltani.iman.model.entity.UserInformation;
import ir.j.soltani.iman.repository.UserRepository;
import ir.j.soltani.iman.model.entity.User;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends BaseEntityServiceJpaCrudImpl<User, UserRepository> {
    private UserInformationService userInformationService;

    public UserService(UserRepository repository, UserInformationService userInformationService) {
        super(repository);
        this.userInformationService = userInformationService;
    }

    @Override
    public User create(User user){
        UserInformation userInformation = new UserInformation();
        User outUser = super.create(user);
        userInformation.setUser(outUser);
        userInformationService.create(userInformation);
        return outUser;
    }
}
