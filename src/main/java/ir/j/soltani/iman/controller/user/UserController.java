package ir.j.soltani.iman.controller.user;

import ir.j.soltani.iman.controller.user.dto.LoginDto;
import ir.j.soltani.iman.service.userinformation.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
