package ir.j.soltani.iman.model.entity;

import ir.j.soltani.iman.common.BaseEntity;
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
    @GeneratedValue(generator = "user_role_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Company company;
}
