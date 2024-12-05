package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.helper.BookingHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import puskesmas.pkg.App;
import puskesmas.pkg.util.MessageUtil;

/**
 * @author Achmad Raihan
 */
public final class BookingPanel extends JPanel implements PanelBase {

  private final ArrayList<Object[]> bookings;
  private final ArrayList<Object[]> polyList;
  private final BookingHelper bookingHelper;
  private final String[] patient = new String[2];

  public BookingPanel() {
    initComponents();
    bookings = new ArrayList<>();
    polyList = new ArrayList<>();
    bookingHelper = new BookingHelper();

    initializePoliList();
    this.loadData();
  }

  private void initializePoliList() {
    try {
      final ResultSet resultSet = bookingHelper.getPolyList();
      while (resultSet.next()) {
        final Object[] data = {resultSet.getInt("id"), resultSet.getString("nama")};
        polyList.add(data);
        polyclinicComboBox.addItem(data[1].toString());
      }
    } catch (SQLException exception) {
      Logger.getLogger(BookingPanel.class.getName()).log(Level.SEVERE, null, exception);
    }
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        patientIdField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        polyclinicComboBox = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setText("Pemesanan Nomor Antrian");

        jLabel2.setText("Id Pasien");

        jLabel3.setText("Nama Pasien");

        nameField.setEditable(false);

        searchBtn.setText("cari");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

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

        deleteBtn.setText("hapus semua");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor Antri", "Nama", "Poli"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setToolTipText("");
        table.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(table);

        jLabel4.setText("Poli");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(polyclinicComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn)
                        .addGap(48, 48, 48)
                        .addComponent(addBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(polyclinicComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn)
                            .addComponent(addBtn)
                            .addComponent(deleteBtn))
                        .addGap(29, 29, 29))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
      try {
        final String id = patientIdField.getText().trim();
        final ResultSet resultSet = bookingHelper.getPatientById(id);
        if (!resultSet.next()) {
          MessageUtil.showMessageDialog(this, "Pasien tidak ada!", MessageType.INFORMATION);
          return;
        }
        patient[0] = resultSet.getString("id");
        patient[1] = resultSet.getString("nama");
        nameField.setText(patient[1]);
      } catch (SQLException exception) {
        Logger.getLogger(BookingPanel.class.getName()).log(Level.SEVERE, null, exception);
      }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
      try {
        final String patientId = patient[0];
        final int poliId = (int) polyList.get(polyclinicComboBox.getSelectedIndex())[0];
        final boolean isSuccess = bookingHelper.insertData(patientId, poliId);
        if (!isSuccess) {
          MessageUtil.showMessageDialog(this, "Terjadi kesalahan!", MessageType.ERROR);
          return;
        }
        this.loadData();
        MessageUtil.showMessageDialog(this, "Berhasil menambahkan data!", MessageType.INFORMATION);
      } catch (NullPointerException exception) {
        MessageUtil.showMessageDialog(this, "Kamu harus mengisi id pasien terlebih dahulu.", MessageType.ERROR);
      }
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
      final int isConfirm = MessageUtil.showWarningDialog(this, "Data yang tersedia akan dihapus permanen, apakah tetap melanjutkan?");
      if (isConfirm != 0) {
        return;
      }
      bookingHelper.deleteAllData();
      this.loadData();
      MessageUtil.showMessageDialog(this, "Berhasil mereset!", MessageType.INFORMATION);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      App.getInstance().back();
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField patientIdField;
    private javax.swing.JComboBox<String> polyclinicComboBox;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

  @Override
  public void loadData() {
    try {
      bookings.clear();
      final ResultSet resultSet = bookingHelper.getAllData();
      while (resultSet.next()) {
        final Object[] data = new Object[]{resultSet.getString("nomor_antrian"), resultSet.getString("nama_pasien"), resultSet.getString("nama_poli")};
        bookings.add(data);
      }
      table.setModel(getUpdatedModel(table, bookings));
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }
}
