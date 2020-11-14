/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.dto;

import ir.tourism.tit.darya.model.dto.crud.CompanyDto;
import ir.tourism.tit.darya.model.dto.crud.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CreateCompanyDto {
    private CompanyDto companyDto;
    private UserDto userDto;
}
