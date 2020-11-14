/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository;

import ir.tourism.tit.darya.model.entity.GenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderTypeRepository extends JpaRepository<GenderType, Long> {
}
