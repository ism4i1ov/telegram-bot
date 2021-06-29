package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.entity.DevelopmentLangEntity;
import az.company.demotelegrambot.entity.UserEntity;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;


public enum RegisterStateEnum {
    FINISH(bot -> {
        String name = bot.update.getMessage().getText();
        if (name == null || name.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please select correct you development language in list: "));
        } else {
            bot.execute(new SendMessage().setText("Please select you development language in list: "));
            bot.setBotStateEnum(null);
        }
    }),
    ELEVENTH(bot -> {
        Integer workExperience;
        try {
            workExperience = Integer.valueOf(bot.update.getMessage().getText());
        } catch (Exception exception) {
            workExperience = null;
        }
        if (workExperience == null) {
            bot.execute(new SendMessage().setText("Please enter correct work experience: "));
        } else {
            if (workExperience.equals(0)) {
                bot.setBotStateEnum(FINISH);
            } else {
                bot.execute(new SendMessage().setText("Please enter you development language in list: "));
                bot.setBotStateEnum(FINISH);
            }
        }
    }),
    TENTH(bot -> {
        String workExperience = bot.update.getMessage().getText();
        if (workExperience == null) {
            bot.execute(new SendMessage().setText("Please enter correct work experience: "));
        } else {
            if (workExperience.equals("0")) {
                bot.setBotStateEnum(FINISH);
            } else {
                bot.execute(new SendMessage().setText("Please enter you development language in list: "));
                bot.setBotStateEnum(ELEVENTH);
            }
        }
    }),
    NINTH(bot -> {
        String developmentLanguageOtherSkills = bot.update.getMessage().getText();
        bot.userEntity.getDevelopmentLangEntity().setOthers(developmentLanguageOtherSkills);
        bot.execute(new SendMessage().setText("Please enter company name where you work: "));
        bot.execute(new SendMessage().setText("If you did't work write \"0\": "));
//        bot.execute(new SendMessage().setText("Please enter work experience years example: 1 "));
//        bot.execute(new SendMessage().setText("If you don't have work experience enter \"0\": "));
//        bot.setBotStateEnum(TENTH);
    }),
    EIGHTH(bot -> {
        String developmentLanguageSkills = bot.update.getMessage().getText();
        if (developmentLanguageSkills == null || developmentLanguageSkills.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please enter correct skills on development language: "));
        } else {
            bot.execute(new SendMessage().setText("Please enter other skills: "));
            bot.userEntity.getDevelopmentLangEntity().setSkills(developmentLanguageSkills);
            bot.setBotStateEnum(NINTH);
        }
    }),
    SEVENTH(bot -> {
        String developmentLanguage = bot.update.getMessage().getText();
        if (developmentLanguage == null || developmentLanguage.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please select correct you development language in list: "));
        } else if (!"JAVA".equalsIgnoreCase(developmentLanguage) &&
                !"PHP".equalsIgnoreCase(developmentLanguage) &&
                !"PYTHON".equalsIgnoreCase(developmentLanguage) &&
                !"GO".equalsIgnoreCase(developmentLanguage) &&
                !"KOTLIN".equalsIgnoreCase(developmentLanguage) &&
                !"SCALA".equalsIgnoreCase(developmentLanguage) &&
                !"C/C++".equalsIgnoreCase(developmentLanguage)) {
            bot.execute(new SendMessage().setText("Please select correct you development language in list: "));
        } else {
            bot.execute(new SendMessage().setText("Please enter skills on development language: "));
            bot.userEntity.getDevelopmentLangEntity().setName(developmentLanguage);
            bot.setBotStateEnum(EIGHTH);
        }
    }),
    SIXTH(bot -> {
        String birthDay = bot.update.getMessage().getText();
        if (birthDay == null || birthDay.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please enter you correct birth day example: 01-10-1995 "));
        } else {
            bot.execute(new SendMessage().setText("Please select you development language in list: "));
            LocalDate birth = LocalDate.parse(birthDay);
            bot.getUserEntity().setBirthDay(birth);
            bot.setBotStateEnum(SEVENTH);
        }
    }),
    FIFTH(bot -> {
        String city = bot.update.getMessage().getText();
        if (city == null || city.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please enter you correct father name: "));
        } else {
            bot.execute(new SendMessage().setText("Please enter birth day example: 01-10-1995 "));
            bot.getUserEntity().setAddress(city);
            bot.setBotStateEnum(SIXTH);
        }
    }),
    FOURTH(bot -> {
        String fatherName = bot.update.getMessage().getText();
        if (fatherName == null || fatherName.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please enter you correct father name: "));
        } else {
            bot.execute(new SendMessage().setText("Please enter city name: "));
            bot.getUserEntity().setFatherName(fatherName);
            bot.setBotStateEnum(FIFTH);
        }
    }),
    THIRD(bot -> {
        String surname = bot.update.getMessage().getText();
        if (surname == null || surname.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please enter you correct surname: "));
        } else {
            bot.execute(new SendMessage().setText("Please enter father name: "));
            bot.getUserEntity().setSurname(surname);
            bot.setBotStateEnum(FOURTH);
        }
    }),
    SECOND(bot -> {
        String name = bot.update.getMessage().getText();
        if (name == null || name.trim().isEmpty()) {
            bot.execute(new SendMessage().setText("Please enter you correct name: "));
        } else {
            bot.execute(new SendMessage().setText("Please enter you surname: "));
            bot.getUserEntity().setName(name);
            bot.setBotStateEnum(THIRD);
        }
    }),
    FIRST(bot -> {
        bot.setBotStateEnum(SECOND);
        bot.execute(new SendMessage().setText("Please enter you name: "));
        bot.setUserEntity(new UserEntity()
                .setChatId(bot.update.getMessage().getChatId())
                .setUsername(bot.update.getMessage().getChat().getUserName())
                .setDevelopmentLangEntity(new DevelopmentLangEntity()));
    });

    private final AbstractInterface process;

    RegisterStateEnum(AbstractInterface process) {
        this.process = process;
    }

    public AbstractInterface getProcess() {
        return process;
    }

    public void startProcess(Bot bot) throws TelegramApiException {
        this.process.getProcess(bot);
    }
}
