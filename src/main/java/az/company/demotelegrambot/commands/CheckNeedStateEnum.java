package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.text.TextsEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public enum CheckNeedStateEnum {

    CHECK_NEED_PROCESS(bot -> {
        String text = bot.update.getMessage().getText();
        String languageCode = bot.update.getMessage().getFrom().getLanguageCode();
        if ("Jobs".contains(text)) {

        } else if (TextsEnum.DEVELOPERS_TEXT.getMsgByLang(languageCode).equalsIgnoreCase(text)) {

        } else if (TextsEnum.NEW_DEVELOPER.getMsgByLang(languageCode).equalsIgnoreCase(text)) {
            RegisterStateEnum.FIRST.startProcess(bot);
        } else if (TextsEnum.NEW_VACANCY.getMsgByLang(languageCode).equalsIgnoreCase(text)) {

        } else if (TextsEnum.FIND_VACANCY.getMsgByLang(languageCode).equalsIgnoreCase(text)) {

        } else {
            bot.execute(new SendMessage().setChatId(bot.update.getMessage().getChatId())
                    .setText(TextsEnum.SELECT_CORRECT_CATEGORY.getMsgByLang(languageCode)));
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
