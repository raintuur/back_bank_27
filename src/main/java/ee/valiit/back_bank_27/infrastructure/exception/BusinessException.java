package ee.valiit.back_bank_27.infrastructure.exception;

import lombok.Data;

// See klass on ise kirjutatud
// See klass BusinessException pikendab klassi RuntimeException
// Sellel klassil on nüüd kõik RuntimeException klassi omadused
// Selline extendimine teeb java mõistes nüüd sellest klassist erilise veateate klassi
@Data
public class BusinessException extends RuntimeException {

    // oleme lisanud 2 välja (instantsi/objetki muutujad), millega saame mingeid andmeid selle klassi objektis hoida.
    private final String message;
    private final String errorCode;

    // See on selle BusinessException klassi konstruktor
    // See konstruktor on defineeritud nii, et ta võtab sisse String ja String tüüpi objektid ja siis väärtustab selle klassi instantis muutujad
    // See on selleks vajalik, et me saaksime siin klassis nende objektide andmetega kuidagi toimetada.
    // Kui konstruktorite teema on veel endiselt segane, siis palun vaata uuesti "Konstruktorid"
    // https://youtu.be/dzJtslZtnlg
    public BusinessException(String message, String errorCode) {

        // super(title) osaga kutsume välja RuntimeException konstruktori, mis võtab sisse Stringi:
        //    public RuntimeException(String message) {
        //        super(message);
        //    }
        // vajuta Ctrl + click super'il ja näed, et sellega tehakse uus RuntimeException objekt ja message antakse exceptionile kaasa
        super(message);

        // väärtustame klassi instantsi muutuja välja välja
        this.message = message;

        // väärtustame klassi instantsi muutuja välja välja
        this.errorCode = errorCode;
    }
}
