package ee.valiit.back_bank_27.validation;

import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.infrastructure.exception.DataNotFoundException;

import java.util.Optional;

import static ee.valiit.back_bank_27.validation.ErrorMessage.INCORRECT_CREDENTIALS;

public class Validator {

    public static User getValidUser(Optional<User> optinalUser) {
        if (optinalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optinalUser.get();
        return user;
    }
}
