/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    @Column(name = "CREATE_DATE")
    @Type(type = "java.sql.Timestamp")
    private Timestamp createDate;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Type(type = "java.sql.Timestamp")
    private Timestamp lastModifiedDate;
    @Column(name = "CHECKSUM")
    private String checksum = "checksum";
    @Column(name = "ACTIVE_ENUM_ID")
    private Integer activeEnumId = 1;

    public abstract Long getId();
}

