/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.controller.type;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.controller.type.dto.SocialNetworkTypeDto;
import ir.j.soltani.iman.entity.type.SocialNetworkType;
import ir.j.soltani.iman.service.type.SocialNetworkTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("socialNetworkType")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SocialNetworkTypeController {
    private final SocialNetworkTypeService socialNetworkTypeService;
    private final ModelMapper modelMapper;

    @Autowired
    public SocialNetworkTypeController(SocialNetworkTypeService socialNetworkTypeService) {
        this.socialNetworkTypeService = socialNetworkTypeService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<SocialNetworkTypeDto> createSocialNetworkType (@RequestBody SocialNetworkTypeDto inputDto){
        SocialNetworkType socialNetworkType = socialNetworkTypeService.create(modelMapper.map(inputDto, SocialNetworkType.class));
        SocialNetworkTypeDto outputDto = modelMapper.map(socialNetworkType, SocialNetworkTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<SocialNetworkTypeDto> updateSocialNetworkType (@RequestBody SocialNetworkTypeDto inputDto){
        SocialNetworkType socialNetworkType = modelMapper.map(inputDto, SocialNetworkType.class);
        socialNetworkType = socialNetworkTypeService.update(socialNetworkType);
        SocialNetworkTypeDto outputDto = modelMapper.map(socialNetworkType, SocialNetworkTypeDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findById")
    public ResponseEntity<SocialNetworkTypeDto> findSocialNetworkTypeById (@RequestBody Long id) {
        SocialNetworkType socialNetworkType = socialNetworkTypeService.readById(id);
        SocialNetworkTypeDto outputDto = modelMapper.map(socialNetworkType, SocialNetworkTypeDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<SocialNetworkTypeDto>> findAllSocialNetworkType (){
        List<SocialNetworkTypeDto> responseDtoList = new ArrayList<>();
        List<SocialNetworkType> socialNetworkTypeList = socialNetworkTypeService.readAll();
        for (SocialNetworkType socialNetworkType : socialNetworkTypeList)
            responseDtoList.add(modelMapper.map(socialNetworkType, SocialNetworkTypeDto.class));
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteSocialNetworkType (@RequestBody Long id){
        socialNetworkTypeService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
