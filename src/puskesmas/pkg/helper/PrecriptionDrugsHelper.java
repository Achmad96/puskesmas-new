package puskesmas.pkg.helper;

import puskesmas.pkg.enums.MessageType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import puskesmas.pkg.util.MessageUtil;

/**
 * @author Achmad Raihan
 */
public class PrecriptionDrugsHelper extends Helper {

  public PrecriptionDrugsHelper() {
    super("resep_obat");
  }

  @Override
  public ResultSet getDataById(String patientId) {
    try {
      final String sql
        = "SELECT rpo.id AS id_resep, id_obat, o.nama AS nama_obat, jumlah_obat, subtotal FROM " + super.getTableName() + " rpo "
        + "INNER JOIN obat o ON o.id = rpo.id_obat WHERE rpo.id_pasien = ?";
      final PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, patientId);
      System.out.println(sql);
      return preparedStatement.executeQuery();
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Terjadi kesalahan, " + exception.getMessage(), MessageType.ERROR);
      return null;
    }
  }

  @Override
  public boolean insertData(String recipeId, HashMap<String, Object> options) {
    try {
      final String sql = processInsertParameter("id", options);
      final PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, recipeId);
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
    }
  }

  @Override
  public boolean updateData(String recipeId, HashMap<String, Object> options) {
    try {
      final String sql = processUpdateParameter("id_pasien", options);
      final PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
      int i = 1;
      for (Object value : options.values()) {
        if (!value.toString().trim().isEmpty()) {
          preparedStatement.setObject(i++, value);
        }
      }
      preparedStatement.setString(i, recipeId);
      System.out.println(sql);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Terjadi kesalahan, " + exception.getMessage(), MessageType.ERROR);
      return false;
    }
  }
}
