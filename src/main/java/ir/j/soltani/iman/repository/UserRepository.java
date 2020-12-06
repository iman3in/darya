/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository;

import ir.j.soltani.iman.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByToken(String token);
}
