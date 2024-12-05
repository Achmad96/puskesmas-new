package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.helper.ExaminationHelper;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import puskesmas.pkg.App;
import puskesmas.pkg.util.IDGenerator;
import puskesmas.pkg.util.MessageUtil;
import static puskesmas.pkg.util.ValidationUtil.isNumber;

/**
 * @author Achmad Raihan
 */
public class ExaminationPanel extends JPanel implements PanelBase {

  private final ExaminationHelper examinationHelper;
  private final ArrayList<Object[]> healthWorkers;
  private PrecriptionDrugsPanel precriptionDrugsPanel;
  private Object[] patient;

  public ExaminationPanel() {
    this.healthWorkers = new ArrayList<>();
    this.examinationHelper = new ExaminationHelper();

    initComponents();
    handleConnection();
  }
  
  private void handleConnection() {
    try {
      if (examinationHelper.getConnection() == null || examinationHelper.getConnection().isClosed()) {
        examinationHelper.createConnection();
      }
      if (examinationHelper.getConnection().getAutoCommit()) {
        examinationHelper.getConnection().setAutoCommit(false);
      }
    } catch (SQLException exception) {
      Logger.getLogger(ExaminationPanel.class.getName()).log(Level.SEVERE, null, exception);
    }
  }
  
  private String generateID() {
    return IDGenerator.generateID("PMN", 15);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    queueNumberField = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    patientNameField = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    grouchField = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    diagnosisField = new javax.swing.JTextField();
    actionField = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    backBtn = new javax.swing.JButton();
    addBtn = new javax.swing.JButton();
    jLabel11 = new javax.swing.JLabel();
    polyField = new javax.swing.JTextField();
    receiptBtn = new javax.swing.JButton();
    healthWorkerNameComboBox = new javax.swing.JComboBox<>();

    jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Pemeriksaan");

    jLabel2.setText("Nomor Antrian");

    queueNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        queueNumberFieldKeyPressed(evt);
      }
    });

    jLabel5.setText("Nama Nakes");

    patientNameField.setEditable(false);

    jLabel6.setText("Nama Pasien");

    jLabel7.setText("Keluhan");

    jLabel8.setText("Diagnosis");

    jLabel9.setText("Tindakan");

    jLabel10.setText("Resep Obat");

    backBtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
    backBtn.setText("kembali");
    backBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backBtnActionPerformed(evt);
      }
    });

    addBtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
    addBtn.setText("tambah");
    addBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addBtnActionPerformed(evt);
      }
    });

    jLabel11.setText("Poli");

    polyField.setEditable(false);

    receiptBtn.setText("edit resep");
    receiptBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        receiptBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel9)
            .addGap(257, 257, 257)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(receiptBtn)
              .addComponent(jLabel10))
            .addGap(428, 428, 428))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(queueNumberField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addComponent(patientNameField, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(grouchField, javax.swing.GroupLayout.Alignment.LEADING))
              .addComponent(jLabel7)
              .addComponent(jLabel6)
              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(actionField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(55, 55, 55)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel5)
              .addComponent(jLabel8)
              .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(diagnosisField)
              .addComponent(healthWorkerNameComboBox, 0, 250, Short.MAX_VALUE)
              .addComponent(polyField)
              .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jLabel11))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(queueNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(polyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(jLabel5))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(patientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(healthWorkerNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(jLabel8))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(grouchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(diagnosisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(jLabel9)
            .addGap(18, 18, 18)
            .addComponent(actionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(44, 44, 44))
              .addComponent(receiptBtn))))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(backBtn)
          .addComponent(addBtn))
        .addContainerGap(34, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      try {
        if (examinationHelper.getConnection() != null) {
          if (examinationHelper.getConnection().isClosed()) {
            App.getInstance().back();
            return;
          }
          if (examinationHelper.getConnection().getAutoCommit() == false) {
            examinationHelper.getConnection().rollback();
            examinationHelper.closeConnection();
          }
        }
        App.getInstance().back();
      } catch (SQLException exception) {
        Logger.getLogger(ExaminationPanel.class.getName()).log(Level.SEVERE, null, exception);
      }
    }//GEN-LAST:event_backBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
      try {
        if (!isDataValid()) {
          MessageUtil.showMessageDialog(this, "Tolong isi data terlebih dahulu!", MessageType.ERROR);
          return;
        }
        if (precriptionDrugsPanel == null || precriptionDrugsPanel.getRecipeId() == null) {
          MessageUtil.showMessageDialog(this, "Tolong isi resep obat terlebih dahulu!", MessageType.ERROR);
          return;
        }
        final String examinationId = this.generateID();
        final HashMap<String, Object> params = new HashMap<>();
        final int queueNumber = (int) patient[0];
        final String patientId = patient[1].toString();
        final String healthWorkerId = healthWorkers.get(healthWorkerNameComboBox.getSelectedIndex())[0].toString();
        final String recipeId = precriptionDrugsPanel.getRecipeId();
        final String grouch = grouchField.getText().trim();
        final String diagnosis = diagnosisField.getText().trim();
        final String action = actionField.getText().trim();
        
        params.put("id_pasien", patientId);
        params.put("id_nakes", healthWorkerId);
        params.put("keluhan", grouch);
        params.put("diagnosis", diagnosis);
        params.put("tindakan", action);
        params.put("id_resep_obat", recipeId);
        
        final HashMap<String, Object> params2 = new HashMap<>();
        params2.put("nomor_antrian", queueNumber);
        int isConfirm = MessageUtil.showConfirmDialog(this, "Apakah Data yang dimasukkan sudah benar?");
        if (isConfirm != 0) {
          return;
        }
        final boolean isSuccess = examinationHelper.insertData(examinationId, params, params2);
        if (!isSuccess) {
          MessageUtil.showMessageDialog(this, "Gagal menambahkan data!", MessageType.ERROR);
          examinationHelper.getConnection().rollback();
          return;
        }
        MessageUtil.showMessageDialog(this, "Berhasil menambahkan data pemeriksaan!", MessageType.INFORMATION);
        examinationHelper.getConnection().commit();
        examinationHelper.closeConnection();
        resetData();
      } catch (SQLException exception) {
        Logger.getLogger(ExaminationPanel.class.getName()).log(Level.SEVERE, null, exception);
      }
    }//GEN-LAST:event_addBtnActionPerformed

  private void filterHealthWorker(int polyId) {
    try {
      healthWorkers.clear();
      healthWorkerNameComboBox.removeAllItems();
      final ResultSet resultSet = examinationHelper.getHealthWorkersByPolyId(polyId);
      if (resultSet == null) {
        MessageUtil.showMessageDialog(this, "Terjadi kesalahan!", MessageType.ERROR);
        return;
      }
      while (resultSet.next()) {
        final Object[] data = new Object[4];
        data[0] = resultSet.getString("id_nakes");
        data[1] = resultSet.getString("nama_nakes");
        data[2] = resultSet.getString("id_poli");
        data[3] = resultSet.getString("nama_poli");
        healthWorkers.add(data);
        healthWorkerNameComboBox.addItem(data[1].toString());
      }
    } catch (SQLException exception) {
      Logger.getLogger(ExaminationPanel.class.getName()).log(Level.SEVERE, null, exception);
    }
  }

  private void resetData() {
    queueNumberField.setText("");
    polyField.setText("");
    patientNameField.setText("");
    grouchField.setText("");
    diagnosisField.setText("");
    actionField.setText("");
  }
  
    private void receiptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptBtnActionPerformed
      if (patient == null) {
        MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan!", MessageType.ERROR);
        return;
      }
      if (!isDataValid()) {
        MessageUtil.showMessageDialog(this, "Tolong isi semua data terlebih dahulu!", MessageType.ERROR);
        return;
      }
      precriptionDrugsPanel = new PrecriptionDrugsPanel(examinationHelper.getConnection(), patient[1].toString());
      App.getInstance().switchPanelTo(precriptionDrugsPanel);
    }//GEN-LAST:event_receiptBtnActionPerformed

  private void queueNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queueNumberFieldKeyPressed
    if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
      return;
    }
    try {
      if (!isNumber(queueNumberField.getText().trim())) {
        MessageUtil.showMessageDialog(this, "Nomor antrian harus berupa angka!", MessageType.ERROR);
        return;
      }
      handleConnection();
      final int queueNumber = Integer.parseInt(queueNumberField.getText().trim());
      final ResultSet resultSet = examinationHelper.getPatientByQueueNumber(queueNumber);
      if (resultSet == null) {
        if (patient != null) {
          queueNumberField.setText(patient[0].toString());
          MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan!", MessageType.ERROR);
          return;
        }
        queueNumberField.setText(null);
        MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan!", MessageType.ERROR);
        return;
      }
      if (!resultSet.next()) {
        if (patient != null) {
          queueNumberField.setText(patient[0].toString());
          MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan!", MessageType.ERROR);
          return;
        }
        queueNumberField.setText(null);
        MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan!", MessageType.ERROR);
        return;
      }
      if (patient == null) {
        patient = new Object[5];
      }
      patient[0] = resultSet.getInt("nomor_antrian");
      patient[1] = resultSet.getString("id_pasien");
      patient[2] = resultSet.getString("nama_pasien");
      patient[3] = resultSet.getInt("id_poli");
      patient[4] = resultSet.getString("nama_poli");

      patientNameField.setText(patient[2].toString());
      polyField.setText(patient[4].toString());
      filterHealthWorker((int) (patient[3]));
    } catch (SQLException exception) {
      Logger.getLogger(ExaminationPanel.class.getName()).log(Level.SEVERE, null, exception);
    }
  }//GEN-LAST:event_queueNumberFieldKeyPressed

  private boolean isDataValid() {
    return !healthWorkers.isEmpty() && patient != null && !grouchField.getText().trim().isEmpty() && !actionField.getText().trim().isEmpty() && !diagnosisField.getText().trim().isEmpty();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField actionField;
  private javax.swing.JButton addBtn;
  private javax.swing.JButton backBtn;
  private javax.swing.JTextField diagnosisField;
  private javax.swing.JTextField grouchField;
  private javax.swing.JComboBox<String> healthWorkerNameComboBox;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JTextField patientNameField;
  private javax.swing.JTextField polyField;
  private javax.swing.JTextField queueNumberField;
  private javax.swing.JButton receiptBtn;
  // End of variables declaration//GEN-END:variables

  @Override
  public void loadData() {
  }
}
