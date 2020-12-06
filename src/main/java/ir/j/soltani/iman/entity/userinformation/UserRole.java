package ir.j.soltani.iman.entity.userinformation;

import ir.j.soltani.iman.common.BaseEntity;
import ir.j.soltani.iman.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "to_user_role")
@Where(clause = "active_enum_id<>2")
public class UserRole extends BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(generator = "user_role_seq", strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID" , referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "COMPANY_ID" , referencedColumnName = "id")
    private Company company;
}
