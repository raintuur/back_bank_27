package ee.valiit.back_bank_27.bank.login;

import ee.valiit.back_bank_27.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController annab Springile märku, et siin klassis on mingid endpoint'id (controllerid)
// Ühtlasi teeb Spring rakendust käivitades ka sellest klassist ühe objekti, mille kaudu saab servlet dispatcher vastavat meetodit käivitada.
@RestController
public class LoginController {

    // Kui meie veebirakendus tõmmatakse käima, siis taustal toimetab servlet dispatcher,
    // kes teab kõiki meie controllerite endpointide definitsioone
    // Kui see teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klasside objektidele (beans)
    @Resource
    private LoginService loginService;

    // Kui meie veebiserverisse tuleb sisse http päring 'GET' 'http://localhost:8080/login?username=admin&password=123'
    // siis käivitatakse selle mäppingu all olev meetod login()
    // Kaardistamisel mängivad rolli just see URL '/login' ja HTTP meetod 'GET'
    // Kuna login() meetod, on defineeritud nii, et see tagastab LoginResponse tüüpi objekti,
    // siis RETURN'is peab olema LoginResponse tüüpi objekt (see vastus läheb serverist välja JSON sõnumina)
    // Kuna meetodi parameetris on ära defineeritud @RequestParam String tüüpi objektid,
    // siis Spring eeldab, et http sõnumile antakse kaasa request parameeter 'username' ja 'password'
    // Kindlasti peab meetodi signatuuris olema ka see @RequestParam annotatsioonid, sest muidu Spring ei tea,
    // et siia enpoint'ile peaks ka sisse tulema sellised parameetrid
    // Meetodi käivitamise kaardistamise osas nende parameetrite olemasolu mingit rolli ei mängi - loevad vaid URL ja HTTP meetod.
    // Küsimus on lihtsalt selles, et kas me soovime siia teenusesse mingit infot kaasa anda, mida saame siis kuidagi kasutada.

    // Kui HTTP sõnumite saatmise ja kättesaamise teema on veel endiselt segane, siis palun vaata uuesti "Spring HelloWorld":
    // https://youtu.be/pc9irBCk6rg
    // Kui @RequestParam teema on veel endiselt segane, siis palun vaata uuesti "Spring @RequestParam":
    // https://youtu.be/9ovmRakMRBY
    // Kui JSON'i sõnumi struktuuri teema on veel endiselt segane, siis palun vaata uuesti "JSON":
    // https://youtu.be/dyZUWR3Cchw
    @GetMapping("/login")
    // @Operation() summary ja description aitavad genereerida OpenAPI dokumentatsiooni faili,
    // mida Swagger suudab graafiliselt kuvada ja ka käivitada
    @Operation(summary = "This service enables user to log-in", description = "This service will return error when incorrect credentials are provided")
    // @ApiResponses() alla saab lisada info selle kohta, et milliseid status code see teenus tagastab.
    // Ühtlasi saab ka vea sõnumite esitamise jaoks ära defineerida JSON'i struktuuri (klassi objekti),
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Failed login", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        // Võtame login() signatuuri parameetris sisse String tüüpi väärtused
        // Siin signatuuris antakse nendele objektidele nimeks 'username' ja 'password'
        // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
        // https://youtu.be/EI3XfkdPBc4
        // https://youtu.be/GvP68LBZiUA
        // https://youtu.be/4ZkvNfu9kNw

        // Kutsume välja meie poolt LoginService klassis defineeritud meetodi nimega login()
        // Meetodi väljakutsumisel anname argumentidena kaasa mingit infot, näiteks:
        //      username = admin
        //      password = 123
        // See meetod on meil ära defineeritud LoginService klassis
        // login() on meil selliselt defineeritud, et ta võtab parameetritena sisse:
        //      String tüüpi objektid: username ja password
        // See on selleks vajalik, et me saaksime anda meetodisse kaasa anda mingid objektid, kus sees on mingid andmed,
        // millega me soovime kuidagi edasi toimetada.
        // loginService.login() meetod on defineeritud nii, et see tagastab LoginResponse tüüpi objekti
        // siin all me loome uue LoginResponse tüüpi objekti 'loginResponse' mille sisse väärtustatakse selle login() meetodi poolt tagastatav tulemus.
        // vaata ka kommentaare selle meetodi sees
        LoginResponse loginResponse = loginService.login(username, password);

        // http päringule tagastatakse 'loginResponse' objekt JSON'i kujul
        return loginResponse;
    }

}
