/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository;

import ir.j.soltani.iman.entity.GenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderTypeRepository extends JpaRepository<GenderType, Long> {
}
