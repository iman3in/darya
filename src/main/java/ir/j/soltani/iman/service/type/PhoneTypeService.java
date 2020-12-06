/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.type;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.type.PhoneType;
import ir.j.soltani.iman.repository.type.PhoneTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneTypeService extends BaseEntityServiceJpaCrudImpl<PhoneType, PhoneTypeRepository> {
    public PhoneTypeService(PhoneTypeRepository repository) {
        super(repository);
    }
}
