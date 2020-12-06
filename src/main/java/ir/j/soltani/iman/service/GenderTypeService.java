/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.repository.GenderTypeRepository;
import ir.j.soltani.iman.entity.GenderType;
import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

@Service
public class GenderTypeService extends BaseEntityServiceJpaCrudImpl<GenderType, GenderTypeRepository> {
    public GenderTypeService(GenderTypeRepository genderTypeRepository) {
        super(genderTypeRepository);
    }
}
