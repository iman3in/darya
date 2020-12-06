package ir.j.soltani.iman.controller.userinformation.dto;

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
    private Long emailTypeId;
}
