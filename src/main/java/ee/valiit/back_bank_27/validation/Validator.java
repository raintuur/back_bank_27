package ee.valiit.back_bank_27.validation;

import ee.valiit.back_bank_27.domain.locationtransaction.location.Location;
import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_bank_27.validation.ErrorMessage.INCORRECT_CREDENTIALS;
import static ee.valiit.back_bank_27.validation.ErrorMessage.NO_ATM_LOCATIONS;

public class Validator {

    // See meetod on defineeritud staatilise meetodina. See tähendab seda, et seda meetodit on võimalik välja kutsuda
    // ilma, et peaks enne sellest klassist tegema objekti.
    // Staatilist meetodit saab välja kutsuda kirjutades välja klassi nime ja siis meetodi nime (Validator.getValidUser())
    // Eelduseks on see, et siin meetodis ei kasutada kuidagi klassi instantsi muutujaid näiteks:
    //    public class Validator {
    //        private String name;
    //        private int age;
    //    }
    // Sest kui me kutsuksime selle meetodi klassi nime abil staatiliselt välja, siis sellest klassist me ju objekti ei tee ning neid välju ei väärtusta
    // Seega jääks selle klassi intsantsi muutujate väärtused null'ideks ning nendega ei oleks siis võimaluk kuidagi toimetada.
    // See meetod on defineeritud nii, et ta võtab sisse Optional<User> tüüpi 'optionalUser' objekti

    public static User getValidUser(Optional<User> optionalUser) {
        // Võtame getValidUser() signatuuri parameetris sisse Optional<User> tüüpi objekti
        // Siin signatuuris antakse selle objekti muutuja nimeks 'optionalUser'

        // optionalUser objekti klassi  tüüp on Optional<User>
        // Siin 'if' lause sees kasutatakse Optional klassi meetodit isEmpty(),
        // mis tagastab 'true' kui selle Optional klassi sisse mähitud objekti väärtus on 'null'
        if (optionalUser.isEmpty()) {
            // Kui if lause sisu rehtkendus true-ks, siis tuldi siia sisse, et visata süsteemis ülesse viga
            // vigu saame visata ülesse kasutades võtme sõnu "throw new ..."
            // vaata ka nende klasside DataNotFoundException ja BusinessException sisse
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }

        // Kui me eelneva 'if' lause sisse ei satu, kus vistakase viga ja lahkutakse siit meetodist,
        // siis järgmiseks satume siin all olevale koodireale
        // Siin siis võtame Optional klassi meetodiga .get() optional objekti sisse mähitud 'user' objekti välja
        // ja paneme muutujasse user  (komm ja kommipaber)
        User user = optionalUser.get();

        // RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return user;
    }

    public static void validateAtmLocationsAvailable(List<Location> locations) {
        if (locations.isEmpty()) {
            throw new DataNotFoundException(NO_ATM_LOCATIONS.getMessage(), NO_ATM_LOCATIONS.getCode());
        }
    }

}
