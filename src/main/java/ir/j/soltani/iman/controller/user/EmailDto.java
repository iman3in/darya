package ir.j.soltani.iman.controller.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailDto {
    private Long id;
    private String emailAddress;
    private Long userId;
}
