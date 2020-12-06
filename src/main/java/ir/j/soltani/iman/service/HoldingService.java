package ir.j.soltani.iman.service;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.Holding;
import ir.j.soltani.iman.repository.HoldingRepository;
import org.springframework.stereotype.Service;

@Service
public class HoldingService extends BaseEntityServiceJpaCrudImpl<Holding, HoldingRepository> {
    public HoldingService(HoldingRepository repository) {
        super(repository);
    }
}
