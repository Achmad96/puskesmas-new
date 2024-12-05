package puskesmas.pkg.frame;

import puskesmas.pkg.helper.PatientHistoryHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import puskesmas.pkg.App;

/**
 * @author Achmad Raihan
 */
public final class PatientHistoryPanel extends JPanel implements PanelBase {

  private final Object[] patient;
  private final PatientHistoryHelper patientHistoryHelper = new PatientHistoryHelper();
  private final ArrayList<Object[]> dataList = new ArrayList<>();

  public PatientHistoryPanel(String patientId, String name, int age, String gender) {
    initComponents();

    patient = new Object[4];
    patient[0] = patientId;
    patient[1] = name;
    patient[2] = age;
    patient[3] = gender;

    this.loadData();
    this.loadPatientData();
  }

  public Object[] getPatient() {
    return patient;
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("RIWAYAT PASIEN");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Nakes", "Nama Nakes", "Keluhan", "Diagnosis", "Resep Obat", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel3.setText("Nama Pasien");

        jLabel4.setText("Umur");

        nameLabel.setText("-");

        jLabel6.setText("tahun");

        ageLabel.setText("-");

        jLabel7.setText("Jenis Kelamin");

        genderLabel.setText("-");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(57, 57, 57)
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel1)))
                .addContainerGap(231, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(genderLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backBtn)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      App.getInstance().back();
    }//GEN-LAST:event_backBtnActionPerformed

  private void loadPatientData() {
    final String patientName = patient[1].toString();
    final int patientAge = (int) patient[2];
    final String patientGender = patient[3].toString();

    nameLabel.setText(patientName);
    ageLabel.setText(String.valueOf(patientAge));
    genderLabel.setText(patientGender);
  }

  @Override
  public void loadData() {
    try {
      dataList.clear();
      final String patientId = patient[0].toString();
      final ResultSet resultSet = patientHistoryHelper.getDataById(patientId);
      while (resultSet.next()) {
        final Object[] data = {
          resultSet.getString("id_nakes"), resultSet.getString("nama_nakes"),
          resultSet.getString("diagnosis"), resultSet.getString("keluhan"),
          resultSet.getString("tindakan"), resultSet.getString("id_resep_obat"), resultSet.getString("tanggal_pemeriksaan")};
        dataList.add(data);
      }
      table.setModel(getUpdatedModel(table, dataList));
    } catch (NullPointerException | SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
