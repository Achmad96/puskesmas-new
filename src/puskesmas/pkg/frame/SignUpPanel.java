package puskesmas.pkg.frame;

import puskesmas.pkg.helper.AuthHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import puskesmas.pkg.App;

/**
 * @author Achmad Raihan
 */
public class SignUpPanel extends JPanel {

    private final AuthHelper authHelper;
    private String username;
    private String displayName;
    private String phone;
    private String password;

    public SignUpPanel() {
        initComponents();
        authHelper = new AuthHelper();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        signupBtn = new javax.swing.JButton();
        loginLbl = new javax.swing.JLabel();
        displayNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setText("Sign Up");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        jLabel3.setText("Nama Pengguna");

        signupBtn.setText("daftar");
        signupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });

        loginLbl.setText("sudah punya akun? masuk!");
        loginLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginLblMouseExited(evt);
            }
        });

        displayNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayNameFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama Tampilan");

        jLabel6.setText("Nomor Telepon");

        phoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(78, 78, 78))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(passwordField)
                            .addGap(51, 51, 51))
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(displayNameField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(signupBtn)
                            .addGap(46, 46, 46)
                            .addComponent(loginLbl))
                        .addComponent(phoneField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLbl)
                    .addComponent(signupBtn))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        username = usernameField.getText().trim();
        if (username.isEmpty()) {
            return;
        }
        displayNameField.requestFocus();
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void signupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBtnActionPerformed
        username = usernameField.getText().trim();
        displayName = displayNameField.getText().trim();
        phone = phoneField.getText().trim();
        password = String.valueOf(passwordField.getPassword());

        if (!isValidFields(username, displayName, phone, password)) {
            JOptionPane.showMessageDialog(this, "Please fill the blank's input", "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        final String salt = AuthHelper.getSaltvalue();
        password = AuthHelper.generateSecurePassword(password, salt);
        final HashMap<String, Object> options = new HashMap<>();
        options.put("nama", displayName);
        options.put("nomor_telepon", phone);
        options.put("password", password);
        options.put("salt", salt);
        final boolean isSucess = authHelper.insertData(username, options);
        if (isSucess) {
            JOptionPane.showMessageDialog(this, "Sign up sucess!", "Sucess Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Failed to sign up", "Error Message", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_signupBtnActionPerformed

    private void displayNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayNameFieldActionPerformed
        displayName = displayNameField.getText().trim();
        if (displayName.isEmpty()) {
            return;
        }
        phoneField.requestFocus();
    }//GEN-LAST:event_displayNameFieldActionPerformed

    private void loginLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLblMouseClicked
        App.getInstance().back();
    }//GEN-LAST:event_loginLblMouseClicked

    private void phoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneFieldActionPerformed
        phone = phoneField.getText().trim();
        if (phone.isEmpty()) {
            return;
        }
        passwordField.requestFocus();
    }//GEN-LAST:event_phoneFieldActionPerformed

    private void loginLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLblMouseEntered
        loginLbl.setForeground(Color.BLUE);
        loginLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_loginLblMouseEntered

    private void loginLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLblMouseExited
        loginLbl.setForeground(Color.BLACK);
        loginLbl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_loginLblMouseExited

    private boolean isValidFields(String username, String displayName, String nomorTelepon, String password) {
        return !username.isEmpty() && !displayName.isEmpty() && !nomorTelepon.isEmpty() && !password.isEmpty();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField displayNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton signupBtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
