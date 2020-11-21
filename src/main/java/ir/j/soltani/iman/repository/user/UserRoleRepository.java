/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository.user;

import ir.j.soltani.iman.model.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByUser_Id(Long UserId);
}
