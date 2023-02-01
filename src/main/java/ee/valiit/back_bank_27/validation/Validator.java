package ee.valiit.back_bank_27.validation;

import ee.valiit.back_bank_27.domain.location.Location;
import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_bank_27.validation.ErrorMessage.INCORRECT_CREDENTIALS;
import static ee.valiit.back_bank_27.validation.ErrorMessage.NO_ATM_LOCATIONS;

public class Validator {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        User user = optionalUser.get();
        return user;
    }

    public static void validateAtmLocationsAvailable(List<Location> locations) {
        if(locations.isEmpty()) {
            throw new DataNotFoundException(NO_ATM_LOCATIONS.getMessage(), NO_ATM_LOCATIONS.getCode());
        }
    }
}
