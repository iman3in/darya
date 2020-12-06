/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.entity.userinformation;

import ir.j.soltani.iman.common.BaseEntity;
import ir.j.soltani.iman.entity.type.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_phone")
@Where(clause = "active_enum_id<>2")
public class Phone extends BaseEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "phone_seq", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PHONE_TYPE_ID" , referencedColumnName = "id")
    private PhoneType phoneType;

    @ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_information_id" , referencedColumnName = "id")
    private UserInformation userInformation;
}
