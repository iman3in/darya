/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.model.dto.CreateCompanyDto;
import ir.j.soltani.iman.model.dto.crud.CompanyDto;
import ir.j.soltani.iman.model.entity.Company;
import ir.j.soltani.iman.model.entity.User;
import ir.j.soltani.iman.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("company")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController {
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
        this.modelMapper = Singletons.getModelMapper();
    }

//    @PostMapping("/create")
//    public ResponseEntity<CompanyCrudDto> createCompany (@RequestBody CompanyCrudRequestDto inputDto){
//        Company company = companyService.create(modelMapper.map(inputDto, Company.class));
//        CompanyCrudDto outputDto = modelMapper.map(company, CompanyCrudDto.class);
//        return new ResponseEntity(outputDto, HttpStatus.OK);
//    }

    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createCompany (@RequestBody CreateCompanyDto inputDto){
        Company company =
                companyService.createCompanyUser(
                        modelMapper.map(inputDto.getCompanyDto(), Company.class),
                        modelMapper.map(inputDto.getUserDto(), User.class));
        CompanyDto outputDto = modelMapper.map(company, CompanyDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CompanyDto> updateCompany (@RequestBody CompanyDto inputDto){
        Company company = modelMapper.map(inputDto, Company.class);
        company = companyService.update(company);
        CompanyDto outputDto = modelMapper.map(company, CompanyDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<CompanyDto> readCompany (@RequestBody Long id) {
        Company company = companyService.readById(id);
        CompanyDto outputDto = modelMapper.map(company, CompanyDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/readByUserId")
    public ResponseEntity<CompanyDto> readByUserIdCompany (@RequestBody Long userId) {
        Company company = companyService.readByUserId(userId);
        CompanyDto outputDto = modelMapper.map(company, CompanyDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/readAll")
    public ResponseEntity<List<CompanyDto>> readAllCompany (){
        List<CompanyDto> responseDtoList = new ArrayList<>();
        List<Company> companyList = companyService.readAll();
        for (Company company : companyList)
            responseDtoList.add(modelMapper.map(company, CompanyDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCompany (@RequestBody Long id){
        companyService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
