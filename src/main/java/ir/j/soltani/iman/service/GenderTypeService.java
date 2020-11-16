/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.service;

import ir.tourism.tit.darya.model.entity.GenderType;
import ir.tourism.tit.darya.repository.GenderTypeRepository;
import ir.tourism.tit.darya.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

@Service
public class GenderTypeService extends BaseEntityServiceJpaCrudImpl<GenderType, GenderTypeRepository> {
    public GenderTypeService(GenderTypeRepository genderTypeRepository) {
        super(genderTypeRepository);
    }
}
