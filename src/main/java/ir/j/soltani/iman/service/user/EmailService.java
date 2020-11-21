/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.user;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.model.entity.user.Email;
import ir.j.soltani.iman.model.entity.user.UserInformation;
import ir.j.soltani.iman.repository.user.EmailRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class EmailService extends BaseEntityServiceJpaCrudImpl<Email, EmailRepository> {
    private UserInformationService userInformationService;

    public EmailService(EmailRepository repository, UserInformationService userInformationService) {
        super(repository);
        this.userInformationService = userInformationService;
    }

    public Email createUserEmail(@Valid Email email, @NotNull Long userId) {
        UserInformation userInformation = userInformationService.readByUserId(userId);
        email.setUserInformation(userInformation);
        return create(email);
    }

    public List<Email> readByUserId(@NotNull Long userId) {
        List<Email> email = repository.findAllByUserInformation_Id(userInformationService.readByUserId(userId).getId());
        return email;
    }
}
