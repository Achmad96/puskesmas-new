package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.helper.AuthHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import puskesmas.pkg.App;
import puskesmas.pkg.util.MessageUtil;

/**
 * @author Achmad Raihan
 */
public class LoginFrame extends JFrame {

    private final AuthHelper authHelper;
    private SignUpPanel signUpPanel;
    private MenuPanel menuPanel;
    private String username;

    public LoginFrame() {
        initComponents();
        this.setTitle("Puskesmas");
        authHelper = new AuthHelper();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        signupLbl = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel1.setText("LOGIN");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        jLabel3.setText("Username");

        loginBtn.setText("masuk");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        signupLbl.setText("belum punya akun? daftar!");
        signupLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupLblMouseExited(evt);
            }
        });

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(loginBtn)
                                .addGap(18, 18, 18)
                                .addComponent(signupLbl))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernameField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn)
                    .addComponent(signupLbl))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        username = usernameField.getText().trim();
        if (username.isEmpty()) {
            return;
        }
        passwordField.requestFocus();
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void login() {
        try {
            username = usernameField.getText().trim();
            if (!isValidFields(username, String.valueOf(passwordField.getPassword()).trim())) {
                return;
            }

            final ResultSet data = authHelper.getDataById(username);
            if (!data.next()) {
                MessageUtil.showMessageDialog(this, "username atau password salah!", MessageType.ERROR);
                return;
            }
            final String securedPassword = data.getString("password");
            final String salt = data.getString("salt");
            final String plainPassword = String.valueOf(passwordField.getPassword());
            final boolean isValid = AuthHelper.verifyUserPassword(plainPassword, securedPassword, salt);
            if (!isValid) {
                MessageUtil.showMessageDialog(this, "username atau password salah!", MessageType.ERROR);
                return;
            }
            MessageUtil.showMessageDialog(this, "Login berhasil!", MessageType.INFORMATION);
            if (menuPanel == null) {
                menuPanel = new MenuPanel();
            }
            App.getInstance().switchPanelTo(menuPanel);
        } catch (SQLException exception) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        this.login();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void signupLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupLblMouseClicked
        if (signUpPanel == null) {
            signUpPanel = new SignUpPanel();
        }
        App.getInstance().switchPanelTo(signUpPanel);
    }//GEN-LAST:event_signupLblMouseClicked

    private void signupLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupLblMouseEntered
        signupLbl.setForeground(Color.BLUE);
        signupLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_signupLblMouseEntered

    private void signupLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupLblMouseExited
        signupLbl.setForeground(Color.BLACK);
        signupLbl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_signupLblMouseExited

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            return;
        }
        login();
    }//GEN-LAST:event_passwordFieldKeyPressed

    private boolean isValidFields(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel signupLbl;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
