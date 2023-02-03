package ee.valiit.back_bank_27.util;

public class PictureUtil {

    public static String byteArrayToString(byte[] byteArray) {

        if (byteArray == null) {
           return null;
        }

        return new String(byteArray);
//        One liner ternary operator
//        return byteArray == null ? null : new String(byteArray);
    }
}
