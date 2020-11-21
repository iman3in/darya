package ir.j.soltani.iman.model.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CompanyDto {
    private Long id;
    private String holdingName;
    private Long holdingCompanyFlag;
    private String companyName;
    private Long companyCode;
    private Long registrationNumber;
    private Long registrationPlaceId;
    private Long relationLegalTypeId;
    private Long instituteLegalTypeId;
    private Long economicSectorTypeId;
    private Long statusLegalTypesId;
    private String ceo;
    private Long priority;
    private String webSite;
    private String economyNumber;
    private String nationalIdNumber;
    private Long workersCount;
    private Long sisterCompanyFlag;
    private Long stock;
    private Long investment;
    private Long belonging;
    private Date registerDate;
    private Long newsLetterNumber;
    private Long noticeLetterNumber;
    private Date noticeLetterDate;
    private String logoScanUrl;
    private String englishLogoScanUrl;
    private String stampScanUrl;
    private String organizationalChartScanUrl;
    private String ezharnamehScanUrl;
    private String endNewsLetterScanUrl;
    private String englishCompanyName;
    private Date workingEndDate;
}
