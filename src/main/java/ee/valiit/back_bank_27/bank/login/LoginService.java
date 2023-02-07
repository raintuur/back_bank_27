package ee.valiit.back_bank_27.bank.login;

import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.domain.user.UserMapper;
import ee.valiit.back_bank_27.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

// @Service annotatsioon annab Springile märku, et see klass on teenuse tüüpi klass.
// Tänu sellele annotatsioonile teeb Spring rakendust käivitades sellest klassist ühe objekti.
// @Resource abil saame hiljem sellele objektile ligi.
// Selle klassi objekti kaudu saame käivitada kõiki siin klassis olevaid PUBLIC meetodeid.
@Service
public class LoginService {


    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klasside objektidele (beans)
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    // See meetod on defineeritud nii, et ta võtab sisse String tüüpi objektid
    // See on selleks vajalik, et me saaksime siin meetodis nende objektide andmetega kuidagi edasi toimetada.
    // See meetod on defineeritud nii, et ta peab tagastama LoginResponse tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public LoginResponse login(String username, String password) {
        // Võtame login() signatuuris parameetritena sisse String tüüpi objektid
        // Siin signatuuris antakse sellele objekti muutujatele nimeks 'username' ja 'password'

        // Kutsume välja meie poolt defineeritud meetodi userService.findUser()
        // See meetod on meil ära defineeritud UserService klassis
        // userService.findUser() on meil selliselt defineeritud, et see võtab sisse parameetritena: String tüüpi objektid username, password
        // Parameetrid on selleks vajalikud, et me saaksime meetodisse kaasa anda mingi objektid (andmed),
        // millega me soovime siis seal meetodi sees kuidagi toimetada.
        // Seega kuna meil on siin mingid andmed, mida mida väljakutsutav meetod vajab,
        // siis me peame väljakutsumisel need kenasti kaasa andma (meetodi väljakutsumise argumendid).

        // userService.findUser() meetod on defineeritud nii, et see tagastab User tüüpi objekti
        // See User klass on Entity tüüpi klass (andmebaasi tabeli jaoks mõeldud klass)
        // Pane tähele, et hetkel me asume business kihi service sees (MingiÄriController -> MingiÄriService) ja siit klassist me ei pöördu otse repository-de vastu,
        // vaid läheme läbi domain kihis asuva service (MingiEntityService -> MingiEntityRepository)
        // Ehk siis me lähme toome info ära
        //      MingiÄriController -> MingiÄriService -> MingiEntityService -> MingiEntityRepository ja saame info kätte entity objektidena
        // Kui 3 kihiline arhidektuuri teema on veel endiselt segane, siis palun vaata uuesti "GetMapping-Resource-Service-JSON" video.
        // NB! Seal videos veidi triviaalsem näide ja pole seda MingiEntityService osa.
        // https://youtu.be/2tB5ybhPGgk
        // vaata ka kommentaare selle 'userService.findUser()' meetodi sees
        // Tulemus pannakse 'user' objekti sisse.
        User user = userService.findUser(username, password);


        // (Entity -> Dto)
        // Siin vaatleme kõigepealt paremat poolt. Kutsutakse välja meetod toDto(), mis on defineeritud UserMapper klassis
        // Argumendina anname kaasa user objekti (Entity = andmebaasi tabeli jaoks mõeldud klass)
        // toDto() on põhimõtteliselt mäpper meetod "Entity -> Dto"
        // toDto võtab parameetrina Entity (andmebaasi tabeli jaoks mõeldud klass) klassi tüüpi objekti
        // ja tagastab -> Dto (Data Transfer Object - andmete liigutamiseks mõeldud klass)
        // toDto() meetod tagastab tulemuse, mis pannakse muutujasse 'response'
        // vaata ka kommentaare selle 'userMapper.toDto()' meetodi sees
        LoginResponse response = userMapper.toDto(user);

        // tagastame controllerist väljakutsutud meetodi vastuse 'loginResponse' objekti
        return response;
    }



}
