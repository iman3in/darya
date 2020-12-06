/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.entity.userinformation;

import ir.j.soltani.iman.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "tb_user_information")
@Where(clause = "active_enum_id<>2")
public class UserInformation extends BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(generator = "user_information_seq", strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "userInformation", fetch = FetchType.LAZY)
    private List<Email> emailList;

    @OneToMany (mappedBy = "userInformation", fetch = FetchType.LAZY)
    private List<Phone> phoneList;
}
