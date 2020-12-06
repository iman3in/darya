/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.entity.type;

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
@Entity(name = "TB_PHONE_TYPE")
@Where(clause = "active_enum_id<>2")
public class PhoneType extends BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(generator = "PHONE_TYPE_SEQ", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
