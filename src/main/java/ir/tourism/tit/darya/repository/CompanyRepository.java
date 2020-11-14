/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository;

import ir.tourism.tit.darya.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
