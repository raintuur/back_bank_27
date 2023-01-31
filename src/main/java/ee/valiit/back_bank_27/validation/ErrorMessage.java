package ee.valiit.back_bank_27.validation;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    INCORRECT_CREDENTIALS("Vale kasutaja või parool!", "666"),
    DUPLICATE_LOCATION_NAME("Sellise nimega asukoht on juba olemas!", "555");

    private String message;
    private String code;

    ErrorMessage(String message, String code) {
        this.message = message;

        this.code = code;
    }

}
