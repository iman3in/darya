package ir.tourism.tit.darya.model.dto;

import ir.tourism.tit.darya.model.base.BaseDto;

import java.util.Date;

public class CompanyDto extends BaseDto {
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

//    private String logoScan;
//
//    private String englishLogoScan;
//
//    private String stampScan;
//
//    private String organizationalChartScan;
//
//    private String ezharnamehScan;
//
//    private String endNewsLetterScan;

    private String englishCompanyName;

    private Date workingEndDate;

    private Long activityEnumId;

    public CompanyDto() {
    }

    public CompanyDto(String holdingName, Long holdingCompanyFlag, String companyName, Long companyCode, Long registrationNumber, Long registrationPlaceId, Long relationLegalTypeId, Long instituteLegalTypeId, Long economicSectorTypeId, Long statusLegalTypesId, String ceo, Long priority, String webSite, String economyNumber, String nationalIdNumber, Long workersCount, Long sisterCompanyFlag, Long stock, Long investment, Long belonging, Date registerDate, Long newsLetterNumber, Long noticeLetterNumber, Date noticeLetterDate, String logoScan, String englishLogoScan, String stampScan, String organizationalChartScan, String ezharnamehScan, String endNewsLetterScan, String englishCompanyName, Date workingEndDate, Long activityEnumId) {
        this.holdingName = holdingName;
        this.holdingCompanyFlag = holdingCompanyFlag;
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.registrationNumber = registrationNumber;
        this.registrationPlaceId = registrationPlaceId;
        this.relationLegalTypeId = relationLegalTypeId;
        this.instituteLegalTypeId = instituteLegalTypeId;
        this.economicSectorTypeId = economicSectorTypeId;
        this.statusLegalTypesId = statusLegalTypesId;
        this.ceo = ceo;
        this.priority = priority;
        this.webSite = webSite;
        this.economyNumber = economyNumber;
        this.nationalIdNumber = nationalIdNumber;
        this.workersCount = workersCount;
        this.sisterCompanyFlag = sisterCompanyFlag;
        this.stock = stock;
        this.investment = investment;
        this.belonging = belonging;
        this.registerDate = registerDate;
        this.newsLetterNumber = newsLetterNumber;
        this.noticeLetterNumber = noticeLetterNumber;
        this.noticeLetterDate = noticeLetterDate;
//        this.logoScan = logoScan;
//        this.englishLogoScan = englishLogoScan;
//        this.stampScan = stampScan;
//        this.organizationalChartScan = organizationalChartScan;
//        this.ezharnamehScan = ezharnamehScan;
//        this.endNewsLetterScan = endNewsLetterScan;
        this.englishCompanyName = englishCompanyName;
        this.workingEndDate = workingEndDate;
        this.activityEnumId = activityEnumId;
    }

    public String getHoldingName() {
        return holdingName;
    }

    public void setHoldingName(String holdingName) {
        this.holdingName = holdingName;
    }

    public Long getHoldingCompanyFlag() {
        return holdingCompanyFlag;
    }

    public void setHoldingCompanyFlag(Long holdingCompanyFlag) {
        this.holdingCompanyFlag = holdingCompanyFlag;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Long companyCode) {
        this.companyCode = companyCode;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Long getRegistrationPlaceId() {
        return registrationPlaceId;
    }

    public void setRegistrationPlaceId(Long registrationPlaceId) {
        this.registrationPlaceId = registrationPlaceId;
    }

    public Long getRelationLegalTypeId() {
        return relationLegalTypeId;
    }

    public void setRelationLegalTypeId(Long relationLegalTypeId) {
        this.relationLegalTypeId = relationLegalTypeId;
    }

    public Long getInstituteLegalTypeId() {
        return instituteLegalTypeId;
    }

    public void setInstituteLegalTypeId(Long instituteLegalTypeId) {
        this.instituteLegalTypeId = instituteLegalTypeId;
    }

    public Long getEconomicSectorTypeId() {
        return economicSectorTypeId;
    }

    public void setEconomicSectorTypeId(Long economicSectorTypeId) {
        this.economicSectorTypeId = economicSectorTypeId;
    }

    public Long getStatusLegalTypesId() {
        return statusLegalTypesId;
    }

    public void setStatusLegalTypesId(Long statusLegalTypesId) {
        this.statusLegalTypesId = statusLegalTypesId;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEconomyNumber() {
        return economyNumber;
    }

    public void setEconomyNumber(String economyNumber) {
        this.economyNumber = economyNumber;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public Long getWorkersCount() {
        return workersCount;
    }

    public void setWorkersCount(Long workersCount) {
        this.workersCount = workersCount;
    }

    public Long getSisterCompanyFlag() {
        return sisterCompanyFlag;
    }

    public void setSisterCompanyFlag(Long sisterCompanyFlag) {
        this.sisterCompanyFlag = sisterCompanyFlag;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getInvestment() {
        return investment;
    }

    public void setInvestment(Long investment) {
        this.investment = investment;
    }

    public Long getBelonging() {
        return belonging;
    }

    public void setBelonging(Long belonging) {
        this.belonging = belonging;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Long getNewsLetterNumber() {
        return newsLetterNumber;
    }

    public void setNewsLetterNumber(Long newsLetterNumber) {
        this.newsLetterNumber = newsLetterNumber;
    }

    public Long getNoticeLetterNumber() {
        return noticeLetterNumber;
    }

    public void setNoticeLetterNumber(Long noticeLetterNumber) {
        this.noticeLetterNumber = noticeLetterNumber;
    }

    public Date getNoticeLetterDate() {
        return noticeLetterDate;
    }

    public void setNoticeLetterDate(Date noticeLetterDate) {
        this.noticeLetterDate = noticeLetterDate;
    }

//    public String getLogoScan() {
//        return logoScan;
//    }
//
//    public void setLogoScan(String logoScan) {
//        this.logoScan = logoScan;
//    }
//
//    public String getEnglishLogoScan() {
//        return englishLogoScan;
//    }
//
//    public void setEnglishLogoScan(String englishLogoScan) {
//        this.englishLogoScan = englishLogoScan;
//    }
//
//    public String getStampScan() {
//        return stampScan;
//    }
//
//    public void setStampScan(String stampScan) {
//        this.stampScan = stampScan;
//    }
//
//    public String getOrganizationalChartScan() {
//        return organizationalChartScan;
//    }
//
//    public void setOrganizationalChartScan(String organizationalChartScan) {
//        this.organizationalChartScan = organizationalChartScan;
//    }
//
//    public String getEzharnamehScan() {
//        return ezharnamehScan;
//    }
//
//    public void setEzharnamehScan(String ezharnamehScan) {
//        this.ezharnamehScan = ezharnamehScan;
//    }
//
//    public String getEndNewsLetterScan() {
//        return endNewsLetterScan;
//    }
//
//    public void setEndNewsLetterScan(String endNewsLetterScan) {
//        this.endNewsLetterScan = endNewsLetterScan;
//    }

    public String getEnglishCompanyName() {
        return englishCompanyName;
    }

    public void setEnglishCompanyName(String englishCompanyName) {
        this.englishCompanyName = englishCompanyName;
    }

    public Date getWorkingEndDate() {
        return workingEndDate;
    }

    public void setWorkingEndDate(Date workingEndDate) {
        this.workingEndDate = workingEndDate;
    }

    public Long getActivityEnumId() {
        return activityEnumId;
    }

    public void setActivityEnumId(Long activityEnumId) {
        this.activityEnumId = activityEnumId;
    }
}
