package ir.j.soltani.iman.repository.type;

import ir.j.soltani.iman.entity.type.SocialNetworkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkTypeRepository extends JpaRepository<SocialNetworkType, Long> {
}
