/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository.company;

import ir.j.soltani.iman.model.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
