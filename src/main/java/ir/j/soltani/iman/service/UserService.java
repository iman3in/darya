package ir.tourism.tit.darya.service;

import ir.tourism.tit.darya.common.service.BaseEntityServiceJpaCrudImpl;
import ir.tourism.tit.darya.model.entity.User;
import ir.tourism.tit.darya.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityServiceJpaCrudImpl<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
