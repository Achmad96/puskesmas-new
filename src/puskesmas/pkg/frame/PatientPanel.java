package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.helper.PatientHelper;
import java.awt.Dimension;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JPanel;
import puskesmas.pkg.App;
import puskesmas.pkg.util.IDGenerator;
import puskesmas.pkg.util.MessageUtil;
import static puskesmas.pkg.util.ValidationUtil.isNumber;

/**
 * @author Achmad Raihan
 */
public final class PatientPanel extends JPanel implements PanelBase {

    private final ArrayList<Object[]> patients;
    private final PatientHelper patientHelper;
    private PatientHistoryPanel patientHistoryPanel;

    public PatientPanel() {
        initComponents();
        initializeRadioButtons();
        patients = new ArrayList<>();
        patientHelper = new PatientHelper();

        seeHistoryBtn.setVisible(false);
        this.generateID();
        this.loadData();
    }

    private void initializeRadioButtons() {
        this.manRBtn.setActionCommand("L");
        this.womanRBtn.setActionCommand("P");
        this.genderGroupBtn.setSelected(manRBtn.getModel(), true);

    }

    private void generateID() {
        patientIdField.setText(IDGenerator.generateID("PAS", 15));
    }

    @Override
    public void loadData() {
        try {
            patients.clear();
            final ResultSet resultSet = patientHelper.getAllData();
            while (resultSet.next()) {
                final Object[] data = new Object[]{
                    resultSet.getString("id"),
                    resultSet.getString("nama"),
                    resultSet.getInt("umur"),
                    resultSet.getString("jenis_kelamin"),
                    resultSet.getString("nomor_telepon"),
                    resultSet.getString("alamat"),};
                patients.add(data);
            }
            table.setModel(getUpdatedModel(table, patients));
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        genderGroupBtn = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        patientIdField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        manRBtn = new javax.swing.JRadioButton();
        womanRBtn = new javax.swing.JRadioButton();
        updateBtn = new javax.swing.JButton();
        seeHistoryBtn = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setText("Pasien");

        jLabel3.setText("Id Pasien");

        patientIdField.setEditable(false);

        jLabel4.setText("Nama Pasien");

        jLabel5.setText("Umur");

        jLabel6.setText("Nomor Telepon");

        jLabel7.setText("Alamat");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Umur", "Jenis Kelamin", "Nomor Telepon", "Alamat"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        backBtn.setText("kembali");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addBtn.setText("tambah");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("hapus");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Jenis Kelamin");

        genderGroupBtn.add(manRBtn);
        manRBtn.setText("Laki - laki");

        genderGroupBtn.add(womanRBtn);
        womanRBtn.setText("Perempuan");

        updateBtn.setText("ubah");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        seeHistoryBtn.setText("lihat riwayat");
        seeHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeHistoryBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8)
                                .addGap(68, 68, 68)
                                .addComponent(manRBtn)
                                .addGap(18, 18, 18)
                                .addComponent(womanRBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(backBtn)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seeHistoryBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(manRBtn)
                            .addComponent(womanRBtn)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addBtn)
                                .addComponent(deleteBtn)
                                .addComponent(updateBtn))
                            .addComponent(backBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(seeHistoryBtn)
                .addContainerGap(16, Short.MAX_VALUE))
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
        this.generateID();
        final String id = patientIdField.getText().trim();
        final String name = nameField.getText().trim();
        final int age = Integer.parseInt(ageField.getText().trim());
        final String phone = phoneField.getText().trim();
        final String address = addressField.getText().trim();
        final String gender = genderGroupBtn.getSelection().getActionCommand();

        final HashMap<String, Object> options = new HashMap<>();
        options.put("nama", name);
        options.put("umur", age);
        options.put("nomor_telepon", phone);
        options.put("alamat", address);
        options.put("jenis_kelamin", gender);
        final boolean isSucess = patientHelper.insertData(id, options);
        if (isSucess) {
            this.loadData();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        final String id = patientIdField.getText().trim();
        final boolean isSucess = patientHelper.deleteDataById(id);
        if (isSucess) {
            this.loadData();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if (!isNumber(ageField.getText().trim())) {
            MessageUtil.showMessageDialog(this, "Umur harus berupa angka!", MessageType.ERROR);
            return;
        }

        final String id = patientIdField.getText().trim();
        final String name = nameField.getText().trim();
        final int age = Integer.parseInt(ageField.getText().trim());
        final String phone = phoneField.getText().trim();
        final String address = addressField.getText().trim();
        final String gender = genderGroupBtn.getSelection().getActionCommand();

        final HashMap<String, Object> options = new HashMap<>();
        options.put("nama", name);
        options.put("umur", age);
        options.put("nomor_telepon", phone);
        options.put("alamat", address);
        options.put("jenis_kelamin", gender);
        final boolean isSucess = patientHelper.updateData(id, options);
        if (isSucess) {
            this.loadData();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        final int row = table.getSelectedRow();
        if (row < 0) {
            seeHistoryBtn.setVisible(false);
            return;
        }

        final String id = patients.get(row)[0].toString();
        final String name = patients.get(row)[1].toString();
        final int age = ((int) patients.get(row)[2]);
        final String gender = patients.get(row)[3].toString();
        final String phone = patients.get(row)[4].toString();
        final String address = patients.get(row)[5].toString();

        patientIdField.setText(id);
        nameField.setText(name);
        ageField.setText(String.valueOf(age));
        addressField.setText(address);
        switch (gender) {
            case "L" ->
                genderGroupBtn.setSelected(manRBtn.getModel(), true);
            case "P" ->
                genderGroupBtn.setSelected(womanRBtn.getModel(), true);
        }
        phoneField.setText(phone);
        seeHistoryBtn.setVisible(true);

        updateContainerSize();
    }//GEN-LAST:event_tableMouseClicked

    private Dimension currentSize;

    private void updateContainerSize() {
        if (currentSize == null) {
            currentSize = this.getPreferredSize();
            currentSize.height += 25;
        }
        setPreferredSize(currentSize);
        revalidate();
        repaint();
    }

    private void seeHistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeHistoryBtnActionPerformed
        final int row = table.getSelectedRow();
        if (row < 0) {
            patientHistoryPanel = null;
            seeHistoryBtn.setVisible(false);
            return;
        }

        final String patientId = patients.get(row)[0].toString();
        final String patientName = patients.get(row)[1].toString();
        final int patientAge = (int) patients.get(row)[2];
        final String patientGender = patients.get(row)[5].toString();

        if (patientHistoryPanel == null) {
            patientHistoryPanel = new PatientHistoryPanel(patientId, patientName, patientAge, patientGender);
            App.getInstance().switchPanelTo(patientHistoryPanel);
            return;
        }

        final String currentPatientId = patientHistoryPanel.getPatient()[0].toString();
        if (currentPatientId.equals(patientId)) {
            App.getInstance().switchPanelTo(patientHistoryPanel);
            return;
        }
        patientHistoryPanel = new PatientHistoryPanel(patientId, patientName, patientAge, patientGender);
        App.getInstance().switchPanelTo(patientHistoryPanel);
    }//GEN-LAST:event_seeHistoryBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField ageField;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.ButtonGroup genderGroupBtn;
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
    private javax.swing.JTextField patientIdField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton seeHistoryBtn;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBtn;
    private javax.swing.JRadioButton womanRBtn;
    // End of variables declaration//GEN-END:variables
}
