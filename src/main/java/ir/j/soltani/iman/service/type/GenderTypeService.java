/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.type;

import ir.j.soltani.iman.repository.type.GenderTypeRepository;
import ir.j.soltani.iman.entity.type.GenderType;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

@Service
public class GenderTypeService extends BaseEntityServiceJpaCrudImpl<GenderType, GenderTypeRepository> {
    public GenderTypeService(GenderTypeRepository genderTypeRepository) {
        super(genderTypeRepository);
    }
}
