package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.helper.HealthWorkerHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import puskesmas.pkg.App;
import puskesmas.pkg.util.IDGenerator;
import puskesmas.pkg.util.MessageUtil;
import static puskesmas.pkg.util.ValidationUtil.isNumber;

/**
 * @author Achmad Raihan
 */
public final class HealthWorkerPanel extends JPanel implements PanelBase {

  private final ArrayList<Object[]> healthWorkers;
  private final ArrayList<Object[]> polyList;
  private final HealthWorkerHelper healthWorkerHelper;

  public HealthWorkerPanel() {
    healthWorkers = new ArrayList<>();
    healthWorkerHelper = new HealthWorkerHelper();
    polyList = new ArrayList<>();

    initComponents();
    initializeRadioButtons();
    initializePolyList();

    genderGroupBtn.setSelected(manRBtn.getModel(), true);
    this.loadData();
  }

  private void initializeRadioButtons() {
    manRBtn.setActionCommand("L");
    womanRBtn.setActionCommand("P");
  }

  private void initializePolyList() {
    try {
      final ResultSet resultSet = healthWorkerHelper.getPolyList();
      while (resultSet.next()) {
        final Object[] data = new Object[]{resultSet.getInt("id"), resultSet.getString("nama")};
        polyList.add(data);
        polyclinicComboBox.addItem(data[1].toString());
      }
      table.setModel(getUpdatedModel(table, healthWorkers));
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }
  
  private void generateID() {
    healthWorkerIdField.setText(IDGenerator.generateID("TKN", 15));
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    genderGroupBtn = new javax.swing.ButtonGroup();
    deleteBtn = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    backBtn = new javax.swing.JButton();
    healthWorkerIdField = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    manRBtn = new javax.swing.JRadioButton();
    nameField = new javax.swing.JTextField();
    womanRBtn = new javax.swing.JRadioButton();
    jLabel4 = new javax.swing.JLabel();
    ageField = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    phoneField = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    addBtn = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    healthWorkerTypeComboBox = new javax.swing.JComboBox<>();
    polyclinicComboBox = new javax.swing.JComboBox<>();
    updateBtn = new javax.swing.JButton();

    deleteBtn.setText("hapus");
    deleteBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteBtnActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Tenaga Kesehatan");
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    backBtn.setText("kembali");
    backBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backBtnActionPerformed(evt);
      }
    });

    healthWorkerIdField.setEditable(false);

    jLabel2.setText("Id Tenaga Kesehatan");

    jLabel3.setText("Nama");

    genderGroupBtn.add(manRBtn);
    manRBtn.setText("Laki - laki");
    manRBtn.setActionCommand("L");

    genderGroupBtn.add(womanRBtn);
    womanRBtn.setText("Perempuan");
    womanRBtn.setActionCommand("P");

    jLabel4.setText("Umur");

    jLabel6.setText("Jenis Kelamin");

    jLabel5.setText("Nomor Telepon");

    jLabel7.setText("Poli");

    jLabel8.setText("Jenis Nakes");

    addBtn.setText("tambah");
    addBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addBtnActionPerformed(evt);
      }
    });

    table.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id Nakes", "Nama", "Umur", "Nomor Telepon", "Jenis Kelamin", "Jenis Nakes", "Poli"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    table.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tableMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(table);

    healthWorkerTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dokter", "Suster" }));

    updateBtn.setText("ubah");
    updateBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addComponent(healthWorkerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(backBtn)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(addBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(deleteBtn))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(manRBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(womanRBtn))
                  .addComponent(healthWorkerTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(polyclinicComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGap(0, 41, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(healthWorkerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(manRBtn)
                .addComponent(womanRBtn))
              .addComponent(jLabel6))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel8)
              .addComponent(healthWorkerTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(polyclinicComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel7))
            .addGap(36, 36, 36)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(backBtn)
              .addComponent(addBtn)
              .addComponent(deleteBtn)
              .addComponent(updateBtn))
            .addGap(0, 63, Short.MAX_VALUE)))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      App.getInstance().back();
    }//GEN-LAST:event_backBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
      if (!isNumber(ageField.getText().trim())) {
        MessageUtil.showMessageDialog(this, "Umur harus berupa angka!", MessageType.ERROR);
        return;
      }
      if (!isDataValid()) {
        MessageUtil.showMessageDialog(this, "Mohon isi semua data terlebih dahulu!", MessageType.ERROR);
        return;
      }
      this.generateID();
      final String id = healthWorkerIdField.getText().trim();
      final String name = nameField.getText().trim();
      final int age = Integer.parseInt(ageField.getText().trim());
      final String gender = genderGroupBtn.getSelection().getActionCommand();
      final String phone = phoneField.getText().trim();
      final int polyId = (int) polyList.get(polyclinicComboBox.getSelectedIndex())[0];
      final String workerType = healthWorkerTypeComboBox.getSelectedItem().toString();

      final HashMap<String, Object> options = new HashMap<>();
      options.put("nama", name);
      options.put("umur", age);
      options.put("nomor_telepon", phone);
      options.put("jenis_nakes", workerType);
      options.put("jenis_kelamin", gender);
      options.put("id_poli", polyId);
      final boolean isSucess = healthWorkerHelper.insertData(id, options);
      if (!isSucess) {
        return;
      }
      this.loadData();
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
      final String id = healthWorkerIdField.getText().trim();
      final boolean isSucess = healthWorkerHelper.deleteDataById(id);
      if (!isSucess) {
        return;
      }
      this.loadData();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
      if (!isNumber(ageField.getText().trim())) {
        MessageUtil.showMessageDialog(this, "Umur harus berupa angka!", MessageType.ERROR);
        return;
      }
      if (!isDataValid()) {
        MessageUtil.showMessageDialog(this, "Mohon isi semua data terlebih dahulu!", MessageType.INFORMATION);
        return;
      }
      final String id = healthWorkerIdField.getText().trim();
      final String name = nameField.getText().trim();
      final int age = Integer.parseInt(ageField.getText().trim());
      final String gender = genderGroupBtn.getSelection().getActionCommand();
      final String phone = phoneField.getText().trim();
      final int polyId = (int) polyList.get(polyclinicComboBox.getSelectedIndex())[0];
      final String workerType = healthWorkerTypeComboBox.getSelectedItem().toString();

      final HashMap<String, Object> options = new HashMap<>();
      options.put("nama", name);
      options.put("umur", age);
      options.put("nomor_telepon", phone);
      options.put("jenis_nakes", workerType);
      options.put("jenis_kelamin", gender);
      options.put("id_poli", polyId);

      final boolean isSucess = healthWorkerHelper.updateData(id, options);
      if (!isSucess) {
        return;
      }
      this.loadData();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
      final int row = table.getSelectedRow();
      if (row < 0) {
        return;
      }
      final String id = healthWorkers.get(row)[0].toString();
      final String name = healthWorkers.get(row)[1].toString();
      final int age = ((int) healthWorkers.get(row)[2]);
      final String phone = healthWorkers.get(row)[3].toString();
      final String gender = healthWorkers.get(row)[4].toString();
      final String healthWorkerType = healthWorkers.get(row)[5].toString();
      final String polyclinic = healthWorkers.get(row)[6].toString();

      healthWorkerIdField.setText(id);
      nameField.setText(name);
      ageField.setText(String.valueOf(age));
      genderGroupBtn.setSelected(gender.equals("L") ? manRBtn.getModel() : womanRBtn.getModel(), true);

      phoneField.setText(phone);
      polyclinicComboBox.setSelectedItem(polyclinic);
      healthWorkerTypeComboBox.setSelectedItem(healthWorkerType);
    }//GEN-LAST:event_tableMouseClicked

  private boolean isDataValid() {
    return !healthWorkerIdField.getText().trim().isEmpty()
      && !nameField.getText().trim().isEmpty()
      && !ageField.getText().trim().isEmpty()
      && !phoneField.getText().trim().isEmpty();
  }

  @Override
  public void loadData() {
    try {
      healthWorkers.clear();
      final ResultSet resultSet = healthWorkerHelper.getAllData();
      while (resultSet.next()) {
        final Object[] data = new Object[]{
          resultSet.getString("id_nakes"),
          resultSet.getString("nama_nakes"),
          resultSet.getInt("umur"),
          resultSet.getString("nomor_telepon"),
          resultSet.getString("jenis_kelamin"),
          resultSet.getString("jenis_nakes"),
          resultSet.getString("nama_poli")};
        healthWorkers.add(data);
      }
      table.setModel(getUpdatedModel(table, healthWorkers));
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addBtn;
  private javax.swing.JTextField ageField;
  private javax.swing.JButton backBtn;
  private javax.swing.JButton deleteBtn;
  private javax.swing.ButtonGroup genderGroupBtn;
  private javax.swing.JTextField healthWorkerIdField;
  private javax.swing.JComboBox<String> healthWorkerTypeComboBox;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton manRBtn;
  private javax.swing.JTextField nameField;
  private javax.swing.JTextField phoneField;
  private javax.swing.JComboBox<String> polyclinicComboBox;
  private javax.swing.JTable table;
  private javax.swing.JButton updateBtn;
  private javax.swing.JRadioButton womanRBtn;
  // End of variables declaration//GEN-END:variables
}
