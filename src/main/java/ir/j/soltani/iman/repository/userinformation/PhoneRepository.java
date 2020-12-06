package ir.j.soltani.iman.repository.userinformation;

import ir.j.soltani.iman.entity.userinformation.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findAllByUserInformation_Id(Long id);
}