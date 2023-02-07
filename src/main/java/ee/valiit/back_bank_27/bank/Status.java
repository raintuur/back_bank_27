package ee.valiit.back_bank_27.bank;

public class Status {
    // Siin klassis on defineeritud staatilised konstantid.

    // public - annab nähtavuse üle kogu projekti

    // static - võimaldab konstandi väljakutsumist nii, et me ei pea sellest klassist tegema objekti,
    //      vaid me saame neid otse kasutada viidates kõigepealt klassile (suure algustähega)
    //      ning siis punkti abil saame väärtuse kätte, näiteks: Status.DEACTIVATED

    // final - muutujale saab anda väärtuse vaid ühe korra. Kompilaator ei lubaks anda sellele muutuja uut väärtust anda.
    //      Ehk siis see väärtus jääb garanteerult konstantselt samaks - ehk siis siit ka nimetus konstant
    //      konstandi muutuja nimetus on alati UPPER_SNAKE_CASE

    public static final String DEACTIVATED = "D";
    public static final String ACTIVE = "A";

}
