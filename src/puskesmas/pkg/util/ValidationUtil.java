package puskesmas.pkg.util;

/**
 * @author Achmad Raihan
 */
public class ValidationUtil {

    public static boolean isNumber(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
