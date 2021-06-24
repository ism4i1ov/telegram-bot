package az.company.demotelegrambot.bot;


import az.company.demotelegrambot.commands.RegisterStateEnum;
import az.company.demotelegrambot.service.BotService;
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

    public Update update;
    public Enum botStateEnum;

    private final Logger LOGGER = LogManager.getLogger(Bot.class);
    private final BotService botService;

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

    public Bot(BotService botService) {
        this.botService = botService;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        String returnText;
        this.update = update;
        if (botStateEnum == null && haveCommand(text)) returnText = botService.checkCommandAndStart(this);
        else if (botStateEnum != null) returnText = botService.checkCommandAndStart(this);
        else returnText = "Bele bir command yoxdur xaish edirik yeniden cehd edin!";
        execute(new SendMessage(update.getMessage().getChatId(), returnText));
        LOGGER.info("_-=======================================-_");
        LOGGER.info(returnText);
        LOGGER.info("_-=======================================-_");
    }

    private boolean haveCommand(String command) {
        command = command.toLowerCase();
        switch (command) {
            case "/register":
                botStateEnum = RegisterStateEnum.FIRST;
                return true;
            default:
                return false;
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

    public void setUpdate(Update update) {
        this.update = update;
    }

    public void setBotStateEnum(Enum botStateEnum) {
        this.botStateEnum = botStateEnum;
    }
}
