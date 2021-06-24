package az.company.demotelegrambot.service;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.commands.RegisterStateEnum;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class BotService {
    public String checkCommandAndStart(Bot bot) {
        if (bot.botStateEnum instanceof RegisterStateEnum) {
            return ((RegisterStateEnum) bot.botStateEnum).startProcess(bot);
        }
        return null;
    }
}
