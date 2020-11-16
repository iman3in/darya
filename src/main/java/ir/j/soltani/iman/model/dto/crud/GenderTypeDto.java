package ir.tourism.tit.darya.model.dto.crud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GenderTypeDto {
    private Long id;
    private String name;
    private String description;
}
