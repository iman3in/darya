/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller.user;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.model.dto.user.PhoneDto;
import ir.j.soltani.iman.model.entity.user.Phone;
import ir.j.soltani.iman.service.user.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("phone")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhoneController {
    private final PhoneService phoneService;
    private final ModelMapper modelMapper;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<PhoneDto> createPhone (@RequestBody PhoneDto inputDto){
        Phone phone = phoneService.createUserPhone(modelMapper.map(inputDto, Phone.class), inputDto.getUserId());
        PhoneDto outputDto = modelMapper.map(phone, PhoneDto.class);
        outputDto.setUserId(phone.getUserInformation().getUser().getId());
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<PhoneDto> updatePhone (@RequestBody PhoneDto inputDto){
        Phone phone = modelMapper.map(inputDto, Phone.class);
        phone = phoneService.update(phone);
        PhoneDto outputDto = modelMapper.map(phone, PhoneDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<PhoneDto> readPhone (@RequestBody Long id) {
        Phone phone = phoneService.readById(id);
        PhoneDto outputDto = modelMapper.map(phone, PhoneDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/readByUserId")
    public ResponseEntity<List<PhoneDto>> readPhoneByUserId (@RequestBody Long userId){
        List<PhoneDto> responseDtoList = new ArrayList<>();
        List<Phone> phoneList = phoneService.readByUserId(userId);
        for (Phone phone : phoneList)
            responseDtoList.add(modelMapper.map(phone, PhoneDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePhone (@RequestBody Long id){
        phoneService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
