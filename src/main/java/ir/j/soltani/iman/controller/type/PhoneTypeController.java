/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller.type;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.controller.type.dto.PhoneTypeDto;
import ir.j.soltani.iman.entity.type.PhoneType;
import ir.j.soltani.iman.service.type.PhoneTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("phoneType")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhoneTypeController {
    private final PhoneTypeService phoneTypeService;
    private final ModelMapper modelMapper;

    @Autowired
    public PhoneTypeController(PhoneTypeService phoneTypeService) {
        this.phoneTypeService = phoneTypeService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<PhoneTypeDto> createPhoneType (@RequestBody PhoneTypeDto inputDto){
        PhoneType phoneType = phoneTypeService.create(modelMapper.map(inputDto, PhoneType.class));
        PhoneTypeDto outputDto = modelMapper.map(phoneType, PhoneTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<PhoneTypeDto> updatePhoneType (@RequestBody PhoneTypeDto inputDto){
        PhoneType phoneType = modelMapper.map(inputDto, PhoneType.class);
        phoneType = phoneTypeService.update(phoneType);
        PhoneTypeDto outputDto = modelMapper.map(phoneType, PhoneTypeDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findById")
    public ResponseEntity<PhoneTypeDto> findPhoneTypeById (@RequestBody Long id) {
        PhoneType phoneType = phoneTypeService.readById(id);
        PhoneTypeDto outputDto = modelMapper.map(phoneType, PhoneTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<PhoneTypeDto>> findAllPhoneType (){
        List<PhoneTypeDto> responseDtoList = new ArrayList<>();
        List<PhoneType> phoneTypeList = phoneTypeService.readAll();
        for (PhoneType phoneType : phoneTypeList)
            responseDtoList.add(modelMapper.map(phoneType, PhoneTypeDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePhoneType (@RequestBody Long id){
        phoneTypeService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
