/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service.type;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.type.SocialNetworkType;
import ir.j.soltani.iman.repository.type.SocialNetworkTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkTypeService extends BaseEntityServiceJpaCrudImpl<SocialNetworkType, SocialNetworkTypeRepository> {
    public SocialNetworkTypeService(SocialNetworkTypeRepository repository) {
        super(repository);
    }
}
