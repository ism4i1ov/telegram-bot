package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@FunctionalInterface
public interface AbstractInterface {

    void getProcess(Bot bot) throws TelegramApiException;
}
