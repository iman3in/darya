/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller.company;

import ir.j.soltani.iman.controller.user.UserDto;
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
