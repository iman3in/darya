/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.entity;

import ir.tourism.tit.darya.common.base.entity.BaseEntity;

import javax.persistence.*;


@Entity(name = "TB_GENDER_TYPES")
public class GenderType extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public GenderType() {
    }

    public GenderType(String name, String description) {
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
