package ee.valiit.back_bank_27.infrastructure.error;

import lombok.Data;

// See klass on meie enda loodud.
// Sisuliselt on see andmekandja, mida me kasutame klassis RestExceptionHandler ja täidame ära andmetega.
// Selle sama klassi täidetud andmetega objekti tagastatakse error olukorras RestControlleris
// ja tagastatavas sõnumis tõlgendatakse see JSON sõnumiks.
// Proovi mõnda teenust Swaggeris, kus peaks tekima mingi viga ja vaata,
// et tõesti tekib vastuses JSON sõnum koos nende väljadega, mis on siin sõnumis.
@Data
public class ApiError {
    private String message;
    private String errorCode;
}

