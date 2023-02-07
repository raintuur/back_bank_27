package ee.valiit.back_bank_27.validation;

import lombok.Getter;

// Vaata infot conflust enumide kohta. Otsi sealt: "Enum Coffee machine näitel"
@Getter
public enum ErrorMessage {

    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", "666"),
    NO_ATM_LOCATIONS("Ei leidnud ühtegi pangaautomaadi asukohta", "555");

    private String message;
    private String code;

    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
