package az.company.demotelegrambot.service;

import az.company.demotelegrambot.entity.UserEntity;
import az.company.demotelegrambot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    private final UserRepository userRepository;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public boolean existsUser(Long chatId) {
        return userRepository.existsByChatId(chatId);
    }
}
