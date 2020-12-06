/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.model.dto.company;

import ir.j.soltani.iman.model.dto.company.CompanyDto;
import ir.j.soltani.iman.model.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CompanyCreateRequestDto {
    private CompanyDto companyDto;
    private UserDto userDto;
}