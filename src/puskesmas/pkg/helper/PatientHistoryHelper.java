package puskesmas.pkg.helper;

import puskesmas.pkg.enums.MessageType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import puskesmas.pkg.util.MessageUtil;

/**
 * @author Achmad Raihan
 */
public class PatientHistoryHelper extends Helper {

  public PatientHistoryHelper() {
    super("pemeriksaan");
  }

  public ResultSet getPatientById(String patientId) {
    try {
      this.createConnection();
      final String sql = "SELECT id, nama, umur, jenis_kelamin FROM pasien WHERE id = ?";
      final PreparedStatement ps = super.getConnection().prepareStatement(sql);
      ps.setString(1, patientId);
      ps.executeQuery();
      return ps.getResultSet();
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Maaf, terjadi kesalahan!\n" + exception.getMessage(), MessageType.ERROR);
      return null;
    } finally {
      this.closeConnection();
    }
  }

  @Override
  public ResultSet getDataById(String patientId) {
    try {
      this.createConnection();
      final String sql = "SELECT p.id_nakes, n.nama AS nama_nakes, diagnosis, tindakan, keluhan, id_resep_obat, tanggal_pemeriksaan FROM " + super.getTableName() + " p"
        + " INNER JOIN nakes n ON n.id = p.id_nakes "
        + " WHERE id_pasien = ? ORDER BY tanggal_pemeriksaan ASC";
      final PreparedStatement ps = super.getConnection().prepareStatement(sql);
      ps.setString(1, patientId);
      ps.executeQuery();
      return ps.getResultSet();
    } catch (SQLException exception) {
      System.err.println(exception.getMessage());
      MessageUtil.showMessageDialog(null, "Maaf, terjadi kesalahan!\n" + exception.getMessage(), MessageType.ERROR);
      return null;
    } finally {
      this.closeConnection();
    }
  }
}
