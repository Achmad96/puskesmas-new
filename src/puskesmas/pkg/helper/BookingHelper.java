package puskesmas.pkg.helper;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Achmad Raihan
 */
public class BookingHelper extends Helper {

  public BookingHelper() {
    super("pemesanan_nomor_antrian");
  }

  public ResultSet getPatientById(String id) {
    try {
      this.createConnection();
      final String sql = "SELECT id, nama FROM pasien WHERE id = ?";
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, id);
      preparedStatement.executeQuery();
      return preparedStatement.getResultSet();
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
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

  @Override
  public ResultSet getAllData() {
    try {
      this.createConnection();
      final String sql
        = "SELECT pna.id AS nomor_antrian, p.nama AS nama_pasien, poli.nama AS nama_poli FROM pemesanan_nomor_antrian pna "
        + "INNER JOIN pasien p ON p.id = pna.id_pasien "
        + "INNER JOIN poli ON poli.id = pna.id_poli";
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

  @Override
  public int deleteAllData() {
    final int result = super.deleteAllData();
    this.resetAutoIncrement();
    return result;
  }

  private void resetAutoIncrement() {
    try {
      this.createConnection();
      final String sql = "ALTER SEQUENCE pemesanan_nomor_antrian_nomor_antrian_seq RESTART WITH 1";
      final PreparedStatement ps = this.getConnection().prepareStatement(sql);
      ps.execute();
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
    } finally {
      this.closeConnection();
    }
  }

  public boolean insertData(String patientId, int poliId) {
    try {
      this.createConnection();
      final String sql = "INSERT INTO pemesanan_nomor_antrian(id_pasien, id_poli) VALUES(?, ?)";
      final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, patientId);
      preparedStatement.setInt(2, poliId);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      return false;
    } finally {
      this.closeConnection();
    }
  }

}
