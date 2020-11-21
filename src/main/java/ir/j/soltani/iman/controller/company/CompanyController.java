/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller.company;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.model.dto.company.CompanyCreateRequestDto;
import ir.j.soltani.iman.model.dto.company.CompanyDto;
import ir.j.soltani.iman.model.entity.company.Company;
import ir.j.soltani.iman.model.entity.user.User;
import ir.j.soltani.iman.service.company.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createCompany (@RequestBody CompanyCreateRequestDto inputDto){
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

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCompany (@RequestBody Long id){
        companyService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
