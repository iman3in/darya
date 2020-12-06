package ir.j.soltani.iman.controller.holding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateHoldingDtoResponse {
    private Long id;
    private String holdingName;
    private Long holdingCode;
    private Long priority;
    private String description;
    private String holdingLogo;
    private Long holdingCompanyFlag;
}
