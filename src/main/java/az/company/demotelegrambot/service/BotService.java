package az.company.demotelegrambot.service;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.commands.CheckNeedStateEnum;
import az.company.demotelegrambot.commands.RegisterStateEnum;
import az.company.demotelegrambot.commands.StartStateEnum;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class BotService {
    @SneakyThrows
    public void checkCommandAndStart(Bot bot) {
        if (bot.botStateEnum instanceof RegisterStateEnum)
            ((RegisterStateEnum) bot.botStateEnum).startProcess(bot);
        else if (bot.botStateEnum instanceof StartStateEnum)
            ((StartStateEnum) bot.botStateEnum).startProcess(bot);
        else if (bot.botStateEnum instanceof CheckNeedStateEnum)
            ((CheckNeedStateEnum) bot.botStateEnum).startProcess(bot);
    }
}
