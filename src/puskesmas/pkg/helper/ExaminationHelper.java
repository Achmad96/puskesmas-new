package puskesmas.pkg.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 * @author Achmad Raihan
 */
public class ExaminationHelper extends Helper {

  public ExaminationHelper() {
    super("pemeriksaan");
  }

  @Override
  public void createConnection() {
    super.createConnection();
  }

  @Override
  public Connection getConnection() {
    return super.getConnection();
  }

  @Override
  public void closeConnection() {
    super.closeConnection();
  }

  public boolean insertData(String examinationId, HashMap<String, Object> params, HashMap<String, Object> params2) {
    try {
      super.setTableName("riwayat_pemeriksaan");
      String sql = processInsertParameter(params);
      PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, examinationId);
      int i = 2;
      for (Object parameter : params.values()) {
        preparedStatement.setObject(i++, parameter);
      }
      System.out.println(sql);
      preparedStatement.executeUpdate();

      super.setTableName("pemeriksaan");
      sql = processInsertParameter("id_pemeriksaan", params2);
      preparedStatement = super.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, examinationId);
      preparedStatement.setObject(2, params2.get("nomor_antrian"));
      System.out.println(sql);
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException exception) {
      System.err.println("Terjadi kesalahan, " + exception.getMessage());
      return false;
    }
  }

  public ResultSet getPatientByQueueNumber(int queueNumber) {
    try {
      final String sql
          = "SELECT p.id AS id_pasien, p.nama AS nama_pasien, pna.id AS nomor_antrian, id_poli, poli.nama AS nama_poli FROM pemesanan_nomor_antrian pna "
          + "INNER JOIN pasien p ON pna.id_pasien = p.id "
          + "INNER JOIN poli ON poli.id = pna.id_poli "
          + "WHERE pna.id = ?";
      final PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
      preparedStatement.setInt(1, queueNumber);
      preparedStatement.executeQuery();
      return preparedStatement.getResultSet();
    } catch (SQLException exception) {
      System.err.println("Terjadi kesalahan, " + exception.getMessage());
      return null;
    }
  }

  public ResultSet getHealthWorkersByPolyId(int polyId) {
    try {
      final String sql
          = "SELECT n.id AS id_nakes, n.nama AS nama_nakes, id_poli, p.nama AS nama_poli FROM nakes n"
          + " INNER JOIN poli p ON p.id = id_poli"
          + " WHERE id_poli = ? AND LOWER(jenis_nakes) = 'dokter'";
      final PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
      preparedStatement.setInt(1, polyId);
      preparedStatement.executeQuery();
      return preparedStatement.getResultSet();
    } catch (SQLException exception) {
      System.err.println("Terjadi kesalahan, " + exception.getMessage());
      return null;
    }
  }

}
