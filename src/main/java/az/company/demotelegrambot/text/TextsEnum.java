package az.company.demotelegrambot.text;

import com.vdurmont.emoji.EmojiParser;

public enum TextsEnum {
    DEVELOPERS_TEXT(EmojiParser.parseToUnicode("Proqramçılar :computer:"), EmojiParser.parseToUnicode("Программисты :computer:"), EmojiParser.parseToUnicode("Developers :computer:")),
    NEW_DEVELOPER(EmojiParser.parseToUnicode("Qeydiyyat :closed_lock_with_key:"), EmojiParser.parseToUnicode("Регистрация :closed_lock_with_key:"), EmojiParser.parseToUnicode("Register :closed_lock_with_key:")),
    NEW_VACANCY(EmojiParser.parseToUnicode("Yeni vakansiya :white_check_mark:"), EmojiParser.parseToUnicode("Новая ваканция :white_check_mark:"), EmojiParser.parseToUnicode("New vacancy :white_check_mark:")),
    FIND_VACANCY(EmojiParser.parseToUnicode("Vakansiya axtarmaq :mag:"), EmojiParser.parseToUnicode("Поиск ваканции :mag:"), EmojiParser.parseToUnicode("Find vacancy :mag:")),
    SELECT_CATEGORY(EmojiParser.parseToUnicode("Kateqoriyani seçin :books:"), EmojiParser.parseToUnicode("Выберите категорию :books:"), EmojiParser.parseToUnicode("Select category :books:")),
    SELECT_CORRECT_CATEGORY(EmojiParser.parseToUnicode("Kateqoriyani düzgün seçin :books:"), EmojiParser.parseToUnicode("Выберите соответствующию категорию :books:"), EmojiParser.parseToUnicode("Select correct category :books:")),
    ENTER_CORRECT_FATHER_NAME(EmojiParser.parseToUnicode("Ata adınızı düzgün daxil edin"), EmojiParser.parseToUnicode("Введите корректное отчество"), EmojiParser.parseToUnicode("Enter the correct father name")),
    ENTER_FATHER_NAME(EmojiParser.parseToUnicode("Ata adınızı daxil edin"), EmojiParser.parseToUnicode("Введите отчество"), EmojiParser.parseToUnicode("Enter the father name")),
    ENTER_SURNAME(EmojiParser.parseToUnicode("Soyadınızı daxil edin"), EmojiParser.parseToUnicode("Введите фамилию"), EmojiParser.parseToUnicode("Enter the surname")),
    ENTER_CORRECT_SURNAME(EmojiParser.parseToUnicode("Soyadınızı düzgün daxil edin"), EmojiParser.parseToUnicode("Введите корректное фамилию"), EmojiParser.parseToUnicode("Enter the correct surname")),
    ENTER_CORRECT_NAME(EmojiParser.parseToUnicode("Adınızı düzgün daxil edin"), EmojiParser.parseToUnicode("Введите корректное имя"), EmojiParser.parseToUnicode("Enter the correct name")),
    ENTER_CORRECT_CITY_NAME(EmojiParser.parseToUnicode("Yaşadığınız şəhəri düzgün daxil edin"), EmojiParser.parseToUnicode("Введите корректное местое проживания"), EmojiParser.parseToUnicode("Enter the correct city name")),
    ENTER_CITY_NAME(EmojiParser.parseToUnicode("Yaşadığınız şəhəri daxil edin"), EmojiParser.parseToUnicode("Введите место проживания"), EmojiParser.parseToUnicode("Enter the city name")),
    ENTER_NAME(EmojiParser.parseToUnicode("Adınızı daxil edin"), EmojiParser.parseToUnicode("Введите имя"), EmojiParser.parseToUnicode("Enter the name")),
    ENTER_BIRTH_DAY(EmojiParser.parseToUnicode("Doğum taxirinizi daxil edin"), EmojiParser.parseToUnicode("Введите дата рождения"), EmojiParser.parseToUnicode("Enter birth day")),
    SELECT_DEVELOPMENT_LANG(EmojiParser.parseToUnicode("Siyahidan proqramlaşdırma dilini seçin"), EmojiParser.parseToUnicode("Выберите соответствующию вам язык программирования"), EmojiParser.parseToUnicode("Select you development language in list")),
    SELECT_CORRECT_DEVELOPMENT_LANG(EmojiParser.parseToUnicode("Siyahidan proqramlaşdırma dilini düzgün seçin"), EmojiParser.parseToUnicode("Выберите соответствующию язык программирования"), EmojiParser.parseToUnicode("Select correct development language in list")),
    ENTER_CORRECT_SKILLS(EmojiParser.parseToUnicode("Bilik və bacarıqlarınızı daxil edin"), EmojiParser.parseToUnicode("Введите свои умение и навыки"), EmojiParser.parseToUnicode("Enter the skills")),
    ENTER_SKILLS(EmojiParser.parseToUnicode("Bilik və bacarıqlarınızı düzğün daxil edin"), EmojiParser.parseToUnicode("Введите корректное умение и навыки"), EmojiParser.parseToUnicode("Enter the correct skills")),
    ENTER_OTHER_SKILLS(EmojiParser.parseToUnicode("Digər bilik və bacarıqlarınızı daxil edin"), EmojiParser.parseToUnicode("Введите другие свои навыки"), EmojiParser.parseToUnicode("Enter the others skills")),
    ENTER_COMPANY_NAME(EmojiParser.parseToUnicode("İşlədiyiniz müəssənnin adını daxil edin"), EmojiParser.parseToUnicode("Введите название компании где вы работали"), EmojiParser.parseToUnicode("Enter the company name where you are working")),
    ENTER_CORRECT_COMPANY_NAME(EmojiParser.parseToUnicode("İşlədiyiniz müəssənnin adını düzgün daxil edin"), EmojiParser.parseToUnicode("Введите корректное название компании где вы работали"), EmojiParser.parseToUnicode("Enter the correct company name where you are working")),
    IF_DOES_HAVE_WORK_EXPERIENCE(EmojiParser.parseToUnicode("Əgər iş təcrübəniz yoxdursa \"Yoxdur\" düyməsinə basın"), EmojiParser.parseToUnicode("Если у вас нету опыта работы нажимайте на кнопку \"Нету\""), EmojiParser.parseToUnicode("If you does not exists work experience click the button \"I don't have\"")),
    DOES_HAVE_WORK_EXPERIENCE(EmojiParser.parseToUnicode("Yoxdur"), EmojiParser.parseToUnicode("Нету"), EmojiParser.parseToUnicode("I don't have")),
    ENTER_CORRECT_BIRTH_DAY(EmojiParser.parseToUnicode("Doğum taxirinizi düzgün daxil edin"), EmojiParser.parseToUnicode("Введите корректное дата рождения"), EmojiParser.parseToUnicode("Enter the correct birth day")),
    SELECT_WORK_EXPERIENCE_YEARS(EmojiParser.parseToUnicode("İş təcrübənizi siyahıdan seçin"), EmojiParser.parseToUnicode("Выберите из списка опыт работы"), EmojiParser.parseToUnicode("Select work experience years in list")),
    SELECT_CORRECT_WORK_EXPERIENCE_YEARS(EmojiParser.parseToUnicode("İş təcrübənizi siyahıdan düzgün seçin"), EmojiParser.parseToUnicode("Выберите из списка опыт работы корректно"), EmojiParser.parseToUnicode("Select correct work experience years in list")),
    WORK_EXPERIENCE_1_YEARS(EmojiParser.parseToUnicode("1 Ildən aşağı"), EmojiParser.parseToUnicode("Менее 1 года"), EmojiParser.parseToUnicode("Less than 1 year")),
    WORK_EXPERIENCE_1_2_YEARS(EmojiParser.parseToUnicode("1-2 il"), EmojiParser.parseToUnicode("1-2 года"), EmojiParser.parseToUnicode("1-2 years")),
    WORK_EXPERIENCE_3_5_YEARS(EmojiParser.parseToUnicode("3-5 il"), EmojiParser.parseToUnicode("3-5 года"), EmojiParser.parseToUnicode("3-5 years")),
    WORK_EXPERIENCE_6_10_YEARS(EmojiParser.parseToUnicode("6-10 il"), EmojiParser.parseToUnicode("6-10 года"), EmojiParser.parseToUnicode("6-10 years")),
    WORK_EXPERIENCE_11_YEARS(EmojiParser.parseToUnicode("10 ilden artiq"), EmojiParser.parseToUnicode("Более 10 лет"), EmojiParser.parseToUnicode("Over 10 years")),
    ENTER_SPECIALIZATION_ON_WORK(EmojiParser.parseToUnicode("İşdə tutduğunuz vəzifəni daxil edin"), EmojiParser.parseToUnicode("Введите свою специальность в компании"), EmojiParser.parseToUnicode("Enter the specialization on company")),
    ENTER_CORRECT_SPECIALIZATION_ON_WORK(EmojiParser.parseToUnicode("İşdə tutduğunuz vəzifəni düzgün daxil edin"), EmojiParser.parseToUnicode("Введите свою корректную специальность в компании"), EmojiParser.parseToUnicode("Enter the correct specialization on company")),
    HAVE_MORE_JOBS(EmojiParser.parseToUnicode("Novbəti iş yerini elavə etmək istəyirsiz?"), EmojiParser.parseToUnicode("Хотите ли вы добавить ещё место работы?"), EmojiParser.parseToUnicode("You want add another company")),
    YES_HAVE_JOB(EmojiParser.parseToUnicode("Bəli"), EmojiParser.parseToUnicode("Да"), EmojiParser.parseToUnicode("Yes")),
    NO_HAVE_JOB(EmojiParser.parseToUnicode("Xeyr"), EmojiParser.parseToUnicode("Нет"), EmojiParser.parseToUnicode("No")),
    FINISH_USER_REGISTER(EmojiParser.parseToUnicode("İstifadəçi qeydiyyatdan keçir gözləyin..."), EmojiParser.parseToUnicode("Учетная запись зарегистрируется подождите..."), EmojiParser.parseToUnicode("User will be register wait...")),
    FINISH_SUCCESS_USER_REGISTER(EmojiParser.parseToUnicode("İstifadəçi uğurla qeydiyyatdan keçdi :white_check_mark:"), EmojiParser.parseToUnicode("Учетная запись успешно зарегистрировано :white_check_mark:"), EmojiParser.parseToUnicode("User is successfully registered :white_check_mark:")),
    FINISH_ERROR_USER_REGISTER(EmojiParser.parseToUnicode("İstifadəçi qeydiyyatı uğursuz :x:"), EmojiParser.parseToUnicode("Регистрация учетной записи не успешно :x:"), EmojiParser.parseToUnicode("User can't be was registered :x:")),
    USER_EXISTS(EmojiParser.parseToUnicode("Sizin cihaz atrıq qeydiyyatdan keçib..."), EmojiParser.parseToUnicode("Ваше устройство уже зарегистрировано..."), EmojiParser.parseToUnicode("You are device was registered..."));

    private final String messageRu;
    private final String messageAz;
    private final String messageEn;

    TextsEnum(String messageAz, String messageRu, String messageEn) {
        this.messageAz = messageAz;
        this.messageEn = messageEn;
        this.messageRu = messageRu;
    }

    public String getMsgByLang(String lang) {
        if (lang.equalsIgnoreCase("az") || lang.equalsIgnoreCase("tr")) return messageAz;
        else if (lang.equalsIgnoreCase("ru")) return messageRu;
        else return messageEn;
    }
}
