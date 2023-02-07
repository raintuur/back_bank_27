package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.login.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

// See annotatsioon on siin all selle jaoks vajalik, et anda MapStruct tehnoloogiale märku,
// et siin klassis toimetatakse andmete üle tõstmisega  / kaardistamisega, ühe klassi objektilt, teise klassi objektile
// Asja iva on see, et me ei tohi rakenduse controller kihis võtta requestist sisse või väljastada responses Entity klassist tehtud objekte
// Seetõttu peame me lihtsalt tekitama objektid spetsiaalselt selleks otstarbeks mõeldud klassidest (DTO - Data Transfer Object).
// Mapperid aitavad meil mugavalt neid objekte luua mõlemal suunal:
//      Dto -> Entity
//      Entity -> Dto
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
// See klass on interface
// Interface on selline klass, mis on malliks/šablooniks/mudeliks kõikidele nendele klassidele, mis teda imlpementeerivad.
// Interface klassis saab ära defineerida kõik kohustuslikud meetodid, mida implemeteerivad klassid peavad siis kindlasti sisaldama.
public interface UserMapper {


    // Mäpper (Entity -> Dto)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.

    // Siin on ära defineeritud meetod, millel ei ole keha
    // Projekti käivitamisel/jooksutamisel ehitatakse kogu projekt serverile kenasti valmis
    // ning selle ehitamise käigus üritab MapStructi tehnoloogia ise selle õige lahenduse/koodiosa valmis kirjutada (implementeerida)
    // @Mapping annotatsioonide sees saame MapStructi tehnoloogiat kaardistamise lahenuduse osas aidata (source, target, constant, expression, qualifiedByName jne).

    // Siin näiteks kasutame @Mapping annotatsiooni, et aidata MapStructi mäpperit toDto() meetodi implementatsiooni kirjutamisel
    // source = meetodi signatuuri sees olev parameeter 'user' on sisend/sisse tulev info, millel on olemas väli 'id'
    // target = meetod tagastab LoginResponse tüüpi objekti (väljund), millel on väli 'userId'
    // kaardistatakse mõlema objekti need väljad mis omavahel kokku käivad, ehk siis siin näites
    // 'user' objekti väljalt "id" soovime andmeid kanda üle tagastatavale LoginResponse tüüpi objekti 'userId' väljale
    // Need väljad mille nimed ja tüübid on täpselt samasugused, neid me ise kaardistama ei pea, sest MapStruct oskab need kaardistused ise kokku viia
    // Kui projekti ülesse ehitamisel on MapStruct meetodi implementatsiooni valmis genereerinud, siis tekib IntelliJ's koodi reanumbri
    // Kui MapStruct mäppimise teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine" ja "JPA Buddy mapperite kasutamine"
    // https://youtu.be/BrSMvqcGMio
    // https://youtu.be/AjGcVDcNlm4
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.type", target = "roleType")
    LoginResponse toDto(User user);

}