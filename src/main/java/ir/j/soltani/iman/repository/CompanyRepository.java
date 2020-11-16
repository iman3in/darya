/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository;

import ir.j.soltani.iman.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUser_Id(Long userId);
}
