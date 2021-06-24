package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import org.telegram.telegrambots.meta.api.objects.Update;

@FunctionalInterface
public interface AbstractInterface {
    String getProcess(Bot bot);
}
