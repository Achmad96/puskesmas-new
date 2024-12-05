package puskesmas.pkg.frame;

import javax.swing.JPanel;
import puskesmas.pkg.App;

/**
 * @author Achmad Raihan
 */
public class MenuPanel extends JPanel {

  private PatientPanel patientPanel;
  private MedicinePanel medicinePanel;
  private HealthWorkerPanel healthWorkerPanel;
  private HistoriesPanel historiesPanel;

  private BookingPanel bookingPanel;
  private ExaminationPanel examinationPanel;
  private PaymentPanel paymentPanel;

  public MenuPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jInternalFrame1 = new javax.swing.JInternalFrame();
    patientBtn = new javax.swing.JButton();
    healthWorkerBtn = new javax.swing.JButton();
    medicineBtn = new javax.swing.JButton();
    bookingBtn = new javax.swing.JButton();
    examinationBtn = new javax.swing.JButton();
    paymentBtn = new javax.swing.JButton();
    backBtn = new javax.swing.JButton();
    historiesBtn = new javax.swing.JButton();

    jLabel1.setText("jLabel1");

    jInternalFrame1.setVisible(true);

    javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
    jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
    jInternalFrame1Layout.setHorizontalGroup(
      jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    jInternalFrame1Layout.setVerticalGroup(
      jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    patientBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    patientBtn.setText("Pasien");
    patientBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        patientBtnActionPerformed(evt);
      }
    });

    healthWorkerBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    healthWorkerBtn.setText("Tenaga Kesehatan");
    healthWorkerBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        healthWorkerBtnActionPerformed(evt);
      }
    });

    medicineBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    medicineBtn.setText("Obat");
    medicineBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        medicineBtnActionPerformed(evt);
      }
    });

    bookingBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    bookingBtn.setText("Nomor Antrian");
    bookingBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bookingBtnActionPerformed(evt);
      }
    });

    examinationBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    examinationBtn.setText("Pemeriksaan");
    examinationBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        examinationBtnActionPerformed(evt);
      }
    });

    paymentBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    paymentBtn.setText("Pembayaran Obat");
    paymentBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        paymentBtnActionPerformed(evt);
      }
    });

    backBtn.setText("kembali");
    backBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backBtnActionPerformed(evt);
      }
    });

    historiesBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    historiesBtn.setText("Riwayat");
    historiesBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        historiesBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(110, 110, 110)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(medicineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(patientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(healthWorkerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(93, 93, 93)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(paymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(examinationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(bookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(103, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(historiesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(248, 248, 248))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(52, 52, 52)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(patientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(healthWorkerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(examinationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(medicineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(paymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(historiesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(34, 34, 34))
    );
  }// </editor-fold>//GEN-END:initComponents

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
      if (paymentPanel == null) {
        paymentPanel = new PaymentPanel();
      }
      App.getInstance().switchPanelTo(paymentPanel);
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      App.getInstance().back();
    }//GEN-LAST:event_backBtnActionPerformed

    private void patientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientBtnActionPerformed
      if (patientPanel == null) {
        patientPanel = new PatientPanel();
      }
      App.getInstance().switchPanelTo(patientPanel);
    }//GEN-LAST:event_patientBtnActionPerformed

    private void bookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingBtnActionPerformed
      if (bookingPanel == null) {
        bookingPanel = new BookingPanel();
      }
      App.getInstance().switchPanelTo(bookingPanel);
    }//GEN-LAST:event_bookingBtnActionPerformed

    private void examinationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinationBtnActionPerformed
      if (examinationPanel == null) {
        examinationPanel = new ExaminationPanel();
      }
      App.getInstance().switchPanelTo(examinationPanel);
    }//GEN-LAST:event_examinationBtnActionPerformed

    private void healthWorkerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthWorkerBtnActionPerformed
      if (healthWorkerPanel == null) {
        healthWorkerPanel = new HealthWorkerPanel();
      }
      App.getInstance().switchPanelTo(healthWorkerPanel);
    }//GEN-LAST:event_healthWorkerBtnActionPerformed

    private void medicineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineBtnActionPerformed
      if (medicinePanel == null) {
        medicinePanel = new MedicinePanel();
      }
      App.getInstance().switchPanelTo(medicinePanel);
    }//GEN-LAST:event_medicineBtnActionPerformed

  private void historiesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiesBtnActionPerformed
    if (historiesPanel == null) {
      historiesPanel = new HistoriesPanel();
    }
    App.getInstance().switchPanelTo(historiesPanel);
  }//GEN-LAST:event_historiesBtnActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backBtn;
  private javax.swing.JButton bookingBtn;
  private javax.swing.JButton examinationBtn;
  private javax.swing.JButton healthWorkerBtn;
  private javax.swing.JButton historiesBtn;
  private javax.swing.JInternalFrame jInternalFrame1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JButton medicineBtn;
  private javax.swing.JButton patientBtn;
  private javax.swing.JButton paymentBtn;
  // End of variables declaration//GEN-END:variables
}
