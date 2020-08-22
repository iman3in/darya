/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.dto;

import ir.tourism.tit.darya.model.base.BaseDto;

public class GenderTypeDto extends BaseDto {
    private  String name;
    private String description;

    public GenderTypeDto() {
    }

    public GenderTypeDto(String name, String description) {

        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
