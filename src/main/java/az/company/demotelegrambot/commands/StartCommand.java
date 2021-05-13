package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.dto.UserDto;
import az.company.demotelegrambot.entity.User;
import az.company.demotelegrambot.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class StartCommand {
    private final UserRepository userRepository;

    public StartCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerNewUserIfNotExists(Message message) {
        if (userRepository.existsByUsername(message.getChat().getUserName())) {
            return false;
        }
        UserDto userDto = UserDto.getInstance();
        userDto.setStateId(message.getFrom().getId())
                .setName(message.getChat().getFirstName())
                .setSurname(message.getChat().getFirstName())
                .setUsername(message.getChat().getUserName())
                .setChatId(message.getChatId())
                .setEmail("ism4i1ov@gmail.com")
                .setPhone("+994993429262");
        User user = User.toEntity(userDto);
        User save = userRepository.save(user);
        UserDto userDto1 = userDto.toDto(save);
        System.err.println(userDto1.toString());
        return true;
    }

    public boolean start(Message message) {
        return registerNewUserIfNotExists(message);
    }
}
