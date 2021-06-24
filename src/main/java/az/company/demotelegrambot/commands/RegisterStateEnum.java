package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import org.telegram.telegrambots.meta.api.objects.Update;

public enum RegisterStateEnum {
    FOURTH(4, bot -> {
        bot.setBotStateEnum(null);
        return "Ugurla qeydiyyatdan kecdiz";
    }),
    THIRD(3, bot -> {
        bot.setBotStateEnum(FOURTH);
        return "Ata adınız: ";
    }),
    SECOND(2, bot -> {
        bot.setBotStateEnum(THIRD);
        return "Soyadınız:";
    }),
    FIRST(1, bot -> {
        bot.setBotStateEnum(SECOND);
        return "Adınız:";
    });

    private final int id;
    private final AbstractInterface process;

    RegisterStateEnum(int id, AbstractInterface process) {
        this.id = id;
        this.process = process;
    }

    public int getId() {
        return id;
    }

    public AbstractInterface getProcess() {
        return process;
    }

    public String startProcess(Bot bot) {
        return this.process.getProcess(bot);
    }
}
