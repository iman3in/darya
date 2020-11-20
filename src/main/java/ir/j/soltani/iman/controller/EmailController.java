/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.model.dto.crud.EmailDto;
import ir.j.soltani.iman.model.entity.Email;
import ir.j.soltani.iman.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("email")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {
    private final EmailService emailService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<EmailDto> createEmail (@RequestBody EmailDto inputDto){
        Email email = emailService.createUserEmail(modelMapper.map(inputDto, Email.class), inputDto.getUserId());
        EmailDto outputDto = modelMapper.map(email, EmailDto.class);
        outputDto.setUserId(email.getUserInformation().getUser().getId());
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<EmailDto> updateEmail (@RequestBody EmailDto inputDto){
        Email email = modelMapper.map(inputDto, Email.class);
        email = emailService.update(email);
        EmailDto outputDto = modelMapper.map(email, EmailDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/read")
    public ResponseEntity<EmailDto> readEmail (@RequestBody Long id) {
        Email email = emailService.readById(id);
        EmailDto outputDto = modelMapper.map(email, EmailDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/readByUserId")
    public ResponseEntity<List<EmailDto>> readEmailByUserId (@RequestBody Long userId){
        List<EmailDto> responseDtoList = new ArrayList<>();
        List<Email> emailList = emailService.readByUserId(userId);
        for (Email email : emailList)
            responseDtoList.add(modelMapper.map(email, EmailDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmail (@RequestBody Long id){
        emailService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
