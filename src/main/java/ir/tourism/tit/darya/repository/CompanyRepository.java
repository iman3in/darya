/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.repository;

import ir.tourism.tit.darya.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUser_Id(Long userId);
}
