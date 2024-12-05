package puskesmas.pkg.frame;

import javax.swing.JPanel;
import puskesmas.pkg.App;
import puskesmas.pkg.util.TemplateGenerator;

/**
 * @author Achmad Raihan
 */
public class HistoriesPanel extends JPanel {

  private final TemplateGenerator templateGenerator;
  private String paymentCategory;
  private String examinationCategory;

  public HistoriesPanel() {
    initComponents();
    this.templateGenerator = new TemplateGenerator();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList<>();
    examinationGroupBtn = new javax.swing.ButtonGroup();
    paymentGroupBtn = new javax.swing.ButtonGroup();
    paymentsHistory = new javax.swing.JButton();
    examinationHistory = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    weekCategoryBtn = new javax.swing.JRadioButton();
    jLabel3 = new javax.swing.JLabel();
    monthCategoryBtn = new javax.swing.JRadioButton();
    yearCategoryBtn = new javax.swing.JRadioButton();
    jLabel4 = new javax.swing.JLabel();
    yearCategoryBtn1 = new javax.swing.JRadioButton();
    monthCategoryBtn1 = new javax.swing.JRadioButton();
    weekCategoryBtn1 = new javax.swing.JRadioButton();
    backBtn = new javax.swing.JButton();

    jList1.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(jList1);

    paymentsHistory.setText("lihat riwayat");
    paymentsHistory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        paymentsHistoryActionPerformed(evt);
      }
    });

    examinationHistory.setText("lihat riwayat");
    examinationHistory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        examinationHistoryActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Riwayat Pembayaran");

    jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Riwayat Pemeriksaan");

    examinationGroupBtn.add(weekCategoryBtn);
    weekCategoryBtn.setText("Minggu");
    weekCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        weekCategoryBtnActionPerformed(evt);
      }
    });

    jLabel3.setText("*Dikelompokkan berdasarkan");

    examinationGroupBtn.add(monthCategoryBtn);
    monthCategoryBtn.setText("Bulan");
    monthCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        monthCategoryBtnActionPerformed(evt);
      }
    });

    examinationGroupBtn.add(yearCategoryBtn);
    yearCategoryBtn.setText("Tahun");
    yearCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        yearCategoryBtnActionPerformed(evt);
      }
    });

    jLabel4.setText("*Dikelompokkan berdasarkan");

    paymentGroupBtn.add(yearCategoryBtn1);
    yearCategoryBtn1.setText("Tahun");
    yearCategoryBtn1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        yearCategoryBtn1ActionPerformed(evt);
      }
    });

    paymentGroupBtn.add(monthCategoryBtn1);
    monthCategoryBtn1.setText("Bulan");
    monthCategoryBtn1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        monthCategoryBtn1ActionPerformed(evt);
      }
    });

    paymentGroupBtn.add(weekCategoryBtn1);
    weekCategoryBtn1.setText("Minggu");
    weekCategoryBtn1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        weekCategoryBtn1ActionPerformed(evt);
      }
    });

    backBtn.setText("kembali");
    backBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(48, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addGroup(layout.createSequentialGroup()
            .addComponent(weekCategoryBtn1)
            .addGap(29, 29, 29)
            .addComponent(monthCategoryBtn1)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        .addComponent(yearCategoryBtn1)
        .addGap(0, 67, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
              .addComponent(paymentsHistory)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(weekCategoryBtn)
                    .addGap(36, 36, 36)
                    .addComponent(monthCategoryBtn))
                  .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(yearCategoryBtn)
                  .addComponent(examinationHistory))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(14, 14, 14)
        .addComponent(jLabel1)
        .addGap(26, 26, 26)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(monthCategoryBtn1)
          .addComponent(weekCategoryBtn1)
          .addComponent(yearCategoryBtn1))
        .addGap(43, 43, 43)
        .addComponent(paymentsHistory)
        .addGap(18, 18, 18)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(60, 60, 60)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(weekCategoryBtn)
              .addComponent(monthCategoryBtn)
              .addComponent(yearCategoryBtn))
            .addGap(26, 26, 26)))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(examinationHistory)
          .addComponent(backBtn))
        .addGap(33, 33, 33))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void paymentsHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentsHistoryActionPerformed
    templateGenerator.printPaymentsHistory(paymentCategory);
  }//GEN-LAST:event_paymentsHistoryActionPerformed

  private void examinationHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinationHistoryActionPerformed
    templateGenerator.printExaminationsHistory(examinationCategory);
  }//GEN-LAST:event_examinationHistoryActionPerformed

  private void weekCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekCategoryBtnActionPerformed
    examinationCategory = "week";
  }//GEN-LAST:event_weekCategoryBtnActionPerformed

  private void monthCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCategoryBtnActionPerformed
    examinationCategory = "month";
  }//GEN-LAST:event_monthCategoryBtnActionPerformed

  private void yearCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCategoryBtnActionPerformed
    examinationCategory = "year";
  }//GEN-LAST:event_yearCategoryBtnActionPerformed

  private void yearCategoryBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCategoryBtn1ActionPerformed
    paymentCategory = "year";
  }//GEN-LAST:event_yearCategoryBtn1ActionPerformed

  private void monthCategoryBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCategoryBtn1ActionPerformed
    paymentCategory = "month";
  }//GEN-LAST:event_monthCategoryBtn1ActionPerformed

  private void weekCategoryBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekCategoryBtn1ActionPerformed
    paymentCategory = "week";
  }//GEN-LAST:event_weekCategoryBtn1ActionPerformed

  private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
    App.getInstance().back();
  }//GEN-LAST:event_backBtnActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backBtn;
  private javax.swing.ButtonGroup examinationGroupBtn;
  private javax.swing.JButton examinationHistory;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JList<String> jList1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton monthCategoryBtn;
  private javax.swing.JRadioButton monthCategoryBtn1;
  private javax.swing.ButtonGroup paymentGroupBtn;
  private javax.swing.JButton paymentsHistory;
  private javax.swing.JRadioButton weekCategoryBtn;
  private javax.swing.JRadioButton weekCategoryBtn1;
  private javax.swing.JRadioButton yearCategoryBtn;
  private javax.swing.JRadioButton yearCategoryBtn1;
  // End of variables declaration//GEN-END:variables
}
