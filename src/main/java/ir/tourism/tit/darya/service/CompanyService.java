/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.service;

import ir.tourism.tit.darya.repository.CompanyRepository;
import ir.tourism.tit.darya.model.entity.Company;
import ir.tourism.tit.darya.common.service.BaseEntityServiceJpaCrudImpl;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends BaseEntityServiceJpaCrudImpl<Company, CompanyRepository> {
    public CompanyService(CompanyRepository companyRepository) {
        super(companyRepository);
    }
}
