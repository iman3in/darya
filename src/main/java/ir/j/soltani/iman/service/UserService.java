package ir.j.soltani.iman.service;

import ir.j.soltani.iman.common.service.BaseEntityServiceJpaCrudImpl;
import ir.j.soltani.iman.repository.UserRepository;
import ir.j.soltani.iman.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityServiceJpaCrudImpl<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
