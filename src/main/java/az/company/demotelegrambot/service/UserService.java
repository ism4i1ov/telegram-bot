package az.company.demotelegrambot.service;

import az.company.demotelegrambot.dto.UsersDto;
import az.company.demotelegrambot.entity.UserEntity;
import az.company.demotelegrambot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UsersDto dto) {
        return userRepository.save(UserEntity.toEntity(dto));
    }

    public boolean existsUser(Long chatId) {
        return userRepository.existsByChatId(chatId);
    }

    public List<UsersDto> getUserByDevLangName(String name) {
        List<UserEntity> allByDevelopmentLangName = userRepository.getAllByDevelopmentLangName(name);
        return allByDevelopmentLangName.stream().map(UsersDto::toDto).collect(Collectors.toList());
    }
}
