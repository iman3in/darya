/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository.type;

import ir.j.soltani.iman.model.entity.type.GenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderTypeRepository extends JpaRepository<GenderType, Long> {
}
