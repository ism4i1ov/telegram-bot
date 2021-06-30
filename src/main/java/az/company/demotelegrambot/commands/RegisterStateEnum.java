package az.company.demotelegrambot.commands;

import az.company.demotelegrambot.bot.Bot;
import az.company.demotelegrambot.dto.DevelopmentLangDto;
import az.company.demotelegrambot.dto.UsersDto;
import az.company.demotelegrambot.dto.WorkExperienceDto;
import az.company.demotelegrambot.entity.UserEntity;
import az.company.demotelegrambot.service.UserService;
import az.company.demotelegrambot.text.TextsEnum;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public enum RegisterStateEnum {
    FINISH(bot -> {
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        UserEntity userEntity = RegisterStateEnum.FINISH.userService.saveUser(bot.userDto);
        if (userEntity == null) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.FINISH_ERROR_USER_REGISTER.getMsgByLang(languageCode)));
        } else {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.FINISH_SUCCESS_USER_REGISTER.getMsgByLang(languageCode)));
        }
        bot.setBotStateEnum(StartStateEnum.START);
        StartStateEnum.START.startProcess(bot);
    }),
    THIRTEENTH(bot -> {
        String haveJob = bot.update.getMessage().getText();
        String languageCode = bot.languageCode;
        Long chatId = bot.update.getMessage().getChatId();
        if (haveJob == null || haveJob.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_SPECIALIZATION_ON_WORK.getMsgByLang(languageCode)));
        } else if (haveJob.equalsIgnoreCase(TextsEnum.NO_HAVE_JOB.getMsgByLang(languageCode)) || haveJob.equalsIgnoreCase(TextsEnum.YES_HAVE_JOB.getMsgByLang(languageCode))) {
            bot.setBotStateEnumWork();
        } else {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setReplyMarkup(new ReplyKeyboardMarkup());
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.FINISH_USER_REGISTER.getMsgByLang(languageCode)));
            bot.setBotStateEnum(FINISH);
        }
    }),
    TWELFTH(bot -> {
        String specialization = bot.update.getMessage().getText();
        String languageCode = bot.languageCode;
        Long chatId = bot.update.getMessage().getChatId();
        if (specialization == null || specialization.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_SPECIALIZATION_ON_WORK.getMsgByLang(languageCode)));
        } else {
            bot.userDto.getWorkExperienceDtos().get(bot.userDto.getWorkExperienceDtos().size() - 1).setSpecializationOnWork(specialization);
            SendMessage sendMessage = new SendMessage();
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboardRows = new ArrayList<>();
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add(TextsEnum.YES_HAVE_JOB.getMsgByLang(languageCode));
            keyboardRow.add(TextsEnum.NO_HAVE_JOB.getMsgByLang(languageCode));
            keyboardRows.add(keyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboardRows);
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.HAVE_MORE_JOBS.getMsgByLang(languageCode)));
            bot.setBotStateEnum(THIRTEENTH);
        }
    }),
    ELEVENTH(bot -> {
        String workExperienceYear = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (workExperienceYear == null ||
                (!workExperienceYear.equalsIgnoreCase(TextsEnum.WORK_EXPERIENCE_1_YEARS.getMsgByLang(languageCode)) &&
                        !workExperienceYear.equalsIgnoreCase(TextsEnum.WORK_EXPERIENCE_1_2_YEARS.getMsgByLang(languageCode)) &&
                        !workExperienceYear.equalsIgnoreCase(TextsEnum.WORK_EXPERIENCE_3_5_YEARS.getMsgByLang(languageCode)) &&
                        !workExperienceYear.equalsIgnoreCase(TextsEnum.WORK_EXPERIENCE_6_10_YEARS.getMsgByLang(languageCode)) &&
                        !workExperienceYear.equalsIgnoreCase(TextsEnum.WORK_EXPERIENCE_11_YEARS.getMsgByLang(languageCode)))) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.SELECT_CORRECT_WORK_EXPERIENCE_YEARS.getMsgByLang(languageCode)));
        } else {
            bot.userDto.getWorkExperienceDtos().get(bot.userDto.getWorkExperienceDtos().size() - 1).setWorkExperienceYears(workExperienceYear);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setReplyMarkup(new ReplyKeyboardMarkup());
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.ENTER_SPECIALIZATION_ON_WORK.getMsgByLang(languageCode)));
            bot.setBotStateEnum(TWELFTH);
        }
    }),
    TENTH(bot -> {
        String companyName = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (companyName == null) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_COMPANY_NAME.getMsgByLang(languageCode)));
        } else {
            if (companyName.equals(TextsEnum.DOES_HAVE_WORK_EXPERIENCE.getMsgByLang(languageCode))) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setReplyMarkup(new ReplyKeyboardMarkup());
                bot.execute(sendMessage);
                bot.setBotStateEnum(FINISH);
            } else {
                bot.userDto.getWorkExperienceDtos().add(new WorkExperienceDto().setCompanyName(companyName));
                SendMessage sendMessage = new SendMessage();
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboardRows = new ArrayList<>();
                KeyboardRow firstKeyboardRow = new KeyboardRow();
                firstKeyboardRow.add(TextsEnum.WORK_EXPERIENCE_1_YEARS.getMsgByLang(languageCode));
                keyboardRows.add(firstKeyboardRow);
                KeyboardRow secondKeyboardRow = new KeyboardRow();
                secondKeyboardRow.add(TextsEnum.WORK_EXPERIENCE_1_2_YEARS.getMsgByLang(languageCode));
                secondKeyboardRow.add(TextsEnum.WORK_EXPERIENCE_3_5_YEARS.getMsgByLang(languageCode));
                secondKeyboardRow.add(TextsEnum.WORK_EXPERIENCE_6_10_YEARS.getMsgByLang(languageCode));
                keyboardRows.add(secondKeyboardRow);
                KeyboardRow thirdKeyboardRow = new KeyboardRow();
                thirdKeyboardRow.add(TextsEnum.WORK_EXPERIENCE_11_YEARS.getMsgByLang(languageCode));
                keyboardRows.add(thirdKeyboardRow);
                replyKeyboardMarkup.setKeyboard(keyboardRows);
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.SELECT_WORK_EXPERIENCE_YEARS.getMsgByLang(languageCode)));
                bot.setBotStateEnum(ELEVENTH);
            }
        }
    }),
    NINTH(bot -> {
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        String developmentLanguageOtherSkills = bot.update.getMessage().getText();
        bot.userDto.getDevelopmentLangDto().setOthers(developmentLanguageOtherSkills);
        bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_COMPANY_NAME.getMsgByLang(languageCode)));
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(TextsEnum.DOES_HAVE_WORK_EXPERIENCE.getMsgByLang(languageCode));
        keyboardRows.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.IF_DOES_HAVE_WORK_EXPERIENCE.getMsgByLang(languageCode)));
        bot.setBotStateEnum(TENTH);
    }),
    EIGHTH(bot -> {
        Long chatId = bot.update.getMessage().getChatId();
        String developmentLanguageSkills = bot.update.getMessage().getText();
        String languageCode = bot.languageCode;
        if (developmentLanguageSkills == null || developmentLanguageSkills.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_SKILLS.getMsgByLang(languageCode)));
        } else {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_OTHER_SKILLS.getMsgByLang(languageCode)));
            bot.userDto.getDevelopmentLangDto().setSkills(developmentLanguageSkills);
            bot.setBotStateEnum(NINTH);
        }
    }),
    SEVENTH(bot -> {
        String developmentLanguage = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (developmentLanguage == null || developmentLanguage.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.SELECT_CORRECT_DEVELOPMENT_LANG.getMsgByLang(languageCode)));
        } else if (!"JAVA".equalsIgnoreCase(developmentLanguage) &&
                !"PHP".equalsIgnoreCase(developmentLanguage) &&
                !"PYTHON".equalsIgnoreCase(developmentLanguage) &&
                !"GO".equalsIgnoreCase(developmentLanguage) &&
                !"KOTLIN".equalsIgnoreCase(developmentLanguage) &&
                !"SCALA".equalsIgnoreCase(developmentLanguage) &&
                !"C/C++".equalsIgnoreCase(developmentLanguage)) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.SELECT_CORRECT_DEVELOPMENT_LANG.getMsgByLang(languageCode)));
        } else {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setReplyMarkup(new ReplyKeyboardMarkup());
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.ENTER_SKILLS.getMsgByLang(languageCode)));
            bot.userDto.getDevelopmentLangDto().setName(developmentLanguage);
            bot.setBotStateEnum(EIGHTH);
        }
    }),
    SIXTH(bot -> {
        String birthDay = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (birthDay == null || birthDay.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_BIRTH_DAY.getMsgByLang(languageCode)));
        } else {
            SendMessage sendMessage = new SendMessage();
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.SELECT_DEVELOPMENT_LANG.getMsgByLang(languageCode)));
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboardRows = new ArrayList<>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            firstKeyboardRow.add("Java");
            firstKeyboardRow.add("PHP");
            firstKeyboardRow.add("Python");
            keyboardRows.add(firstKeyboardRow);
            KeyboardRow secondKeyboardRow = new KeyboardRow();
            secondKeyboardRow.add("GO");
            secondKeyboardRow.add("Kotlin");
            secondKeyboardRow.add("Scala");
            keyboardRows.add(secondKeyboardRow);
            KeyboardRow thirdKeyboardRow = new KeyboardRow();
            thirdKeyboardRow.add("C/C++");
            keyboardRows.add(thirdKeyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboardRows);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            LocalDate birth = LocalDate.parse(birthDay);
            bot.getUserDto().setBirthDay(birth);
            bot.setBotStateEnum(SEVENTH);
        }
    }),
    FIFTH(bot -> {
        String city = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (city == null || city.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_CITY_NAME.getMsgByLang(languageCode)));
        } else {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_BIRTH_DAY.getMsgByLang(languageCode)));
            bot.getUserDto().setAddress(city);
            bot.setBotStateEnum(SIXTH);
        }
    }),
    FOURTH(bot -> {
        String fatherName = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (fatherName == null || fatherName.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_FATHER_NAME.getMsgByLang(languageCode)));
        } else {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CITY_NAME.getMsgByLang(languageCode)));
            bot.getUserDto().setFatherName(fatherName);
            bot.setBotStateEnum(FIFTH);
        }
    }),
    THIRD(bot -> {
        String surname = bot.update.getMessage().getText();
        Long chatId = bot.update.getMessage().getChatId();
        String languageCode = bot.languageCode;
        if (surname == null || surname.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_SURNAME.getMsgByLang(languageCode)));
        } else {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_FATHER_NAME.getMsgByLang(languageCode)));
            bot.getUserDto().setSurname(surname);
            bot.setBotStateEnum(FOURTH);
        }
    }),
    SECOND(bot -> {
        String name = bot.update.getMessage().getText();
        Long chatId = bot.chatId;
        String languageCode = bot.languageCode;
        if (name == null || name.trim().isEmpty()) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_CORRECT_NAME.getMsgByLang(languageCode)));
        } else {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.ENTER_SURNAME.getMsgByLang(languageCode)));
            bot.getUserDto().setName(name);
            bot.setBotStateEnum(THIRD);
        }
    }),
    FIRST(bot -> {
        Long chatId = bot.chatId;
        boolean userExists = RegisterStateEnum.FIRST.userService.existsUser(chatId);
        String languageCode = bot.languageCode;
        if (userExists) {
            bot.execute(new SendMessage().setChatId(chatId).setText(TextsEnum.USER_EXISTS.getMsgByLang(languageCode)));
        } else {
            bot.setBotStateEnum(SECOND);
            SendMessage sendMessage = new SendMessage();
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            bot.execute(sendMessage.setChatId(chatId).setText(TextsEnum.ENTER_NAME.getMsgByLang(languageCode)));
            bot.setUserDto(new UsersDto()
                    .setChatId(bot.update.getMessage().getChatId())
                    .setUsername(bot.update.getMessage().getChat().getUserName())
                    .setDevelopmentLangDto(new DevelopmentLangDto())
                    .setWorkExperienceDtos(new ArrayList<>()));
        }
    });

    @Autowired
    private UserService userService;
    private final AbstractInterface process;

    RegisterStateEnum(AbstractInterface process) {
        this.process = process;
    }

    public AbstractInterface getProcess() {
        return process;
    }

    @SneakyThrows
    public void startProcess(Bot bot) throws TelegramApiException {
        this.process.getProcess(bot);
    }
}
