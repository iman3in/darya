/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository.base;

import ir.tourism.tit.darya.model.base.BaseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity> {

}