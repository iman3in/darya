package ir.j.soltani.iman.entity;

import ir.j.soltani.iman.common.BaseEntity;
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
@Entity(name = "TB_HOLDINGS")
@Where(clause = "active_enum_id<>2")
public class Holding extends BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(generator = "COMPANY_SEQ", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HOLDING_NAME")
    private String holdingName;

    @Column(name = "HOLDING_CODE")
    private Long holdingCode;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "HOLDING_LOGO")
    private String holdingLogo;

    @Column(name = "HOLDING_COMPANY_FLAG")
    private Long holdingCompanyFlag;
}
