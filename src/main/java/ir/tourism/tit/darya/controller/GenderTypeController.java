/**
 * @author I.Soltani
 */

package ir.tourism.tit.darya.controller;

import ir.tourism.tit.darya.common.Singletons;
import ir.tourism.tit.darya.model.dto.request.GenderTypeCrudRequestDto;
import ir.tourism.tit.darya.model.dto.response.GenderTypeCrudResponseDto;
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
    public ResponseEntity<GenderTypeCrudResponseDto> createGenderType (@RequestBody GenderTypeCrudRequestDto inputDto){
        GenderType genderType = genderTypeService.create(modelMapper.map(inputDto, GenderType.class));
        GenderTypeCrudResponseDto outputDto = modelMapper.map(genderType, GenderTypeCrudResponseDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<GenderTypeCrudResponseDto> updateGenderType (@RequestBody GenderTypeCrudRequestDto inputDto){
        GenderType genderType = modelMapper.map(inputDto, GenderType.class);
        genderType = genderTypeService.update(genderType);
        GenderTypeCrudResponseDto outputDto = modelMapper.map(genderType, GenderTypeCrudResponseDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<GenderTypeCrudResponseDto> readGenderType (@RequestBody GenderTypeCrudRequestDto inputDto) {
        GenderType genderType = genderTypeService.readById(inputDto.getId());
        GenderTypeCrudResponseDto outputDto = modelMapper.map(genderType, GenderTypeCrudResponseDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/readAll")
    public ResponseEntity<List<GenderTypeCrudResponseDto>> readAllGenderType (){
        List<GenderTypeCrudResponseDto> responseDtoList = new ArrayList<>();
        List<GenderType> genderTypeList = genderTypeService.readAll();
        for (GenderType genderType : genderTypeList)
            responseDtoList.add(modelMapper.map(genderType, GenderTypeCrudResponseDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<GenderTypeCrudResponseDto> deleteGenderType (@RequestBody GenderTypeCrudRequestDto inputDto){
        genderTypeService.delete(inputDto.getId());
        return new ResponseEntity<>(new GenderTypeCrudResponseDto("Deleted!"), HttpStatus.OK);
    }
}
