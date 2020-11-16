/**
 * @author:I.Soltani
 */

package ir.tourism.tit.darya.model.dto.crud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
}
