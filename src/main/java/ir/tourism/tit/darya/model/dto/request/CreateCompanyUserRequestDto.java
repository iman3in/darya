/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.dto.request;

import ir.tourism.tit.darya.common.base.model.BaseRequestDto;
import ir.tourism.tit.darya.model.entity.Company;

public class CreateCompanyUserRequestDto extends BaseRequestDto {
    private Company company;
    private Long userId;

    public CreateCompanyUserRequestDto() {
    }

    public CreateCompanyUserRequestDto(Company company, Long userId) {
        this.company = company;
        this.userId = userId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
