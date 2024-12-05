package puskesmas.pkg.frame;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.exception.ReportGenerationException;
import puskesmas.pkg.helper.PaymentHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import puskesmas.pkg.App;
import puskesmas.pkg.util.IDGenerator;
import puskesmas.pkg.util.MessageUtil;
import puskesmas.pkg.util.TemplateGenerator;

/**
 * @author Achmad Raihan
 */
public class PaymentPanel extends JPanel implements PanelBase {

  private final PaymentHelper paymentHelper;
  private final ArrayList<Object[]> basket;
  private TemplateGenerator paymentReceiptGenerator;
  private String patientId;
  private int totalPrice;

  public PaymentPanel() {
    initComponents();
    basket = new ArrayList<>();
    paymentHelper = new PaymentHelper();
  }

  private String generateID() {
    return IDGenerator.generateID("PAY", 15);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBtn = new javax.swing.JButton();
        patientIdField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();

        searchBtn.setText("cari");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Jumlah", "Satuan", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        backBtn.setText("kembali");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        payBtn.setText("bayar");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(patientIdField)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(payBtn))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      App.getInstance().back();
      if (basket != null) {
        basket.clear();
        table.setModel(getUpdatedModel(table, basket));
      }
    }//GEN-LAST:event_backBtnActionPerformed

  public void calculateTotal() {
    totalPrice = 0;
    for (int i = 0; i < basket.size(); i++) {
      int data = (int) basket.get(i)[4];
      totalPrice += data;
    }
  }

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
      try {
        final String paymentId = this.generateID();
        final HashMap<String, Object> paymentParams = new HashMap<>();
        calculateTotal();
        paymentParams.put("id_pasien", patientId);
        paymentParams.put("total_harga", totalPrice);

        if (patientId == null) {
          MessageUtil.showMessageDialog(this, "Tolong konfirmasi pasien terlebih dahulu...", MessageType.INFORMATION);
          return;
        }

        boolean isContinue = MessageUtil.showConfirmDialog(this, "Apakah lanjutkan pembayaran?") == 0;
        if (!isContinue) {
          return;
        }

        paymentHelper.insertData(paymentId, paymentParams);
        final ArrayList<HashMap<String, Object>> paymentDetails = new ArrayList<>();
        final ArrayList<HashMap<String, Object>> medicineStocks = new ArrayList<>();
        for (int i = 0; i < basket.size(); i++) {
          final HashMap<String, Object> params = new HashMap<>();
          final String currentMedicineId = basket.get(i)[0].toString();
          final int currentAmount = (int) basket.get(i)[2];
          final int currentSubtotal = (int) basket.get(i)[4];
          final int currentUpdatedStock = paymentHelper.getUpdatedMedicineStock(currentMedicineId);

          params.put("id", paymentId);
          params.put("id_obat", currentMedicineId);
          params.put("jumlah_obat", currentAmount);
          params.put("subtotal", currentSubtotal);
          paymentDetails.add(params);

          final HashMap<String, Object> params2 = new HashMap<>();
          params2.put("id", currentMedicineId);
          params2.put("stock", currentUpdatedStock - currentAmount);
          medicineStocks.add(params2);
        }
        paymentHelper.updateMedicineStock(medicineStocks);
        paymentHelper.insertPaymentDetails(paymentDetails);
        MessageUtil.showMessageDialog(this, "Berhasil membayar!", MessageType.INFORMATION);
        clearData();
        if (paymentReceiptGenerator == null) {
          paymentReceiptGenerator = new TemplateGenerator();
        }
        paymentReceiptGenerator.printReceipt(paymentId);
      } catch (ReportGenerationException exception) {
        Logger.getLogger(PaymentHelper.class.getName()).log(Level.SEVERE, null, exception);
        MessageUtil.showMessageDialog(this, "Gagal membayar!", MessageType.ERROR);
      }

    }//GEN-LAST:event_payBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
      this.loadData();
    }//GEN-LAST:event_searchBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField patientIdField;
    private javax.swing.JButton payBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

  private void clearData() {
    basket.clear();
    table.setModel(getUpdatedModel(table, basket));
  }

  @Override
  public void loadData() {
    try {
      basket.clear();
      final String recipeId = patientIdField.getText().trim();
      this.patientId = patientIdField.getText().trim();
      final ResultSet resultSet = paymentHelper.getDataById(recipeId);
      if(resultSet == null) {
        MessageUtil.showMessageDialog(this, "Pasien tidak ditemukan", MessageType.ERROR);
        return;
      }
      while (resultSet.next()) {
        final Object[] data = new Object[]{resultSet.getString("id_obat"), resultSet.getString("nama_obat"), resultSet.getInt("jumlah_obat"), resultSet.getString("satuan"), resultSet.getInt("subtotal")};
        basket.add(data);
      }
      table.setModel(getUpdatedModel(table, basket));
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }
}
