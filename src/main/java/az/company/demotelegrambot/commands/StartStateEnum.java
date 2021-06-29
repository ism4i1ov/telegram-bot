package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public enum StartStateEnum {
    FIRST(bot -> {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        SendMessage sendMessage = new SendMessage().setChatId(bot.update.getMessage().getChatId());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText("Select need category");

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Jobs \\xF0\\x9F\\x92\\xB0");
        keyboardFirstRow.add("Developers \\xF0\\x9F\\x91\\xA6");

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("Register developers \\xF0\\x9F\\x94\\x90");
        keyboardSecondRow.add("Add vacancy \\xF0\\x9F\\x94\\x90");

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Find vacancy \\xE2\\x9C\\x85");

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
