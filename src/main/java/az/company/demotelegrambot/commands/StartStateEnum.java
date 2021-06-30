package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.text.TextsEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public enum StartStateEnum {
    FIRST(bot -> {
        String languageCode = bot.languageCode;
        Long chatId = bot.chatId;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        SendMessage sendMessage = new SendMessage().setChatId(chatId);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText(TextsEnum.SELECT_CATEGORY.getMsgByLang(languageCode));

        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(TextsEnum.DEVELOPERS_TEXT.getMsgByLang(languageCode));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(TextsEnum.NEW_DEVELOPER.getMsgByLang(languageCode));
        keyboardSecondRow.add(TextsEnum.NEW_VACANCY.getMsgByLang(languageCode));

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(TextsEnum.FIND_VACANCY.getMsgByLang(languageCode));

        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(keyboardFirstRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        keyboard(replyKeyboardMarkup, sendMessage, bot);
        bot.botStateEnum = CheckNeedStateEnum.CHECK_NEED_PROCESS;
    });

    private AbstractInterface process;

    StartStateEnum(AbstractInterface process) {
        this.process = process;
    }

    public void startProcess(Bot bot) throws TelegramApiException {
        this.process.getProcess(bot);
    }

    public static void keyboard(ReplyKeyboardMarkup replyKeyboardMarkup, SendMessage sendMessage, Bot bot) throws TelegramApiException {
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        bot.execute(sendMessage);
    }

}
