/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository.userinformation;

import ir.j.soltani.iman.entity.userinformation.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByUser_Id(Long UserId);
}
