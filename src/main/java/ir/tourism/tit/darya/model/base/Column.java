/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Indicates that if this field can be updated in database.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String name();
    boolean updatable() default true;
    boolean insertable() default true;
}
