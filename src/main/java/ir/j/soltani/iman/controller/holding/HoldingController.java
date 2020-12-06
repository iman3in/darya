package ir.j.soltani.iman.controller.holding;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.entity.Holding;
import ir.j.soltani.iman.service.HoldingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HoldingController {
    private final HoldingService holdingService;
    private final ModelMapper modelMapper;

    public HoldingController(HoldingService holdingService) {
        this.holdingService = holdingService;
        this.modelMapper = Singletons.getModelMapper();
    }

    @PostMapping("/createHolding")
    public ResponseEntity<CreateHoldingDtoResponse> createHolding (@RequestBody CreateHoldingDtoRequest inputDto){
        Holding holding = holdingService.create(modelMapper.map(inputDto, Holding.class));
        CreateHoldingDtoResponse outputDto = modelMapper.map(holding, CreateHoldingDtoResponse.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/updateHolding")
    public ResponseEntity<UpdateHoldingDto> updateHolding (@RequestBody UpdateHoldingDto inputDto){
        Holding holding = modelMapper.map(inputDto, Holding.class);
        holding = holdingService.update(holding);
        UpdateHoldingDto outputDto = modelMapper.map(holding, UpdateHoldingDto.class);
        return new ResponseEntity<>(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findHoldingById/{id}")
    public ResponseEntity<FindHoldingDto> readHolding (@RequestBody Long id) {
        Holding holding = holdingService.readById(id);
        FindHoldingDto outputDto = modelMapper.map(holding, FindHoldingDto.class);
        return new ResponseEntity(outputDto, HttpStatus.OK);
    }

    @PostMapping("/findAllHolding")
    public ResponseEntity<List<FindHoldingDto>> readHolding () {
        List<Holding> holdingList = holdingService.readAll();
        List<FindHoldingDto> findHoldingDtoList = new ArrayList<>();
        for (Holding holding : holdingList)
            findHoldingDtoList.add(modelMapper.map(holding, FindHoldingDto.class));
        return new ResponseEntity(findHoldingDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteHolding (@RequestBody Long id){
        holdingService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
