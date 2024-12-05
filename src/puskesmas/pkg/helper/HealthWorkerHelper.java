package puskesmas.pkg.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Achmad Raihan
 */
public class HealthWorkerHelper extends Helper {

  public HealthWorkerHelper() {
    super("nakes");
  }

  @Override
  public ResultSet getAllData() {
    try {
      this.createConnection();
      final String sql
        = "SELECT n.id AS id_nakes, n.nama AS nama_nakes, umur, nomor_telepon, jenis_kelamin, jenis_nakes, p.nama AS nama_poli FROM " + super.getTableName() + " n "
        + "INNER JOIN poli p ON p.id = n.id_poli ORDER BY id_nakes";
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      System.out.println(sql);
      return preparedStatement.executeQuery();
    } catch (SQLException exception) {
      System.out.println("Terjadi kesalahan, " + exception.getMessage());
      return null;
    } finally {
      this.closeConnection();
    }
  }

  public ResultSet getPolyList() {
    try {
      this.createConnection();
      final String sql = "SELECT * FROM poli ORDER BY id";
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      preparedStatement.executeQuery();
      return preparedStatement.getResultSet();
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      return null;
    } finally {
      this.closeConnection();
    }
  }

}
