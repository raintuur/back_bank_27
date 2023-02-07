package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.Status;
import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

// @Service annotatsioon annab Springile märku, et see klass on teenuse tüüpi klass.
// Tänu sellele annotatsioonile teeb Spring rakendust käivitades sellest klassist ühe objekti.
// @Resource abil saame hiljem sellele objektile ligi.
// Selle klassi objekti kaudu saame käivitada kõiki siin klassis olevaid PUBLIC meetodeid.
@Service
public class UserService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klasside objektidele (beans)
    @Resource
    private UserRepository userRepository;

    // See meetod on defineeritud nii, et ta võtab sisse String tüüpi objektid
    // See on selleks vajalik, et me saaksime siin meetodis nende objektide andmetega kuidagi edasi toimetada.
    // See meetod on defineeritud nii, et ta peab tagastama User tüüpi objekti (andmebaasi tabeli Entity)
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public User findUser(String username, String password) {

        // kasutame userRepository (värav) objekti, et saada ligi tabeli 'user' andmetele
        // See meetod findUser() on meie enda loodud meetod.
        // Kaasa anname:
        //      konkreetse kasutaja kasutajanime ehk 'user' tabeli veeru 'username' väärtuse.
        //      konkreetse kasutaja parooli ehk 'user' tabeli veeru 'password' väärtuse.
        //      konkreetse aktiivse statuse ehk 'user' tabeli veeru 'status' väärtuse "A".
        // repository tagastab nendele tingimustele vastava 'user' objekti (andmebaasi mõttes tagastatakse 'user' tabeli andmetega rida)
        // Tulemus mähitakse omakorda "Optional" klassi objekti sisse (komm ja kommipaber)
        // Sellel Optional klassil on olemas mugavad meetodid, millega saab kontrollida, et kas leiti mingi tulemus (user objekt pole 'null'
        // või siis ei leitud mingit tulemust.
        // Vaata ka Status klassis olevaid kommentaare.
        Optional<User> optionalUser = userRepository.findUser(username, password, Status.ACTIVE);

        // Kutsume välja Validator klassi staatilise meetodi getValidUser().
        // Pane tähele, siis ei ole pöördutud mingi klassi OBJEKTI poole vaid on pöördutud OTSE klassi enda poole
        // (Validator algab siin suure tähega, see ei ole mingi objekt)
        // Kaasa anname eelnevalt leitud 'optionalUser' objekti
        // vaata ka kommentaare selle 'Validator.getValidUser()' meetodi sees
        // Kui getValidUser()'st visatakse ülesse viga, siis siit allapoole kood enam edasi ei lähe
        User user = Validator.getValidUser(optionalUser);


        // Kui me validatsioonis viga ei saanud, RETURN'iga tagastatakse tulemus sinna kohta, kust see meetod välja kutsutakse
        return user;
    }

}
