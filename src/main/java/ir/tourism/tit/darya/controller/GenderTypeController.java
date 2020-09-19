/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.controller;

import ir.tourism.tit.darya.controller.response.TITResponseBody;
import ir.tourism.tit.darya.controller.response.TITResponseCode;
import ir.tourism.tit.darya.model.entity.GenderType;
import ir.tourism.tit.darya.model.dto.GenderTypeDto;
import ir.tourism.tit.darya.service.GenderTypeService;
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
@RequestMapping("gender")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenderTypeController {
    private final GenderTypeService genderTypeService;
    private final ModelMapper modelMapper;

    @Autowired
    public GenderTypeController(GenderTypeService genderTypeService) {
        this.genderTypeService = genderTypeService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<TITResponseBody> createGender (@RequestBody GenderTypeDto genderTypeDto) throws SQLException, ReflectionException {
        GenderType genderType = getEntity(genderTypeDto);
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, getDTO(genderTypeService.createEntity(genderType)));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<TITResponseBody> readGender (@RequestBody Long id) throws SQLException, ReflectionException {
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, getDTO(genderTypeService.readById(id)));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TITResponseBody> updateGender (@RequestBody GenderTypeDto genderTypeDto) throws SQLException, ReflectionException {
        GenderType genderType = getEntity(genderTypeDto);
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, getDTO(genderTypeService.updateEntity(genderType)));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<TITResponseBody> deleteGender (@RequestBody GenderTypeDto genderTypeDto) throws SQLException, ReflectionException {
        GenderType genderType = getEntity(genderTypeDto);
        genderTypeService.delete(genderType);
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, "Deleted");
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    @PostMapping("/readAll")
    public ResponseEntity<TITResponseBody> readAllGender () throws SQLException, ReflectionException {
        TITResponseBody titResponseBody = new TITResponseBody(TITResponseCode.SUCCESS, StreamSupport.stream(genderTypeService.readAllEntities().spliterator(), false).map(this::getDTO)
                .collect(Collectors.toList()));
        return new ResponseEntity<>(titResponseBody, HttpStatus.OK);
    }

    private GenderTypeDto getDTO(GenderType genderType) {
        return modelMapper.map(genderType, GenderTypeDto.class);
    }

    private GenderType getEntity(GenderTypeDto genderTypeDto) {
        return modelMapper.map(genderTypeDto, GenderType.class);
    }
}
