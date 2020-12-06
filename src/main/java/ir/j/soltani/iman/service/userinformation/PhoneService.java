package ir.j.soltani.iman.service.userinformation;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.userinformation.Phone;
import ir.j.soltani.iman.entity.userinformation.UserInformation;
import ir.j.soltani.iman.repository.userinformation.PhoneRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class PhoneService extends BaseEntityServiceJpaCrudImpl<Phone, PhoneRepository> {
    private UserInformationService userInformationService;

    public PhoneService(PhoneRepository repository, UserInformationService userInformationService) {
        super(repository);
        this.userInformationService = userInformationService;
    }

    public Phone createUserPhone(@Valid Phone phone, @NotNull Long userId) {
        UserInformation userInformation = userInformationService.readByUserId(userId);
        phone.setUserInformation(userInformation);
        return create(phone);
    }

    public List<Phone> readByUserId(@NotNull Long userId) {
        List<Phone> phone = repository.findAllByUserInformation_Id(userInformationService.readByUserId(userId).getId());
        return phone;
    }
}
