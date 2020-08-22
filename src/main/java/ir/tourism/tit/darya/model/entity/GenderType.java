/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.entity;

import ir.tourism.tit.darya.model.base.BaseEntity;
import ir.tourism.tit.darya.model.base.Column;
import ir.tourism.tit.darya.model.base.Entity;

import java.util.Date;

@Entity (tableName = "TB_GENDER_TYPES")
public class GenderType extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_DATE", insertable = false, updatable = false)
    private Date createDate;

    @Column(name = "LAST_MODIFIED_DATE",insertable = false, updatable = false)
    private Date lastModifiedDate;

    @Column(name = "CHECKSUM", insertable = false, updatable = false)
    private String checksum;

    public GenderType() {
    }

    public GenderType(String name, String description, Date createDate, Date lastModifiedDate, String checksum) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.checksum = checksum;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
