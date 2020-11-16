/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.model.entity;

import ir.tourism.tit.darya.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "TB_COMPANY")
public class Company implements BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(generator = "COMPANY_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private User user;

    @Column(name = "HOLDING_NAME")
    private String holdingName;

    @Column(name = "HOLDING__COMPANY_FLAG")
    private Long holdingCompanyFlag;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_CODE")
    private Long companyCode;

    @Column(name = "REGISTRATION_NUMBER")
    private Long registrationNumber;

    @Column(name = "REGISTRATION_PLACE_ID")
    private Long registrationPlaceId;

    @Column(name = "RELATION_LEGAL_TYPE_ID")
    private Long relationLegalTypeId;

    @Column(name = "INSTITUTE_LEGAL_TYPE_ID")
    private Long instituteLegalTypeId;

    @Column(name = "ECONOMIC_SECTOR_TYPE_ID")
    private Long economicSectorTypeId;

    @Column(name = "STATUS__LEGAL_TYPES_ID")
    private Long statusLegalTypesId;

    @Column(name = "CEO")
    private String ceo;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "WEB_SITE")
    private String webSite;

    @Column(name = "ECONOMY_NUMBER")
    private String economyNumber;

    @Column(name = "NATIONAL_ID_NUMBER")
    private String nationalIdNumber;

    @Column(name = "WORKERS_COUNT")
    private Long workersCount;

    @Column(name = "SISTER_COMPANY_FLAG")
    private Long sisterCompanyFlag;

    @Column(name = "STOCK")
    private Long stock;

    @Column(name = "INVESTMENT")
    private Long investment;

    @Column(name = "BELONGING")
    private Long belonging;

    @Column(name = "REGISTER_DATE")
    private Date registerDate;

    @Column(name = "NEWS_LETTER_NUMBER")
    private Long newsLetterNumber;

    @Column(name = "NOTICE_LETTER_NUMBER")
    private Long noticeLetterNumber;

    @Column(name = "NOTICE_LETTER_DATE")
    private Date noticeLetterDate;

    @Column(name = "LOGO_SCAN_URL")
    private String logoScanUrl;

    @Column(name = "ENGLISH_LOGO_SCAN_URL")
    private String englishLogoScanUrl;

    @Column(name = "STAMP_SCAN")
    private String stampScanUrl;

    @Column(name = "ORGANIZATIONAL_CHART_SCAN_URL")
    private String organizationalChartScanUrl;

    @Column(name = "EZHARNAMEH_SCAN_URL")
    private String ezharnamehScanUrl;

    @Column(name = "END_NEWS_LETTER_SCAN_URL")
    private String endNewsLetterScanUrl;

    @Column(name = "ENGLISH_COMPANY_NAME")
    private String englishCompanyName;

    @Column(name = "WORKING_END_DATE")
    private Date workingEndDate;
}
