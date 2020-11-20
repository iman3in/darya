/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.model.entity.Email;
import ir.j.soltani.iman.model.entity.UserInformation;
import ir.j.soltani.iman.repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService extends BaseEntityServiceJpaCrudImpl<Email, EmailRepository> {
    private UserInformationService userInformationService;

    public EmailService(EmailRepository repository, UserInformationService userInformationService) {
        super(repository);
        this.userInformationService = userInformationService;
    }

    public Email createUserEmail(Email email, Long userId) {
        UserInformation userInformation = userInformationService.readByUserId(userId);
        email.setUserInformation(userInformation);
        return create(email);
    }

    public List<Email> readByUserId(Long userId) {
        List<Email> email = repository.findAllByUserInformation_Id(userInformationService.readByUserId(userId).getId());
        return email;
    }
}
