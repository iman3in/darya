/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.repository.user;

import ir.j.soltani.iman.model.entity.user.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findAllByUserInformation_Id(Long userInformationId);
}
