/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.base;

public abstract class BaseDto {
    private Long id;

    public BaseDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
