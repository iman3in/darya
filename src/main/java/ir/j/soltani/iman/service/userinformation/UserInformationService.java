/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.userinformation;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.userinformation.UserInformation;
import ir.j.soltani.iman.repository.userinformation.UserInformationRepository;
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
