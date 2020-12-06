package ir.j.soltani.iman.controller.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneDto {
    private Long id;
    private String phoneNumber;
    private Long userId;
}
