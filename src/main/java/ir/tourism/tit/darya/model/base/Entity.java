/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {

    String tableName();
//    boolean cacheable() default false;
}
