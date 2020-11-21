/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.model.entity.user;

import ir.j.soltani.iman.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_emails")
@Where(clause = "active_enum_id<>2")
public class Email extends BaseEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "email_seq", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_address", unique = true, nullable = false)
    private String emailAddress;

    @ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_information_id" , referencedColumnName = "id")
    private UserInformation userInformation;
}
