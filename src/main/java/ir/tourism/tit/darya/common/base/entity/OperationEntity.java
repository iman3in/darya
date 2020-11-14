/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.common.base.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
public class OperationEntity {
    @Id
    @Column(name = "ID", columnDefinition = "CHAR(32)", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    public String getId() {
        return id;
    }

    /**
     * @TODO
     * Add CreateDate and LastModifiedDate and checkSum
     */
}
