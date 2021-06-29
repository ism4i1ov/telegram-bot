package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public enum CheckNeedStateEnum {

    CHECK_NEED_PROCESS(bot -> {
        String text = bot.update.getMessage().getText();
        if ("Jobs".contains(text)) {

        } else if ("Developers".contains(text)) {

        } else if ("Register developers".contains(text)) {
            bot.botStateEnum = RegisterStateEnum.FIRST;
        } else if ("Add vacancy".contains(text)) {

        } else if ("Find vacancy".contains(text)) {

        }
    });

    private final AbstractInterface process;

    CheckNeedStateEnum(AbstractInterface process) {
        this.process = process;
    }

    public void startProcess(Bot bot) throws TelegramApiException {
        this.process.getProcess(bot);
    }
}
