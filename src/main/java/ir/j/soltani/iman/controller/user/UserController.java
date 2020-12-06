package ir.j.soltani.iman.controller.user;

import ir.j.soltani.iman.common.Singletons;
import ir.j.soltani.iman.model.dto.user.LoginDto;
import ir.j.soltani.iman.model.dto.user.UserDto;
import ir.j.soltani.iman.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService) {
        this.userService = userService;
        this.modelMapper = Singletons.getModelMapper();
    }

//    @PostMapping("/updateUserPassword")
//    public ResponseEntity<Boolean> updateUserPassword (@RequestBody UserDto userPasswordDto){
//        /**
//         * @Todo
//         * Changing user password
//         */
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody LoginDto loginDto) {
        String token = userService.login(loginDto.getUsername(), loginDto.getPassword());
        return new ResponseEntity(token, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout (String token) {
        userService.logout(token);
        return new ResponseEntity(true , HttpStatus.OK);
    }
}
