package ir.tourism.tit.darya.model.dto.response;

import ir.tourism.tit.darya.common.base.model.BaseResponseDto;

public class GenderTypeCrudResponseDto extends BaseResponseDto {
    private Long id;
    private String name;
    private String description;

    public GenderTypeCrudResponseDto() {
    }

    public GenderTypeCrudResponseDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public GenderTypeCrudResponseDto(String message) {
        super(message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
