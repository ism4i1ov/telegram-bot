package az.company.demotelegrambot.bot;


import az.company.demotelegrambot.commands.RegisterStateEnum;
import az.company.demotelegrambot.commands.StartStateEnum;
import az.company.demotelegrambot.entity.UserEntity;
import az.company.demotelegrambot.service.BotService;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("classpath:telegram.properties")
public class Bot extends TelegramLongPollingBot {

    public Update update;
    public Enum botStateEnum;
    public UserEntity userEntity;

    private final Logger LOGGER = LogManager.getLogger(Bot.class);
    @Autowired
    private BotService botService;

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        this.update = update;
        LOGGER.info("Request from bot chatId: " +
                update.getMessage().getChatId() + " username: " +
                update.getMessage().getChat().getUserName() + " text: " + update.getMessage().getText() + " Language " + update.getMessage().getFrom().getLanguageCode());
        if (botStateEnum == null && haveCommand(text)) botService.checkCommandAndStart(this);
        else if (botStateEnum != null) botService.checkCommandAndStart(this);
    }

    private boolean haveCommand(String command) {
        if ("/register".equalsIgnoreCase(command)) {
            botStateEnum = RegisterStateEnum.FIRST;
            return true;
        } else if ("/start".equalsIgnoreCase(command)) {
            botStateEnum = StartStateEnum.FIRST;
            return true;
        } else return false;
    }


    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public void setBotStateEnum(Enum botStateEnum) {
        this.botStateEnum = botStateEnum;
    }

    public void setUserEntity(UserEntity entity) {
        userEntity = entity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
