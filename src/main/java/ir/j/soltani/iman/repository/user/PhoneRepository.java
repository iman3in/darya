package ir.j.soltani.iman.repository.user;

import ir.j.soltani.iman.model.entity.user.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findAllByUserInformation_Id(Long id);
}