package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.helper.MedicineHelper;
import puskesmas.pkg.helper.PrecriptionDrugsHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import javax.swing.JPanel;
import puskesmas.pkg.App;
import puskesmas.pkg.util.IDGenerator;
import puskesmas.pkg.util.MessageUtil;
import static puskesmas.pkg.util.ValidationUtil.isNumber;

/**
 * @author Achmad Raihan
 */
public final class PrecriptionDrugsPanel extends JPanel implements PanelBase {

  private final ArrayList<Object[]> medicines;
  private final ArrayList<Object[]> basket;
  private final MedicineHelper medicineHelper;
  private final PrecriptionDrugsHelper precriptionDrugsHelper;
  private String recipeId;
  private final String patientId;
  private int amount = 0;
  private int totalPrice = 0;
  private int stock = 0;
  private int subtotal = 0;

  public PrecriptionDrugsPanel(Connection connection, String patientId) {
    medicineHelper = new MedicineHelper();
    precriptionDrugsHelper = new PrecriptionDrugsHelper();
    medicines = new ArrayList<>();
    basket = new ArrayList<>();
    this.patientId = patientId;

    initComponents();
    initializeMedicine();

    precriptionDrugsHelper.setConnection(connection);
    loadData();
    calculateTotal();
  }

  private void initializeMedicine() {
    try {
      medicines.clear();
      final ResultSet resultSet = medicineHelper.getAllData();
      while (resultSet.next()) {
        final Object[] data = {resultSet.getString("id"), resultSet.getString("nama"), resultSet.getInt("stock"), resultSet.getInt("harga")};
        medicines.add(data);
        medicineComboBox.addItem(data[1].toString());
      }
      medicineComboBox.setSelectedIndex(0);
      stock = (int) medicines.get(0)[2];
      stockLabel.setText(String.valueOf(stock));
    } catch (SQLException exception) {
      Logger.getLogger(PrecriptionDrugsPanel.class.getName()).log(Level.SEVERE, null, exception);
    }
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        medicineComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        removeBtn1 = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(880, 350));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Jumlah", "Subtotal"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        medicineComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Obat");

        jLabel3.setText("Jumlah");

        backBtn.setText("kembali");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        editBtn.setText("ubah");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        removeBtn1.setText("hapus");

        addBtn.setText("tambah");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Harga");

        totalPriceField.setEditable(false);
        totalPriceField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0"))));

        jLabel5.setText("Stok");

        stockLabel.setText("-");

        amountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        amountField.setValue(0);
        amountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(medicineComboBox, 0, 300, Short.MAX_VALUE)
                            .addComponent(amountField)
                            .addComponent(stockLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalPriceField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(addBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeBtn1)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medicineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeBtn1)
                            .addComponent(editBtn)
                            .addComponent(addBtn)
                            .addComponent(backBtn))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      App.getInstance().back();
    }//GEN-LAST:event_backBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
      if (!isNumber(amountField.getText().trim())) {
        MessageUtil.showMessageDialog(this, "Jumlah obat harus berupa angka!", MessageType.ERROR);
        return;
      }
      final HashMap<String, Object> options = new HashMap<>();
      final String medicineId = medicines.get(medicineComboBox.getSelectedIndex())[0].toString();
      options.put("id_obat", medicineId);
      options.put("jumlah_obat", amount);
      options.put("subtotal", subtotal);
      final boolean isUpdateSuccess = precriptionDrugsHelper.updateData(patientId, options);
      if (isUpdateSuccess) {
        MessageUtil.showMessageDialog(this, "Berhasil mengubah resep obat!", MessageType.INFORMATION);
        return;
      }
      MessageUtil.showMessageDialog(this, "Gagal mengubah resep obat!", MessageType.ERROR);
    }//GEN-LAST:event_editBtnActionPerformed

    private void medicineComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineComboBoxActionPerformed
      int index = medicineComboBox.getSelectedIndex();
      if (index == -1) {
        return;
      }
      stock = (int) medicines.get(index)[2];
      stockLabel.setText(String.valueOf(stock - amount));
    }//GEN-LAST:event_medicineComboBoxActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
      int row = table.getSelectedRow();
      if (row == -1) {
        return;
      }
      final String medicineName = table.getValueAt(row, 1).toString();
      medicineComboBox.setSelectedItem(medicineName);
      subtotal = (int) table.getValueAt(row, 4);
      amount = (int) table.getValueAt(row, 2);
      amountField.setText(String.valueOf(amount));
    }//GEN-LAST:event_tableMouseClicked

  private String genereateID() {
    return IDGenerator.generateID("RPO", 15);
  }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
      if (patientId == null) {
        MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan!", MessageType.ERROR);
        return;
      }

      if (!isNumber(amountField.getText().trim())) {
        MessageUtil.showMessageDialog(this, "Jumlah obat harus berupa angka!", MessageType.ERROR);
        return;
      }
      final int row = medicineComboBox.getSelectedIndex();
      if (recipeId == null) {
        recipeId = this.genereateID();
      }
      final String medicineId = medicines.get(row)[0].toString();
      final String name = medicines.get(row)[1].toString();
      final int currPrice = (int) medicines.get(row)[3];
      final int currentSubtotal = amount * currPrice;
      totalPrice += subtotal;
      stock -= amount;

      medicines.set(row, new Object[]{medicineId, name, stock, currPrice});
      final Object[] data = {medicineId, name, amount, currentSubtotal};
      final int index = this.getIndexOf(medicineId);
      final HashMap<String, Object> params = new HashMap<>();
      params.put("id_pasien", patientId);
      params.put("id_obat", medicineId);
      params.put("subtotal", currentSubtotal);
      if (index == -1) {
        basket.add(data);
        params.put("jumlah_obat", data[2]);
        precriptionDrugsHelper.insertData(recipeId, params);
      } else {
        data[2] = ((int) data[2]) + amount;
        basket.set(index, data);
        params.put("jumlah_obat", data[2]);
        precriptionDrugsHelper.updateData(recipeId, params);
      }
      totalPriceField.setValue(totalPrice);
      this.loadData();
      clearInputs();
    }//GEN-LAST:event_addBtnActionPerformed

  public String getRecipeId() {
    return recipeId;
  }
  
  public void calculateTotal() {
    totalPrice = 0;
    for (int i = 0; i < basket.size(); i++) {
      int data = (int) basket.get(i)[3];
      totalPrice += data;
    }
    totalPriceField.setValue(totalPrice);
  }

    private void amountFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountFieldKeyReleased
      if (!isNumber(amountField.getText())) {
        amountField.setValue(amount);
        stockLabel.setText(String.valueOf(stock - amount));
        return;
      }
      final int currentValue = Integer.parseInt(amountField.getText());
      if (currentValue < 0) {
        amountField.setValue(amount);
        stockLabel.setText(String.valueOf(stock - amount));
        return;
      }
      final int updatedStock = stock - currentValue;
      if (updatedStock < 0) {
        amountField.setValue(amount);
        stockLabel.setText(String.valueOf(stock - amount));
        return;
      }
      amount = currentValue;
      stockLabel.setText(String.valueOf(updatedStock));
    }//GEN-LAST:event_amountFieldKeyReleased

  private void clearInputs() {
    amountField.setText("0");
    stockLabel.setText(String.valueOf(stock));
  }

  private int getIndexOf(String medicineId) {
    for (int i = 0; i < basket.size(); i++) {
      final String currentId = basket.get(i)[0].toString();
      if (currentId.equals(medicineId)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public void loadData() {
    try {
      basket.clear();
      final ResultSet resultSet = precriptionDrugsHelper.getDataById(patientId);
      while (resultSet.next()) {
        final Object[] data = new Object[]{resultSet.getString("id_obat"), resultSet.getString("nama_obat"), resultSet.getInt("jumlah_obat"), resultSet.getInt("subtotal")};
        basket.add(data);
        if (recipeId == null) {
          recipeId = resultSet.getString("id_resep");
        }
      }
      table.setModel(getUpdatedModel(table, basket));
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JFormattedTextField amountField;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> medicineComboBox;
    private javax.swing.JButton removeBtn1;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JTable table;
    private javax.swing.JFormattedTextField totalPriceField;
    // End of variables declaration//GEN-END:variables
}
