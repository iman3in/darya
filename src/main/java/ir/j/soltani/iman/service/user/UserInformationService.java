/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.user;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.model.entity.user.UserInformation;
import ir.j.soltani.iman.repository.user.UserInformationRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class UserInformationService extends BaseEntityServiceJpaCrudImpl<UserInformation, UserInformationRepository> {
    public UserInformationService(UserInformationRepository repository) {
        super(repository);
    }

    public UserInformation readByUserId(@NotNull Long userId) {
        Optional<UserInformation> userInformation = repository.findByUser_Id(userId);
        if (!userInformation.isPresent())
            throw new IllegalArgumentException("User Information Not Found");
        return userInformation.get();
    }
}
