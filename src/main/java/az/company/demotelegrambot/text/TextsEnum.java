package az.company.demotelegrambot.text;

import com.vdurmont.emoji.EmojiParser;

public enum TextsEnum {
    DEVELOPERS_TEXT(EmojiParser.parseToUnicode("Proqramçılar :computer:"), EmojiParser.parseToUnicode("Программисты :computer:"), EmojiParser.parseToUnicode("Developers :computer:")),
    NEW_DEVELOPER(EmojiParser.parseToUnicode("Qeydiyyat :closed_lock_with_key:"), EmojiParser.parseToUnicode("Регистрация :closed_lock_with_key:"), EmojiParser.parseToUnicode("Register :closed_lock_with_key:")),
    NEW_VACANCY(EmojiParser.parseToUnicode("Yeni vakansiya :white_check_mark:"), EmojiParser.parseToUnicode("Новая ваканция :white_check_mark:"), EmojiParser.parseToUnicode("New vacancy :white_check_mark:")),
    FIND_VACANCY(EmojiParser.parseToUnicode("Vakansiya axtarmaq :mag:"), EmojiParser.parseToUnicode("Поиск ваканции :mag:"), EmojiParser.parseToUnicode("Find vacancy :mag:")),
    SELECT_CATEGORY(EmojiParser.parseToUnicode("Kateqoriyani seçin :books:"), EmojiParser.parseToUnicode("Выберите категорию :books:"), EmojiParser.parseToUnicode("Select category :books:")),
    SELECT_CORRECT_CATEGORY(EmojiParser.parseToUnicode("Kateqoriyani düzgün seçin :books:"), EmojiParser.parseToUnicode("Выберите соответствующию категорию :books:"), EmojiParser.parseToUnicode("Select correct category :books:"));

    private String messageRu;
    private String messageAz;
    private String messageEn;

    TextsEnum(String messageAz, String messageRu, String messageEn) {
        this.messageAz = messageAz;
        this.messageEn = messageEn;
        this.messageRu = messageRu;
    }

    public String getMsgByLang(String lang) {
        if (lang.equalsIgnoreCase("az")) return messageAz;
        else if (lang.equalsIgnoreCase("ru")) return messageRu;
        else return messageEn;
    }
}
