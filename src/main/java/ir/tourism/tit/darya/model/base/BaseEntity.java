/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.base;

public abstract class BaseEntity {

    @Column(name = "ID", insertable = false)
    private Long id;

    public BaseEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}