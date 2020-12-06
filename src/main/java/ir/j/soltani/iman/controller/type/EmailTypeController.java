/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller.type;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.controller.type.dto.EmailTypeDto;
import ir.j.soltani.iman.entity.type.EmailType;
import ir.j.soltani.iman.service.type.EmailTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("emailType")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailTypeController {
    private final EmailTypeService emailTypeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmailTypeController(EmailTypeService emailTypeService) {
        this.emailTypeService = emailTypeService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<EmailTypeDto> createEmailType (@RequestBody EmailTypeDto inputDto){
        EmailType emailType = emailTypeService.create(modelMapper.map(inputDto, EmailType.class));
        EmailTypeDto outputDto = modelMapper.map(emailType, EmailTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<EmailTypeDto> updateEmailType (@RequestBody EmailTypeDto inputDto){
        EmailType emailType = modelMapper.map(inputDto, EmailType.class);
        emailType = emailTypeService.update(emailType);
        EmailTypeDto outputDto = modelMapper.map(emailType, EmailTypeDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findById")
    public ResponseEntity<EmailTypeDto> findEmailTypeById (@RequestBody Long id) {
        EmailType emailType = emailTypeService.readById(id);
        EmailTypeDto outputDto = modelMapper.map(emailType, EmailTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<EmailTypeDto>> findAllEmailType (){
        List<EmailTypeDto> responseDtoList = new ArrayList<>();
        List<EmailType> emailTypeList = emailTypeService.readAll();
        for (EmailType emailType : emailTypeList)
            responseDtoList.add(modelMapper.map(emailType, EmailTypeDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmailType (@RequestBody Long id){
        emailTypeService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
