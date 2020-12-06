/**
 * @author I.Soltani
 */

package ir.j.soltani.iman.service;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.entity.UserInformation;
import ir.j.soltani.iman.repository.UserRepository;
import ir.j.soltani.iman.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends BaseEntityServiceJpaCrudImpl<User, UserRepository> {
    private UserInformationService userInformationService;

    public UserService(UserRepository repository, UserInformationService userInformationService) {
        super(repository);
        this.userInformationService = userInformationService;
    }

    @Override
    @Transactional
    public User create(@Valid User user){
        UserInformation userInformation = new UserInformation();
        User outUser = super.create(user);
        userInformation.setUser(outUser);
        userInformationService.create(userInformation);
        return outUser;
    }

    public String login(@NotEmpty String username, @NotEmpty String password){
        Optional<User> userOptional = repository.findByUsernameAndPassword(username, password);
        if (!userOptional.isPresent())
            throw new IllegalArgumentException("User Not found!");
        if (!userOptional.get().getPassword().equals(password))
            throw new IllegalArgumentException("Wrong Password!");
        /**
         * @Todo
         * should be change to JWT
         */
        String token = UUID.randomUUID().toString();
        userOptional.get().setToken(token);
        /*********************************/
        User user = update(userOptional.get());
        return user.getToken();
    }

    public User findByToken(@NotEmpty String token){
        Optional<User> user = repository.findByToken(token);
        if (!user.isPresent())
            throw new IllegalArgumentException("You'r Not Logged in!");
        return user.get();
    }

    public void logout(String token) {
        User user = findByToken(token);
        user.setToken(null);
        update(user);
    }

    public Long authorize(String token) {
        User user = findByToken(token);
        return user.getId();
    }


}
