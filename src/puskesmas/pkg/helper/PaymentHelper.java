package puskesmas.pkg.helper;

import puskesmas.pkg.enums.MessageType;
import puskesmas.pkg.util.MessageUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Achmad Raihan
 */
public class PaymentHelper extends Helper {

  public PaymentHelper() {
    super("pembayaran");
  }

  @Override
  public ResultSet getDataById(String recipeId) {
    try {
      this.createConnection();
      final String sql
        = "SELECT ro.id_obat AS id_obat, o.nama AS nama_obat, jumlah_obat, satuan, subtotal FROM resep_obat ro "
        + "INNER JOIN obat o ON o.id = ro.id_obat "
        + "WHERE id_pasien = ?";
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      System.out.println(sql);
      preparedStatement.setString(1, recipeId);
      preparedStatement.executeQuery();
      return preparedStatement.getResultSet();
    } catch (SQLException exception) {
      System.out.println("Terjadi kesalahan, " + exception.getMessage());
      return null;
    } finally {
      this.closeConnection();
    }
  }

  public boolean insertPayment(String id, HashMap<String, Object> options) {
    try {
      this.createConnection();
      final String sql = super.processInsertParameter(options);
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, id);
      int i = 2;
      for (Object value : options.values()) {
        preparedStatement.setObject(i++, value);
      }
      System.out.println(sql);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Terjadi kesalahan, " + exception.getMessage(), MessageType.ERROR);
      return false;
    } finally {
      this.closeConnection();
    }
  }

  public boolean insertPaymentDetails(ArrayList<HashMap<String, Object>> params) {
    try {
      this.createConnection();
      final String sql = this.processPaymentDetailsParams(params);
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      System.out.println(sql);
      int i = 1;
      for (HashMap<String, Object> param : params) {
        preparedStatement.setObject(i++, param.get("id"));
        preparedStatement.setObject(i++, param.get("id_obat"));
        preparedStatement.setObject(i++, param.get("jumlah_obat"));
        preparedStatement.setObject(i++, param.get("subtotal"));
      }
      return preparedStatement.executeUpdate() > 0;
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Terjadi kesalahan, " + exception.getMessage(), MessageType.ERROR);
      return false;
    } finally {
      this.closeConnection();
    }
  }

  public int getUpdatedMedicineStock(String medicineId) {
    try {
      this.createConnection();
      final String sql = "SELECT stock FROM obat WHERE id = ?";
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      System.out.println(sql);
      preparedStatement.setString(1, medicineId);
      preparedStatement.executeQuery();
      final ResultSet resultSet = preparedStatement.getResultSet();
      resultSet.next();
      return resultSet.getInt("stock");
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Terjadi kesalahan, " + exception.getMessage(), MessageType.ERROR);
      return -1;
    } finally {
      this.closeConnection();
    }
  }

  public boolean updateMedicineStock(ArrayList<HashMap<String, Object>> params) {
    try {
      this.createConnection();
      final String sql = this.processUpdatingMedicine(params);
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      System.out.println(sql);
      int i = 1;
      for (HashMap<String, Object> param : params) {
        preparedStatement.setObject(i++, param.get("id"));
        preparedStatement.setObject(i++, param.get("stock"));
      }
      for (HashMap<String, Object> param : params) {
        preparedStatement.setObject(i++, param.get("id"));
      }
      return preparedStatement.executeUpdate() > 0;
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Terjadi kesalahan, " + exception.getMessage(), MessageType.ERROR);
      return false;
    } finally {
      this.closeConnection();
    }
  }

  private String processUpdatingMedicine(ArrayList<HashMap<String, Object>> params) {
    final StringBuilder stringBuilder = new StringBuilder("UPDATE obat SET stock = CASE ");
    for (HashMap<String, Object> _ : params) {
      stringBuilder.append("\nWHEN id = ? THEN ? ");
    }
    stringBuilder.append("\nELSE stock\nEND\n").append("WHERE id IN (");
    for (int i = 0; i < params.size(); i++) {
      stringBuilder.append("?");
      if (i < (params.size() - 1)) {
        stringBuilder.append(",");
      }
    }
    stringBuilder.append(")");
    return stringBuilder.toString();
  }

  private String processPaymentDetailsParams(ArrayList<HashMap<String, Object>> params) {
    final StringBuilder stringBuilder = new StringBuilder("INSERT INTO detail_pembayaran(id, id_obat, jumlah_obat, subtotal) VALUES ");
    for (int i = 0; i < params.size(); i++) {
      stringBuilder.append("(?, ?, ?, ?)");
      if (i < (params.size() - 1)) {
        stringBuilder.append(",");
      }
    }
    return stringBuilder.toString();
  }
}
