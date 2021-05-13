package az.company.demotelegrambot.utils;

import org.apache.commons.validator.EmailValidator;

public class Util {
    public static boolean getEmailValidation(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
