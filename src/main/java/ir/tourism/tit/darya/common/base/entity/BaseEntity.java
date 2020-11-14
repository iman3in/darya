/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.common.base.entity;

import javax.persistence.*;

@Entity
public class BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @TODO
     * Add CreateDate and LastModifiedDate and checkSum
     */
}
