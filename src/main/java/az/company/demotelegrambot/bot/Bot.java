package az.company.demotelegrambot.bot;


import az.company.demotelegrambot.commands.StartCommand;
import az.company.demotelegrambot.service.UserService;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("classpath:telegram.properties")
public class Bot extends TelegramLongPollingBot {

    private final Logger LOGGER = LogManager.getLogger(Bot.class);
    private final UserService userService;
    private final StartCommand startCommand;

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

    public Bot(UserService userService, StartCommand startCommand) {
        this.userService = userService;
        this.startCommand = startCommand;
    }


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        System.err.println(update.getMessage().getFrom());
        System.err.println(update.getMessage().getText());
        if (update.getMessage().getText().equalsIgnoreCase("/register")) {
            if (startCommand.start(update.getMessage())) {
                execute(new SendMessage().setChatId(update.getMessage().getChatId()).setText("Registered successfully"));
            }else {
                execute(new SendMessage().setChatId(update.getMessage().getChatId()).setText("This account exist"));
            }
        }
    }


    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
