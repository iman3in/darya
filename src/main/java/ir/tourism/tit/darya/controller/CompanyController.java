/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.controller;

import ir.tourism.tit.darya.controller.response.TITResponseBody;
import ir.tourism.tit.darya.controller.response.TITResponseCode;
import ir.tourism.tit.darya.model.entity.Company;
import ir.tourism.tit.darya.model.dto.CompanyDto;
import ir.tourism.tit.darya.service.CompanyService;
import ir.tourism.tit.darya.common.Singletons;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.ReflectionException;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public ResponseEntity<TITResponseBody> createGender (@RequestBody CompanyDto companyDto) throws SQLException, ReflectionException {
        Company company = getEntity(companyDto);
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, getDTO(companyService.createEntity(company)));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<TITResponseBody> readGender (@RequestBody Long id) throws SQLException, ReflectionException {
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, getDTO(companyService.readById(id)));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TITResponseBody> updateGender (@RequestBody CompanyDto companyDto) throws SQLException, ReflectionException {
        Company company = getEntity(companyDto);
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, getDTO(companyService.updateEntity(company)));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<TITResponseBody> deleteGender (@RequestBody CompanyDto companyDto) throws SQLException, ReflectionException {
        Company company = getEntity(companyDto);
        companyService.delete(company);
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, "Deleted");
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/readAll")
    public ResponseEntity<TITResponseBody> readAllGender () throws SQLException, ReflectionException {
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, StreamSupport.stream(companyService.readAllEntities().spliterator(), false).map(this::getDTO)
                .collect(Collectors.toList()));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    private CompanyDto getDTO(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    private Company getEntity(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }
}
