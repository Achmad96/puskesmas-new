package puskesmas.pkg.util;

import puskesmas.pkg.enums.MessageType;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * @author Achmad Raihan
 */
public class MessageUtil {

    public static void showMessageDialog(Component parent, String message, MessageType messageType) {
        switch (messageType) {
            case INFORMATION ->
                JOptionPane.showMessageDialog(parent, message, "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            case ERROR ->
                JOptionPane.showMessageDialog(parent, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int showConfirmDialog(Component parent, String message) {
        return JOptionPane.showConfirmDialog(parent, message, "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }

    public static int showWarningDialog(Component parent, String message) {
        return JOptionPane.showConfirmDialog(parent, message, "PERINGATAN", JOptionPane.YES_NO_OPTION);
    }
}
