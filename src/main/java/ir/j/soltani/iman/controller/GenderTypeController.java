/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.controller;

import ir.tourism.tit.darya.common.Singletons;
import ir.tourism.tit.darya.model.dto.crud.GenderTypeDto;
import ir.tourism.tit.darya.model.entity.GenderType;
import ir.tourism.tit.darya.service.GenderTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("genderType")
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
    public ResponseEntity<GenderTypeDto> createGenderType (@RequestBody GenderTypeDto inputDto){
        GenderType genderType = genderTypeService.create(modelMapper.map(inputDto, GenderType.class));
        GenderTypeDto outputDto = modelMapper.map(genderType, GenderTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<GenderTypeDto> updateGenderType (@RequestBody GenderTypeDto inputDto){
        GenderType genderType = modelMapper.map(inputDto, GenderType.class);
        genderType = genderTypeService.update(genderType);
        GenderTypeDto outputDto = modelMapper.map(genderType, GenderTypeDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<GenderTypeDto> readGenderType (@RequestBody Long id) {
        GenderType genderType = genderTypeService.readById(id);
        GenderTypeDto outputDto = modelMapper.map(genderType, GenderTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/readAll")
    public ResponseEntity<List<GenderTypeDto>> readAllGenderType (){
        List<GenderTypeDto> responseDtoList = new ArrayList<>();
        List<GenderType> genderTypeList = genderTypeService.readAll();
        for (GenderType genderType : genderTypeList)
            responseDtoList.add(modelMapper.map(genderType, GenderTypeDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteGenderType (@RequestBody Long id){
        genderTypeService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
