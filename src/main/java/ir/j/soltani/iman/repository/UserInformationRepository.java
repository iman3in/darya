/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository;

import ir.j.soltani.iman.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    Optional<UserInformation> findByUser_Id(Long userId);
}
