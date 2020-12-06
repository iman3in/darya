/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.type;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.type.EmailType;
import ir.j.soltani.iman.repository.type.EmailTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailTypeService extends BaseEntityServiceJpaCrudImpl<EmailType, EmailTypeRepository> {
    public EmailTypeService(EmailTypeRepository repository) {
        super(repository);
    }
}
