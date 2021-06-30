package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.dto.UsersDto;
import az.company.demotelegrambot.service.UserService;
import az.company.demotelegrambot.text.TextsEnum;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public enum DevelopersStateEnum {

    SECOND(bot -> {
        String languageCode = bot.languageCode;
        Long chatId = bot.chatId;
        String developmentLang = bot.update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        Thread.sleep(1000);
        bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.FIND_25_PROC.getMsgByLang(languageCode)));
        Thread.sleep(2000);
        bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.FIND_50_PROC.getMsgByLang(languageCode)));
        Thread.sleep(3000);
        bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.FIND_75_PROC.getMsgByLang(languageCode)));
        List<UsersDto> userByDevLangName = DevelopersStateEnum.SECOND.userService.getUserByDevLangName(developmentLang);
        bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.FIND_100_PROC.getMsgByLang(languageCode)));
        if (userByDevLangName == null || userByDevLangName.isEmpty()) {
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.FIND_RESULT_DONT_HAVE.getMsgByLang(languageCode)));
        } else {
            for (UsersDto dto : userByDevLangName) {
                SendMessage sendMessage1 = new SendMessage();
                bot.execute(sendMessage1.setChatId(chatId).setText(dto.getUserInfoByLang(languageCode)));
            }
            sendMessage.setReplyMarkup(new ReplyKeyboardMarkup());
        }
    }),
    FIRST(bot -> {
        Long chatId = bot.chatId;
        String languageCode = bot.languageCode;
        SendMessage sendMessage = new SendMessage();
        bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.SELECT_DEVELOPMENT_LANG.getMsgByLang(languageCode)));
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow firstKeyboardRow = new KeyboardRow();
        firstKeyboardRow.add("Java");
        firstKeyboardRow.add("PHP");
        firstKeyboardRow.add("Python");
        keyboardRows.add(firstKeyboardRow);
        KeyboardRow secondKeyboardRow = new KeyboardRow();
        secondKeyboardRow.add("GO");
        secondKeyboardRow.add("Kotlin");
        secondKeyboardRow.add("Scala");
        keyboardRows.add(secondKeyboardRow);
        KeyboardRow thirdKeyboardRow = new KeyboardRow();
        thirdKeyboardRow.add("C/C++");
        keyboardRows.add(thirdKeyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.setBotStateEnum(SECOND);
    });

    @Autowired
    private UserService userService;
    public AbstractInterface process;

    DevelopersStateEnum(AbstractInterface abstractInterface) {
        process = abstractInterface;
    }

    @SneakyThrows
    public void startProcess(Bot bot) {
        process.getProcess(bot);
    }
}
